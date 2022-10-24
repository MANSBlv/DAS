package lv.venta.demo.repos;

import org.springframework.data.repository.CrudRepository;

import lv.venta.demo.models.CourseType;

public interface iCourseTypeRepo extends CrudRepository<CourseType, Integer> {

}
