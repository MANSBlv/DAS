package lv.venta.demo.repos;

import org.springframework.data.repository.CrudRepository;

import lv.venta.demo.models.Occupation;

public interface iOccupationRepo extends CrudRepository<Occupation, Integer> {

}
