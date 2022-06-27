package lv.venta.demo.controller;

<<<<<<< HEAD
=======
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

>>>>>>> 8f5559c39caf0480f56cbad0042847bf46497373
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import lv.venta.demo.models.Calendar;
import lv.venta.demo.service.iCalendarService;
<<<<<<< HEAD
=======

>>>>>>> 8f5559c39caf0480f56cbad0042847bf46497373

@Controller
public class CalendarServiceController {

<<<<<<< HEAD
=======




>>>>>>> 8f5559c39caf0480f56cbad0042847bf46497373
	@Autowired
	private iCalendarService calService;
	
	@GetMapping("/calendar/addNewCourse")
	public String getAddedCalendarCourse(Model models, Calendar calendar) {
		Calendar cal = new Calendar();
		models.addAttribute("calendar", cal);
		return "calendar-add-course-page";
	}
	
	@PostMapping("/calendar/addNewCourse")
	public String addCalendarCourse(@Valid Calendar cal, BindingResult res) {
		if(!res.hasErrors()) {
			calService.insertNewCalendarCourse(cal);
			return "calendar-add-course-page";
		} else {
			return "error-page";
		}
	}
	
	@GetMapping("/calendar/deleteCourse/{id}")
	public String getDeleteCalendarCourse(Model model, @PathVariable(name = "id") int id) throws Exception {
		if(calService.DeleteCalendarCourseById(id)) {
			model.addAttribute("object", calService.selectAllCal());
			return "calendar-page";
		}
		else
			return "error-page";
	}
	
	@GetMapping("/calendar/updateCourse/{id}")
	public String getUpdateCourseById(Model model, @PathVariable(name="id") int id, Calendar calendar) throws Exception {
		model.addAttribute("course", calService.selectCalendarById(id));
		return "calendar-update-course-page";
	}
	
	@PostMapping("/calendar/updateCourse/{id}")
	public String updateCalendarCourseById(@PathVariable(name="id") int id, @Valid Calendar calendar, BindingResult res) {
		if(!res.hasErrors()) {
			if(calService.UpdateCalendarCourseById(calendar, id)) 
				return "redirect:/calendar-page/";	
			else 
				return "redirect:/error";
		}
			else {
				return "calendar-update-course-page";
			}
		}
	}
<<<<<<< HEAD
	
	
	
	
=======

>>>>>>> 8f5559c39caf0480f56cbad0042847bf46497373
