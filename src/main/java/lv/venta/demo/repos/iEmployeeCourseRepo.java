package lv.venta.demo.repos;


import java.util.ArrayList;

import java.util.Date;


import org.springframework.data.repository.CrudRepository;

import lv.venta.demo.models.Course;
import lv.venta.demo.models.Employee;
import lv.venta.demo.models.EmployeeCourse;

public interface iEmployeeCourseRepo  extends CrudRepository<EmployeeCourse, Integer>{


	ArrayList<EmployeeCourse> findByCourseIdCourse(int id);


	boolean existsByEmployeeAndCourseAndDate(Employee employee, Course course, Date date);

}
