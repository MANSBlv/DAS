package lv.venta.demo.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.demo.models.Calendar;
import lv.venta.demo.repos.iCalendarRepo;
import lv.venta.demo.repos.iCourseRepo;
import lv.venta.demo.service.iCalendarService;

@Service
public class CalendarServiceImpl implements iCalendarService {

	@Autowired
	private iCourseRepo coRepo;
	@Autowired
	private iCalendarRepo calRepo;
	
	
	@Override
	public boolean insertNewCalendarCourse(Calendar calendar) {
		if(!calRepo.existsById(calendar.getIdCalendar())) {
			calRepo.save(calendar);
			return true;
		}
		return false;
	}

	@Override
	public boolean UpdateCalendarCourseById(Calendar calendar, int id) {
		if(calRepo.existsById(calendar.getIdCalendar())) {
			Calendar cal= calRepo.findById(id).get();
			cal.setCoImpl(calendar.getCoImpl());
			cal.setCourse(calendar.getCourse());
			cal.setStartingDate(calendar.getStartingDate());
			cal.setEndDate(calendar.getEndDate());
			cal.setYear(calendar.getYear());
			cal.setOccupation(calendar.getOccupation());
			calRepo.save(cal);
			return true;
		}
		return false;
	}

	@Override
	public boolean DeleteCalendarCourseById(int id) {
		if(coRepo.existsById(id)) {
			ArrayList<Calendar> cal = calRepo.findByCourseIdCourse(id);
			for(Calendar temp : cal) {
				temp.setCourse(null);
				calRepo.save(temp);
			}
			coRepo.deleteById(id);
		}
		return false;
	}

	@Override
	public ArrayList<Calendar> selectAllCal() {
		return (ArrayList<Calendar>) calRepo.findAll();
	}

	@Override
	public Calendar selectCalendarById(int id) throws Exception {
		if(calRepo.existsById(id)) {
			Calendar calendar= calRepo.findById(id).get();
			return calendar;
		}
		throw new Exception("Course doesn't exist in calendar");
	}

	
}
