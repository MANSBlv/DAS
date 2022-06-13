package lv.venta.demo.controller;

import java.util.List;

import javax.naming.Binding;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import lv.venta.demo.models.Company;
import lv.venta.demo.models.Department;
import lv.venta.demo.models.Implementer;
import lv.venta.demo.service.iCourseService;
import lv.venta.demo.service.iOtherService;

@Controller
public class OtherServiceController {

	@Autowired
	private iCourseService cService;
	
	@Autowired
	private iOtherService oService;
	
	@GetMapping("/company/addNew")
	public String getAddedCompany(Model models, Company company) {
		Company comp= new Company();
		models.addAttribute("company", comp);
		return "company-add-page";
	}
	
	@PostMapping("/company/addNew")
	public String addCompany(@Valid Company comp, BindingResult res) {
		if(!res.hasErrors()) {
			oService.insertNewCompany(comp);
			return "department-add-page"; //pagaidu variants
		}else {
			return "company-add-page";
		}
		
		
		
	}
	
	@GetMapping("/implementer/addNew")
	public String getAddedImplementer(Model models, Implementer impl) {
		Implementer imp= new Implementer();
		models.addAttribute("implementer", imp);
		return "implementer-add-page";
	}
	
	@PostMapping("/implementer/addNew")
	public String addImplementer(@Valid Implementer impl, BindingResult res) {
		if(!res.hasErrors()) {
			oService.insertNewImplementer(impl);
			return "implementer-add-page"; //pagaidu variants
		}else {
			return "implementer-add-page";
		}
		
	}
	
	@GetMapping("/department/addNew")
	public String getAddedDepartment(Model models, Department dep) {
		List<Company> listCompanies= oService.selectAllComp();
		models.addAttribute("listCompanies", listCompanies);
		Department depart= new Department();
		//depart.setCompany(oService.selectById(id));
		models.addAttribute("department", depart);
		return "department-add-page";
	}
	
	@PostMapping("/department/addNew")
	public String addDepartment(@Valid Department dep, BindingResult res/*, int id*/) {
		if(!res.hasErrors()) {
			oService.insertNewDepartment(dep);
			//dep.setCompany(oService.selectById(id));
			return "department-add-page"; //pagaidu variants
		}else {
			return "department-add-page";
		}
		
		
		
	}
	
	
}
