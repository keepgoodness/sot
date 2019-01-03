package org.sot.controller;

import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.sot.models.bindings.ControlBoardBindModel;
import org.sot.models.entities.Brand;
import org.sot.repositories.BrandRepository;
import org.sot.services.ControlBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Jordan
 */
@Controller
public class ControlBoardController {

	private final HttpServletRequest request;
	private final BrandRepository brandRepo;
	private final ControlBoardService cbservice;

	@Autowired
	public ControlBoardController(BrandRepository brandRepo, ControlBoardService cbservice, HttpServletRequest request) {
		this.brandRepo = brandRepo;
		this.cbservice = cbservice;
		this.request = request;
	}

	@ModelAttribute(name = "brands")
	private List<Brand> brands() {
		List<Brand> brands = brandRepo.findAll();
		brands.forEach(b -> b.setName(b.getName().toUpperCase()));
		brands.sort(new Comparator<Brand>() {
			@Override
			public int compare(Brand o1, Brand o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		return brands;
	}

	@GetMapping("/control-boards")
	public String allControlBoards(Model model) {
		model.addAttribute("title", "Контролни платки");
		return "components/control_boards";
	}

	@GetMapping("/control-board-create")
	public String controlBoardCreate(@ModelAttribute ControlBoardBindModel controlBoardBindModel, Model model) {
		model.addAttribute("title", "Добави контролна платка");
		return "components/control_board-create";
	}

	//https://www.callicoder.com/spring-boot-file-upload-download-jpa-hibernate-mysql-database-example/
//	https://spring.io/guides/gs/uploading-files/
	@PostMapping("/control-board-create")
//	@RequestMapping(name = "/control-board-create", method = RequestMethod.POST)
	public String controlBoardCreate(@RequestParam("file") MultipartFile file, Model model, @Valid @ModelAttribute ControlBoardBindModel controlBoardBindModel, BindingResult bindingResult) throws IOException {
		if (bindingResult.hasErrors()) {
			return "components/control_board-create";
		}

		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		String uploadsDir = "/uploads";
		String realPathToUpload = request.getServletContext().getRealPath(uploadsDir);

		if (!new File(realPathToUpload).exists()) {
			new File(realPathToUpload).mkdir();
		} 
//		else {
//			String realPathOfFile = realPathToUpload + File.separator + fileName;
//			System.out.println("da ili ne: " + new File(realPathOfFile).exists());
//		}
		String filePath = realPathToUpload + File.separator + fileName;
		System.out.println(filePath);
		File dest = new File(filePath);
		file.transferTo(dest);
		return "redirect:/control-boards";
	}
}
