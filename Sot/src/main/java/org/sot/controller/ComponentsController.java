package org.sot.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.modelmapper.ModelMapper;
import org.sot.enums.SensorType;
import org.sot.models.entities.Brand;
import org.sot.models.entities.Point;
import org.sot.models.entities.Sensor;
import org.sot.models.wrappers.PointComponentsRequest;
import org.sot.repositories.BrandRepository;
import org.sot.repositories.ControlBoardRepository;
import org.sot.repositories.Pointrepository;
import org.sot.repositories.SensorRepository;
import org.sot.services.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Jordan
 */
@Controller
public class ComponentsController {

    private final Pointrepository pointrepository;
    private final SensorRepository sensorRepository;
    private final ControlBoardRepository boardRepository;
    private final BrandRepository brandRepository;

    private final SensorService sensorService;
    private final ModelMapper mapper;

    @Autowired
    public ComponentsController(Pointrepository pointrepository, SensorRepository sensorRepository, ControlBoardRepository boardRepository, BrandRepository brandRepository, SensorService sensorService, ModelMapper mapper) {
        this.pointrepository = pointrepository;
        this.sensorRepository = sensorRepository;
        this.boardRepository = boardRepository;
        this.brandRepository = brandRepository;
        this.sensorService = sensorService;
        this.mapper = mapper;
    }

    @ModelAttribute(name = "brands")
    private List<Brand> brands() {
        List<Brand> brands = brandRepository.findAll();
        brands.forEach(b -> b.setName(b.getName().toUpperCase()));
        brands.sort(new Comparator<Brand>() {
            @Override
            public int compare(Brand o1, Brand o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        return brands;
    }

    @GetMapping("/components_add/{id}")
    public String componentsAdd(@PathVariable("id") String id, Model model) throws JsonProcessingException {
        Point point = pointrepository.findById(Long.parseLong(id)).get();

        model.addAttribute("point", point);
        return "components/components-add";
    }

    @PostMapping("/components-add")
    public @ResponseBody
    String insertComponents(@RequestBody PointComponentsRequest components) {
        //		https://www.codejava.net/frameworks/hibernate/hibernate-many-to-many-association-with-extra-columns-in-join-table-example
        String pointId = components.getPointId();
        List<String> sensorsId = components.getSensorsId();
        List<String> controlBoardsId = components.getControlBoardsId();
        
		System.out.println("pointId: " + pointId);
        sensorsId.forEach(el-> System.out.println("sensorId: " + el));
		controlBoardsId.forEach(el-> System.out.println("controlBoardId: " + el));
        return "";
    }

    @PostMapping(value = "/api/components-add", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public List<Sensor> getModels(HttpEntity<String> httpEntity) throws IOException {
        String json = httpEntity.getBody();
        ObjectMapper mapper = new ObjectMapper();
        JsonNode obj = mapper.readTree(json);

        return sensorService.getSensorsByTypeAndBrand(
                SensorType.valueOf(obj.get("sensorType").textValue()),
                obj.get("brandId").textValue());
    }
}
