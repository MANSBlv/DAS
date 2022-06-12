package lv.venta.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.demo.models.Company;
import lv.venta.demo.models.Department;
import lv.venta.demo.models.Implementer;
import lv.venta.demo.repos.iCompanyRepo;
import lv.venta.demo.repos.iDepartmentRepo;
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
	
	
	
	@Override
	public boolean insertNewDepartment(Department department) {
		if(depRepo.existsByHeadDepNameAndHeadDepSurnameAndTitle(department.getHeadDepName(),department.getHeadDepSurname(),department.getTitle())) {
			return false;
		}else {
			depRepo.save(department);
			return true;
		}
		
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
	public boolean insertNewImplementer(Implementer implementer) {
		if(implRepo.existsByTitle(implementer.getTitle())) {
			return false;
		}else {
			implRepo.save(implementer);
			return true;
		}
		
	}
	
	
	
	
	

}
