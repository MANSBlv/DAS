package lv.venta.demo.repos;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

import lv.venta.demo.models.Calendar;
import lv.venta.demo.models.Course;
import lv.venta.demo.models.Department;

public interface iCourseRepo extends CrudRepository<Course, Integer> {

	

	boolean existsByTitleAndDepartmentAndCalendar(String title, Collection<Department> departments,
			Collection<Calendar> calendar);

}
