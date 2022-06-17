package lv.venta.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lv.venta.demo.models.CourseImplementer;
import lv.venta.demo.models.Implementer;
import lv.venta.demo.service.iCourseService;
import lv.venta.demo.service.iOtherService;

@Controller
public class CourseServiceController {

	@Autowired
	private iCourseService cService;
	
	@Autowired
	private iOtherService oService;
	
	@GetMapping("/courseImplementer/addNew")
	public String getAddedCourseImplementer(Model models, CourseImplementer impl) {
		List<Implementer> cImpl= cService.selectAllImpl();
		models.addAttribute("allCourseImplementer", cImpl);
		CourseImplementer imp= new CourseImplementer();
		models.addAttribute("courseImplementer", imp);
		return "course-implementer-page";
	}
	
	@PostMapping("/courseImplementer/addNew")
	public String addCourseImplementer(@Valid CourseImplementer impl, BindingResult res) {
		if(!res.hasErrors()) {
			cService.insertNewImplementerCourse(impl);
			return "course-implementer-page"; //pagaidu variants
		}else {
			return "error-page";
		}
		
	}
}
