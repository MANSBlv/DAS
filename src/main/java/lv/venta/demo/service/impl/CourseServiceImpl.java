package lv.venta.demo.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import lv.venta.demo.models.Calendar;
import lv.venta.demo.models.Company;
import lv.venta.demo.models.Course;
import lv.venta.demo.models.CourseImplementer;
import lv.venta.demo.models.CourseType;
import lv.venta.demo.models.Department;
import lv.venta.demo.models.EmployeeCourse;
import lv.venta.demo.models.Implementer;
import lv.venta.demo.repos.iCalendarRepo;
import lv.venta.demo.repos.iCourseImplementerRepo;
import lv.venta.demo.repos.iCourseRepo;
import lv.venta.demo.repos.iCourseTypeRepo;
import lv.venta.demo.repos.iDepartmentRepo;
import lv.venta.demo.repos.iEmployeeCourseRepo;
import lv.venta.demo.repos.iImplementerRepo;
import lv.venta.demo.service.iCourseService;

@Service
public class CourseServiceImpl implements iCourseService {
	
	@Autowired
	private iDepartmentRepo depRepo;
	
	@Autowired
	private iCourseRepo courseRepo;
	
	@Autowired
	private iCourseImplementerRepo cImplRepo;
	
	@Autowired
	private iImplementerRepo implRepo;
	
	@Autowired
	private iCourseTypeRepo typeRepo;
	
	@Autowired
	private iCalendarRepo calRepo;
	
	@Autowired
	private iEmployeeCourseRepo empCourseRepo;

//	@Override
//	public boolean insertNewCourse(Course course) {
//		if(courseRepo.existsByDepartmentsAndCalendarIn(course.getDepartments(),course.getCalendar())) {
//			return false;
//		}else {
//			courseRepo.save(course);
//			return true;
//		}
//		
//		
//
//	}
	
	@Override
	public boolean insertNewCourse(Course course) {
		courseRepo.save(course);
		return true;
	}
	
	@Override
	public boolean deleteCourseByid(int id) {
		if(courseRepo.existsById(id)) {
			ArrayList<Calendar> calendar = calRepo.findByCourseIdCourse(id);
			for(Calendar temp : calendar) {
				temp.setCourse(null);
				calRepo.save(temp);
			}
			ArrayList<EmployeeCourse> emCourse = empCourseRepo.findByCourseIdCourse(id);
			for(EmployeeCourse temp : emCourse) {
				temp.setCourse(null);
				empCourseRepo.save(temp);
			}
			courseRepo.deleteById(id);
			return true;
		}
		return false;
	}
	
	@Override
	public boolean updateCourseById(int id, Course course) {
		if(courseRepo.existsById(id)) {
			Course c= courseRepo.findById(id).get();
			c.setCalendar(course.getCalendar());
			c.setDepartments(course.getDepartments());
			c.setDescription(course.getDescription());
			c.setEmCourse(course.getEmCourse());
			c.setTitle(course.getTitle());
			c.setType(course.getType());
			courseRepo.save(c);
			return true;
		}
		return false;
	}

	@Override
	public boolean insertNewImplementerCourse(CourseImplementer cImplem) {
		if(cImplRepo.existsByImplementerAndCalendar(cImplem.getImplementer(),cImplem.getCalendar())) {
			return false;
		}else {
			cImplRepo.save(cImplem);
			return true;
		}
		
	}
	
	@Override
	public boolean updateImplementerCourseById(int id, CourseImplementer cImpl) {
		if(cImplRepo.existsById(id)) {
			CourseImplementer cImplementer= cImplRepo.findById(id).get();
			cImplementer.setCalendar(cImpl.getCalendar());
			cImplementer.setImplementer(cImpl.getImplementer());
			cImplementer.setNotes(cImpl.getNotes());
			cImplRepo.save(cImplementer);
			return true;
		}
		return false;
	}
	
	@Override
	public boolean deleteImplementerCourseById(int id) {
		if(cImplRepo.existsById(id)) {
			cImplRepo.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public ArrayList<Implementer> selectAllImpl(){
		return (ArrayList<Implementer>) implRepo.findAll() ;
	}
	
//	@Override
//	public boolean insertNewReminder(Department dep) {
//		depRepo.save(dep);
//		return true;
//	}

	@Override
	public ArrayList<Department> selectAllDep() {
		return (ArrayList<Department>) depRepo.findAll() ;
	}

	@Override
	public ArrayList<CourseType> selectAllType() {
		return (ArrayList<CourseType>) typeRepo.findAll() ;
	}




	
	
	
	
}
