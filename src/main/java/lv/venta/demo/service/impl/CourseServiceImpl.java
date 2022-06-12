package lv.venta.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.demo.models.Course;
import lv.venta.demo.models.CourseImplementer;
import lv.venta.demo.models.Department;
import lv.venta.demo.repos.iCalendarRepo;
import lv.venta.demo.repos.iCourseImplementerRepo;
import lv.venta.demo.repos.iCourseRepo;
import lv.venta.demo.repos.iCourseTypeRepo;
import lv.venta.demo.repos.iDepartmentRepo;
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
	private iCourseTypeRepo typeRepo;
	
	@Autowired
	private iCalendarRepo calRepo;

	@Override
	public boolean insertNewCourse(Course course) {
		if(courseRepo.existsByTitleAndDepartmentAndCalendar(course.getTitle(),course.getDepartments(),course.getCalendar())) {
			return false;
		}else {
			courseRepo.save(course);
			return true;
		}
		
		
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
	public boolean insertNewReminder(Department dep) {
		depRepo.save(dep);
		return true;
	}

	
	
}
