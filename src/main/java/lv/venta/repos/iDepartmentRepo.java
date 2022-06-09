package lv.venta.repos;

import org.springframework.data.repository.CrudRepository;

import lv.venta.models.Department;

public interface iDepartmentRepo extends CrudRepository<Department, Integer> {

}
