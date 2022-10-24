package lv.venta.demo.service;

import java.util.ArrayList;

import lv.venta.demo.models.Department;
import lv.venta.demo.models.Employee;
import lv.venta.demo.models.EmployeeCourse;
import lv.venta.demo.models.Occupation;

public interface iEmployeeService {

	public abstract boolean insertNewEmployee(Employee employee);
	
	public abstract boolean addEmployeeCourse(EmployeeCourse emCourse);
	
	public abstract boolean insertOccupation(Occupation occupation);
	
	public abstract boolean deleteEmployee(Employee employee);
	
	public abstract boolean updateEmployeeCourse(EmployeeCourse emCourse);
	
	public abstract boolean deleteOccupation(Occupation occupation);

	ArrayList<Department> selectAllDep();

	ArrayList<Occupation> selectAllOcc();
}
