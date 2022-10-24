package lv.venta.demo.repos;

import org.springframework.data.repository.CrudRepository;

import lv.venta.demo.models.Implementer;

public interface iImplementerRepo extends CrudRepository<Implementer, Integer> {

	boolean existsByTitle(String title);

}
