package lv.venta.demo.repos;

import java.util.ArrayList;
import java.util.Collection;

import javax.validation.constraints.NotNull;

import org.springframework.data.repository.CrudRepository;

import lv.venta.demo.models.Calendar;
import lv.venta.demo.models.Course;
import lv.venta.demo.models.Department;

public interface iCourseRepo extends CrudRepository<Course, Integer> {

	ArrayList<Course> findByDepartmentsIdDe(int id);


	//boolean existsByDepartmentsAndCalendarIn(Collection<Department> departments, Collection<Calendar> calendar);

	

}
