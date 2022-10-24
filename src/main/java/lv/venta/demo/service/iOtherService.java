package lv.venta.demo.service;

import java.util.ArrayList;

import lv.venta.demo.models.Company;
import lv.venta.demo.models.Department;
import lv.venta.demo.models.Implementer;

public interface iOtherService {

	public abstract boolean insertNewDepartment(Department department/*, int id*/);
	
	public abstract boolean deleteDepartmentById(int id);
	
	boolean updateDepartmentById(int id, Department dep);
	
	public abstract boolean insertNewCompany(Company company);
	
	public abstract boolean deleteCompanyById(int id);
	
	public abstract boolean updateCompanyById(int id, Company comp);
	
	public abstract boolean insertNewImplementer(Implementer implementer);
	
	public abstract boolean deleteImplementerById(int id);
	
	boolean updateImplementerById(int id, Implementer implementer);

	ArrayList<Company> selectAllComp();

	Company selectById(int id);

	

	
	
}
