package lv.venta.demo.repos;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import lv.venta.demo.models.Employee;

public interface iEmployeeRepo extends CrudRepository<Employee, Integer>{

	ArrayList<Employee> findByDepartmentIdDe(int id);

}
