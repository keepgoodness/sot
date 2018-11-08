package org.sot.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.servlet.http.HttpServletRequest;
import org.sot.converters.TypeSearchConverter;
import org.sot.enums.TypeSearch;
import org.sot.models.bindings.PointBindingModel;
import org.sot.models.entities.PhoneNumber;
import org.sot.models.entities.Point;
import org.sot.models.entities.ResponsiblePerson;
import org.sot.repositories.AddressRepository;
import org.sot.repositories.PhoneNumberRepository;
import org.sot.repositories.Pointrepository;
import org.sot.repositories.ResponsiblePersonRepository;
import org.sot.services.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Jordan
 */
@Controller
public class HomeController {

	private final PointService pointService;
	private final Pointrepository pointrepository;
	private final TypeSearchConverter searchConverter;
	private final AddressRepository addressRepository;
	private final ResponsiblePersonRepository personRepository;

	@Autowired
	

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		dataBinder.registerCustomEditor(TypeSearch.class, this.searchConverter);
	}

	public HomeController(PointService pointService, Pointrepository pointrepository, TypeSearchConverter searchConverter, AddressRepository addressRepository, ResponsiblePersonRepository personRepository) {
		this.pointService = pointService;
		this.pointrepository = pointrepository;
		this.searchConverter = searchConverter;
		this.addressRepository = addressRepository;
		this.personRepository = personRepository;
	}

	@GetMapping("/")
	public String home(Model model) {
		PointBindingModel pointModel = new PointBindingModel();
		model.addAttribute("title", "Карти");
		model.addAttribute("allPoints", pointService.getPointsAsJsonArray().toString());
		model.addAttribute("pointBindingModel", pointModel);
		return "index";
	}

	@ResponseBody
	@GetMapping(value = "/point", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String getPointJson(@RequestParam("id") String id, Model model) {
		return pointrepository.findPointById(Long.parseLong(id)).toString();
	}

	@ResponseBody
	@GetMapping(value = "/search-autocomplete", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String getAllPointsIdNameJson(@RequestParam String dataSearch, @RequestParam TypeSearch typeSearch) {
		return pointService.getPointsAutocomplete(dataSearch, typeSearch).toString();
	}

	@GetMapping(value = "/point-delete/{id}")
	public String delete(@PathVariable String id) {
		Point point = pointrepository.getOne(Long.parseLong(id));
		System.out.println(point.toString());
//		pointService.deletePoint(Long.parseLong(id));
		return "redirect:/";
	}

//	@GetMapping(value = "/phones")
//	@ResponseBody
//	public String testPhones() {
////		ResponsiblePerson person = new ResponsiblePerson();
////		person.setFirstName("йордан");
////		person.setLastName("lazarov");
////		
////		Set<PhoneNumber> numbers = new HashSet<>();
////		
////		numbers.add(new PhoneNumber("0898857554"));
////		numbers.add(new PhoneNumber("0887401253"));
////		person.setPhoneNumbers(numbers);
//////		
////		ResponsiblePerson saved = personRepository.save(person);
////		return System.getProperty("java.version");
////		ResponsiblePerson person = personRepository.findOneById(53l);
////		person.getPhoneNumbers().add(new PhoneNumber("0897334455"));
////		ResponsiblePerson saved = personRepository.save(person);
////		return saved.getPhoneNumbers().toString();
//		return numberRepository.findById(61l).get().getNumber();
//	}

}
