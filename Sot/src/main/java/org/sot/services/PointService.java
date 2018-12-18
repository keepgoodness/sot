package org.sot.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import org.hibernate.exception.ConstraintViolationException;
import org.modelmapper.Condition;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.modelmapper.spi.MappingContext;
import org.sot.converters.BooleanConverter;
import org.sot.enums.LifeStatus;
import org.sot.enums.SseStatus;
import org.sot.enums.TypeSearch;
import org.sot.exceptions.ExistingIdentifierException;
import org.sot.exceptions.ExistingPointException;
import org.sot.models.bindings.PointAtrBindingModel;
import org.sot.models.entities.Address;
import org.sot.models.entities.Point;
import org.sot.models.bindings.PointBindingModel;
import org.sot.models.entities.Company;
import org.sot.models.entities.Mrp;
import org.sot.models.entities.Place;
import org.sot.models.entities.Recipient;
import org.sot.models.entities.Street;
import org.sot.repositories.AddressRepository;
import org.sot.repositories.CompanyRepository;
import org.sot.repositories.Pointrepository;
import org.sot.repositories.StreetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Jordan
 */
@Service
public class PointService {

	private final AddressRepository addressRepository;
	private final Pointrepository pointrepository;
	private final StreetRepository streetRepository;
	private final CompanyRepository companyRepository;
	private ModelMapper modelMapper;

	@Autowired
	public PointService(AddressRepository addressRepository, Pointrepository pointrepository, StreetRepository streetRepository, ModelMapper modelMapper, CompanyRepository companyRepository) {
		this.addressRepository = addressRepository;
		this.pointrepository = pointrepository;
		this.streetRepository = streetRepository;
		this.modelMapper = modelMapper;
		this.companyRepository = companyRepository;
	}

//	@Transactional()
//	public boolean register(PointBindingModel bindingModel) {
//		Address address = bindingModel.getAddress();
//		ControlBoard controlBoard = bindingModel.getControlBoard();
//		Point point = new Point();
//		point.setName(bindingModel.getPoint().getName());
//		point.setIdentifier(bindingModel.getPoint().getIdentifier());
//		point.setAddress(address);
////	point.setControlBoard(controlBoard);
//		point.setLat(Double.parseDouble(bindingModel.getLatitude()));
//		point.setLng(Double.parseDouble(bindingModel.getLongitude()));
//		addressRepository.save(address).getId();
//		controlBoardRepository.save(controlBoard);
//		if (null == pointrepository.save(point).getId()) {
//			return false;
//		}
//		return true;
//	}
	public JsonObject getPointsAsJsonArray() {
		List<Object[]> arrayObj = this.pointrepository.findAllWithIdLatLng();
		JsonArrayBuilder array = Json.createArrayBuilder();
		for (int i = 0; i < arrayObj.size(); i++) {
			JsonObjectBuilder objBuilder = Json.createObjectBuilder();
			objBuilder.add("id", arrayObj.get(i)[0].toString());
			objBuilder.add("lat", arrayObj.get(i)[1].toString());
			objBuilder.add("lng", arrayObj.get(i)[2].toString());
			objBuilder.add("name", arrayObj.get(i)[3].toString());
			array.add(objBuilder);
		}
		JsonObject json = Json.createObjectBuilder()
				.add("point", array).build();
		return json;
	}

	public List<JsonObject> getPointsAutocomplete(String dataSearch, TypeSearch typeSearch) {
		List<Object[]> points = new ArrayList<>();
		switch (typeSearch) {
			case NAME:
				points = pointrepository.findByName(dataSearch);
				break;
			case IDENTIFIER:
				points = pointrepository.findByIdentifier(dataSearch);
				break;
		}
		List<JsonObject> array = new ArrayList<>();
		points.stream().forEach(p -> {
			JsonObjectBuilder objBuilder = Json.createObjectBuilder();
			objBuilder.add("id", p[0].toString());
			objBuilder.add("name", p[1].toString());
			array.add(objBuilder.build());
		});
		return array;
	}

	public void deletePoint(Long id) {
		Optional<Point> findByIdOpt = pointrepository.findById(id);
		if (findByIdOpt.isPresent()) {
			pointrepository.deleteById(id);
		}
	}

	@Transactional //в разработка
	public boolean createPoint(PointAtrBindingModel bindingModel) throws ExistingPointException, ExistingIdentifierException {
		System.out.println( "companyVatCode:" + bindingModel.getCompanyVatCode() + ":");
		System.out.println("responsiblePerson" + bindingModel.getResponsiblePersons().size()+":");
		Point point = this.modelMapper.map(bindingModel, Point.class);
		Optional<Point> findOneByName = this.pointrepository.findOneByName(point.getName());
		if (findOneByName.isPresent()) {
			throw new ExistingPointException("Вече съществува обект с име " + point.getName());
		}
		if (this.pointrepository.findOneByIdentifier(point.getIdentifier()).isPresent()) {
			throw new ExistingIdentifierException("Вече съществува обект с код " + point.getIdentifier());
		}
		// point address-street
		String pointStreetName = point.getAddress().getStreet().getName();
		// company address-street
		String companyStreetName = (point.getCompany() != null) ? point.getCompany().getAddress().getStreet().getName() : "";
		System.out.println("companyStreetName:" + companyStreetName);
		Optional<Street> pointDbStreet = this.streetRepository.findOneByName(pointStreetName);
		Street newStreetSaved = null;
		if (pointDbStreet.isPresent()) {
			System.out.println("1.улицата на обекта съществува!");
			point.getAddress().setStreet(pointDbStreet.get());
			if (!companyStreetName.isEmpty()) {
				if (companyStreetName.toLowerCase().equals(pointDbStreet.get().getName().toLowerCase())) {
					System.out.println("1.1.Съвпада с името на улицата на фирмата!");
					point.getCompany().getAddress().setStreet(pointDbStreet.get());
				} else {
					System.out.println("1.2.Двете улици са с различни имена!");
					Optional<Street> companyStrOpt = this.streetRepository.findOneByName(companyStreetName);
					if (companyStrOpt.isPresent()) {
						System.out.println("1.2.1 Но името на фирмата съществува!");
						point.getCompany().getAddress().setStreet(companyStrOpt.get());
					} else {
						System.out.println("1.2.2 Името на фирмата не съществува и създаваме нова!");
						point.getCompany().getAddress().setStreet(new Street(companyStreetName, LifeStatus.EXISTING));
					}
				}
			}
		} else {
			Street newPStreet = new Street(pointStreetName, LifeStatus.EXISTING);
			System.out.println("2. Създаваме нова улица/flush и я сетваме на обекта");
			newStreetSaved = this.streetRepository.saveAndFlush(newPStreet);
			point.getAddress().setStreet(newStreetSaved);
			if (!companyStreetName.isEmpty()) {
				if (companyStreetName.toLowerCase().equals(newStreetSaved.getName().toLowerCase())) {
					System.out.println("2.1. Съвпада с името на улицата на фирмата!");
					point.getCompany().getAddress().setStreet(newStreetSaved);
				} else {
					Optional<Street> companyStrOpt = this.streetRepository.findOneByName(companyStreetName);
					System.out.println("2.2.НЕ съвпада с името на улицата на фирмата!");
					if (companyStrOpt.isPresent()) {
						System.out.println("2.2.1 Но името на фирмата съществува!");
						point.getCompany().getAddress().setStreet(companyStrOpt.get());
					} else {
						System.out.println("2.2.2 Името на фирмата не съществува и създаваме нова!");
						point.getCompany().getAddress().setStreet(new Street(companyStreetName, LifeStatus.EXISTING));
					}
				}
			}
		}
		System.out.println("3. Записваме обекта!");
		this.pointrepository.save(point);
		return true;
	}
//	

	public boolean addCompany(PointAtrBindingModel bindingModel) throws JsonProcessingException {
		Company company = this.modelMapper.map(bindingModel, Company.class);
		if (company != null) {
			ObjectMapper objectMapper = new ObjectMapper();
			String jsonString = objectMapper.writeValueAsString(company);
			System.out.println(jsonString);
		}

		return true;
	}
}
