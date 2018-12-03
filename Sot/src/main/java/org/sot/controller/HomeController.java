package org.sot.controller;

import org.sot.converters.TypeSearchConverter;
import org.sot.enums.TypeSearch;
import org.sot.models.bindings.PointBindingModel;
import org.sot.models.entities.Company;
import org.sot.models.entities.Point;
import org.sot.repositories.Pointrepository;
import org.sot.services.CompanyService;
import org.sot.services.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Jordan
 */
@Controller
public class HomeController {

    private final PointService pointService;
    private final Pointrepository pointrepository;
    private final TypeSearchConverter searchConverter;
    private final CompanyService companyService;

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.registerCustomEditor(TypeSearch.class, this.searchConverter);
    }

    @Autowired
    public HomeController(PointService pointService, Pointrepository pointrepository, TypeSearchConverter searchConverter, CompanyService companyService) {
        this.pointService = pointService;
        this.pointrepository = pointrepository;
        this.searchConverter = searchConverter;
        this.companyService = companyService;
    }

    @GetMapping(value = "/")
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

//    @GetMapping(value = "/company", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    @ResponseBody
//    public Company adsCompany() {
////        Company savedCompany = companyService.saveCompany();
//
//        return savedCompany;
//    }

}
