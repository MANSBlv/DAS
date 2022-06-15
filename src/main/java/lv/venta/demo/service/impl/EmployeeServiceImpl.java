package lv.venta.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.demo.models.Employee;
import lv.venta.demo.models.EmployeeCourse;
import lv.venta.demo.models.Occupation;
import lv.venta.demo.repos.iEmployeeCourseRepo;
import lv.venta.demo.repos.iEmployeeRepo;
import lv.venta.demo.repos.iOccupationRepo;
import lv.venta.demo.service.iEmployeeService;

@Service
public class EmployeeServiceImpl implements iEmployeeService {

	@Autowired
	private iEmployeeRepo emRepo;
	
	@Autowired
	private iEmployeeCourseRepo emCoRepo;
	
	@Autowired
	private iOccupationRepo occRepo;
	
	@Override
	public boolean insertNewEmployee(Employee employee) {
		if(emRepo.existsById(employee.getIdEm())) {
			return false;
		} else {
			emRepo.save(employee);
			return true;
		}
	}

	@Override
	public boolean addEmployeeCourse(EmployeeCourse emCourse) {
		if(emCoRepo.existsByEmployeeAndCourseAndDate(emCourse.getEmployee(), emCourse.getCourse(), emCourse.getDate())) {
			return false;
		} else {
			emCoRepo.save(emCourse);
			return true;
		}
	}

	@Override
	public boolean insertOccupation(Occupation occupation) {
		if(occRepo.existsByTitleAndDescription(occupation.getTitle(), occupation.getDescription())) {
			return false;
		}else {
			occRepo.save(occupation);
			return true;
		}
	}

	@Override
	public boolean deleteEmployee(Employee employee) {
		if(emRepo.existsById(employee.getIdEm())) {
			emRepo.delete(employee);
			return true;
		}else
			return false;
	}

	@Override
	public boolean deleteOccupation(Occupation occupation) {
		if(occRepo.existsById(occupation.getIdOc())) {
			occRepo.delete(occupation);
			return true;
		}else
			return false;
	}

	@Override
	public boolean updateEmployeeCourse(EmployeeCourse emCourse) {
		if(emCoRepo.existsById(emCourse.getIdEmCo())) {
			EmployeeCourse emC = emCoRepo.findById(emCourse.getIdEmCo()).get();
			emC.setCourse(emCourse.getCourse());
			emC.setDate(emCourse.getDate());
			emC.setEmployee(emCourse.getEmployee());
			emC.setValuePr(emCourse.getValuePr());
			return true;
		}
		return false;
	}

}
