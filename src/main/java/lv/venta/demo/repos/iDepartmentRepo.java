package lv.venta.demo.repos;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import lv.venta.demo.models.Department;

public interface iDepartmentRepo extends CrudRepository<Department, Integer> {

	boolean existsByHeadDepNameAndHeadDepSurnameAndTitle(String headDepName, String headDepSurname, String title);

	ArrayList<Department> findByCompanyIdCo(int id);

}
