package lv.venta.demo.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.demo.models.Company;
import lv.venta.demo.models.Course;
import lv.venta.demo.models.CourseImplementer;
import lv.venta.demo.models.Department;
import lv.venta.demo.models.Employee;
import lv.venta.demo.models.Implementer;
import lv.venta.demo.repos.iCompanyRepo;
import lv.venta.demo.repos.iCourseImplementerRepo;
import lv.venta.demo.repos.iCourseRepo;
import lv.venta.demo.repos.iDepartmentRepo;
import lv.venta.demo.repos.iEmployeeRepo;
import lv.venta.demo.repos.iImplementerRepo;
import lv.venta.demo.service.iOtherService;

@Service
public class OtherServiceImpl implements iOtherService {
	
	@Autowired
	private iDepartmentRepo depRepo;
	
	@Autowired
	private iCompanyRepo compRepo;
	
	@Autowired
	private iImplementerRepo implRepo;
	
	@Autowired
	private iCourseImplementerRepo cImplRepo;
	
	@Autowired
	private iEmployeeRepo emRepo;
	
	@Autowired
	private iCourseRepo cRepo;
	
	
	
	@Override
	public boolean insertNewDepartment(Department department/*, int id*/) {
		if(depRepo.existsByHeadDepNameAndHeadDepSurnameAndTitle(department.getHeadDepName(),department.getHeadDepSurname(),department.getTitle())) {
			return false;
		}else {

			//department.setCompany(compRepo.findById(id).get());
			depRepo.save(department);
			return true;
		}
		
	}
	
	
	@Override
	public boolean deleteDepartmentById(int id) {
		if(depRepo.existsById(id)) {
			ArrayList<Employee> empl = emRepo.findByDepartmentIdDe(id);
			for(Employee temp: empl) {
				temp.setDepartment(null);
				emRepo.save(temp);
			}
			ArrayList<Course> cours= cRepo.findByDepartmentsIdDe(id);
			for(Course temp : cours) {
				temp.setDepartments(null);
				cRepo.save(temp);
			}
			depRepo.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public Company selectById(int id) {
		return compRepo.findById(id).get();
	}

	@Override
	public boolean insertNewCompany(Company company) {
		if(compRepo.existsByTitle(company.getTitle())) {
			return false;
		}else {
			compRepo.save(company);
			return true;
		}
		
	}
	
	@Override
	public boolean updateCompanyById(int id, Company comp) {
		if(compRepo.existsById(id)) {
			Company company= compRepo.findById(id).get();
			company.setTitle(comp.getTitle());
			compRepo.save(company);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteCompanyById(int id) {
		if(compRepo.existsById(id)) {
			ArrayList<Department> dep= depRepo.findByCompanyIdCo(id);
			for(Department temp : dep) {
				temp.setCompany(null);
				depRepo.save(temp);
			}
			compRepo.deleteById(id);
			return true;
		}
		return false;
	}
	

	@Override
	public ArrayList<Company> selectAllComp(){
		return (ArrayList<Company>) compRepo.findAll();
	}


	@Override
	public boolean insertNewImplementer(Implementer implementer) {
		if(implRepo.existsByTitle(implementer.getTitle())) {
			return false;
		}else {
			implRepo.save(implementer);
			return true;
		}
		
	}



	@Override
	public boolean deleteImplementerById(int id) {
		if(implRepo.existsById(id)) {
			ArrayList<CourseImplementer> impl = cImplRepo.findByImplementerIdImpl(id);
			for(CourseImplementer temp : impl) {
				temp.setImplementer(null);
				cImplRepo.save(temp);
			}
			implRepo.deleteById(id);
		}
		return false;
	}



	
	
	
	
	

}
