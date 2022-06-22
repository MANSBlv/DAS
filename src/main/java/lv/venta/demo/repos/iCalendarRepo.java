package lv.venta.demo.repos;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import lv.venta.demo.models.Calendar;

@Repository
public interface iCalendarRepo extends CrudRepository<Calendar, Integer>{

	ArrayList<Calendar> findByCourseIdCourse(int id);

}
