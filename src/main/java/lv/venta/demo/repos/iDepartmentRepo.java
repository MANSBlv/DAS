package lv.venta.demo.repos;

import org.springframework.data.repository.CrudRepository;

import lv.venta.demo.models.Department;

public interface iDepartmentRepo extends CrudRepository<Department, Integer> {

}
