package lv.venta.demo.repos;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import lv.venta.demo.models.EmployeeCourse;

public interface iEmployeeCourseRepo  extends CrudRepository<EmployeeCourse, Integer>{

	ArrayList<EmployeeCourse> findByCourseIdCourse(int id);

}
