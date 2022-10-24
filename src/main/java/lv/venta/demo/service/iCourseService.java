package lv.venta.demo.service;

import java.util.ArrayList;
import java.util.List;

import lv.venta.demo.models.Course;
import lv.venta.demo.models.CourseImplementer;
import lv.venta.demo.models.CourseType;
import lv.venta.demo.models.Department;
import lv.venta.demo.models.Implementer;


public interface iCourseService {

	public abstract boolean insertNewCourse(Course course );
	
	public abstract boolean deleteCourseByid(int id);
	
	public abstract boolean updateCourseById(int id, Course course);
	
	public abstract boolean insertNewImplementerCourse(CourseImplementer cImplem);
	
	public abstract boolean deleteImplementerCourseById(int id);
	
	public abstract boolean updateImplementerCourseById(int id, CourseImplementer cImpl);
	
	//public abstract boolean insertNewReminder(Department dep);

	ArrayList<Implementer> selectAllImpl();

	ArrayList<Department> selectAllDep();

	ArrayList<CourseType> selectAllType();
}
