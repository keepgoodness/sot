package org.sot.services;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import org.hibernate.exception.ConstraintViolationException;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.sot.converters.BooleanConverter;
import org.sot.enums.LifeStatus;
import org.sot.enums.SseStatus;
import org.sot.enums.TypeSearch;
import org.sot.exceptions.ExistingIdentifierException;
import org.sot.exceptions.ExistingPointException;
import org.sot.models.bindings.PointAtrBindingModel;
import org.sot.models.entities.Address;
import org.sot.models.entities.ControlBoard;
import org.sot.models.entities.Point;
import org.sot.models.bindings.PointBindingModel;
import org.sot.models.entities.Place;
import org.sot.models.entities.Street;
import org.sot.repositories.AddressRepository;
import org.sot.repositories.ControlBoardRepository;
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
    private final ControlBoardRepository controlBoardRepository;
    private final StreetRepository streetRepository;
    private ModelMapper modelMapper;

    @Autowired
    public PointService(AddressRepository addressRepository, Pointrepository pointrepository, ControlBoardRepository controlBoardRepository, StreetRepository streetRepository, ModelMapper modelMapper) {
        this.addressRepository = addressRepository;
        this.pointrepository = pointrepository;
        this.controlBoardRepository = controlBoardRepository;
        this.streetRepository = streetRepository;
        this.modelMapper = modelMapper;
    }

//	@Transactional()
//	public boolean register(PointBindingModel bindingModel) {
//		Address address = bindingModel.getAddress();
//		ControlBoard controlBoard = bindingModel.getControlBoard();
//		Point point = new Point();
//		point.setName(bindingModel.getPoint().getName());
//		point.setIdentifier(bindingModel.getPoint().getIdentifier());
//		point.setAddress(address);
////		point.setControlBoard(controlBoard);
//		point.setLat(Double.parseDouble(bindingModel.getLatitude()));
//		point.setLng(Double.parseDouble(bindingModel.getLongitude()));
//		addressRepository.save(address).getId();
//		controlBoardRepository.save(controlBoard);
//		if (null == pointrepository.save(point).getId()) {
//			return false;
//		}
//		return true;
//	}
    @Transactional //в разработка
    public boolean registerNew(PointAtrBindingModel bindingModel) throws ExistingPointException, ExistingIdentifierException {
        Point point = this.modelMapper.map(bindingModel, Point.class);
        if (this.pointrepository.findOneByName(point.getName()).isPresent()) {
            throw new ExistingPointException("Вече съществува обект с име " + point.getName());
        }
        if (this.pointrepository.findOneByIdentifier(point.getIdentifier()).isPresent()) {
            throw new ExistingIdentifierException("Вече съществува обект с код " + point.getIdentifier());
        }
        
        Street street = point.getAddress().getStreet();
        Optional<Street> dbStreet = this.streetRepository.findOneByName(street.getName());
        
        if (dbStreet.isPresent()) {
            point.getAddress().setStreet(dbStreet.get());
        } else {
            point.getAddress().setStreet(new Street(street.getName(), LifeStatus.EXISTING));
        }
        this.pointrepository.save(point);
        return true;
    }

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
        pointrepository.deleteById(id);
    }

}
