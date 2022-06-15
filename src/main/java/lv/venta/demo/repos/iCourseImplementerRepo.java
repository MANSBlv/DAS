package lv.venta.demo.repos;

import org.springframework.data.repository.CrudRepository;

import lv.venta.demo.models.Calendar;
import lv.venta.demo.models.CourseImplementer;
import lv.venta.demo.models.Implementer;

public interface iCourseImplementerRepo extends CrudRepository<CourseImplementer, Integer>{

	boolean existsByImplementerAndCalendar(Implementer implementer, Calendar calendar);

}
