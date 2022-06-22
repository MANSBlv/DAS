package lv.venta.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lv.venta.demo.models.Department;
import lv.venta.demo.models.Employee;
import lv.venta.demo.models.Occupation;
import lv.venta.demo.service.iCourseService;
import lv.venta.demo.service.iEmployeeService;
import lv.venta.demo.service.iOtherService;
@Controller
public class EmployeeServiceController {
	
	
	@Autowired
	private iCourseService cService;
	
	@Autowired
	private iOtherService oService;
	
	@Autowired
	private iEmployeeService eService;
	
	@GetMapping("/employee/addNew")
	public String getNewEmployee(Model model, Employee emp) {
		List<Department> dep= eService.selectAllDep();
		model.addAttribute("allDepartment", dep);
		List<Occupation> oc= eService.selectAllOcc();
		model.addAttribute("allOccupation", oc);
		Employee empl= new Employee();
		model.addAttribute("employee", empl);
		return "employe-add-page";
	}
	
	@PostMapping("/employee/addNew")
	public String addNewEmployee(@Valid Employee emp, BindingResult res) {
		//if(!res.hasErrors()) {
			eService.insertNewEmployee(emp);
			return "employe-add-page";
		//}else {
		//	return "error-page";
		//}
		
		
	}
}
