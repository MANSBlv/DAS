package lv.venta.demo.service;

import lv.venta.demo.models.Course;
import lv.venta.demo.models.CourseImplementer;
import lv.venta.demo.models.Department;


public interface iCourseService {

	public abstract boolean insertNewCourse(Course course );
	
	public abstract boolean insertNewImplementerCourse(CourseImplementer cImplem);
	
	public abstract boolean insertNewReminder(Department dep);
}
