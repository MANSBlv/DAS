package lv.venta.demo.repos;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import lv.venta.demo.models.Company;

public interface iCompanyRepo extends CrudRepository<Company, Integer>{

	boolean existsByTitle(String title);

	ArrayList<Company> findByDepartmentsIdDe(int id);

	
}
