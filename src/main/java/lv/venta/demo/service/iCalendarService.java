package lv.venta.demo.service;

import java.util.ArrayList;

import lv.venta.demo.models.Calendar;

public interface iCalendarService {

	public abstract boolean insertNewCalendarCourse(Calendar calendar);
	
	public abstract boolean UpdateCalendarCourseById(Calendar calendar, int id);
	
	public abstract boolean DeleteCalendarCourseById(int id);
	
	public ArrayList<Calendar> selectAllCal();
	
	public Calendar selectCalendarById(int id) throws Exception;
}
