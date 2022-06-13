package lv.venta.demo.service;

import java.util.ArrayList;

import lv.venta.demo.models.Company;
import lv.venta.demo.models.Department;
import lv.venta.demo.models.Implementer;

public interface iOtherService {

	public abstract boolean insertNewDepartment(Department department/*, int id*/);
	
	public abstract boolean insertNewCompany(Company company);
	
	public abstract boolean insertNewImplementer(Implementer implementer);

	ArrayList<Company> selectAllComp();

	Company selectById(int id);
	
}
