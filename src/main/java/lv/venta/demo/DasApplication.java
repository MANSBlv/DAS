package lv.venta.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lv.venta.demo.models.Calendar;
import lv.venta.demo.models.Company;
import lv.venta.demo.models.Course;
import lv.venta.demo.models.CourseImplementer;
import lv.venta.demo.models.CourseType;
import lv.venta.demo.models.Department;
import lv.venta.demo.models.Employee;
import lv.venta.demo.models.EmployeeCourse;
import lv.venta.demo.models.Implementer;
import lv.venta.demo.models.Occupation;
import lv.venta.demo.repos.iCalendarRepo;
import lv.venta.demo.repos.iCompanyRepo;
import lv.venta.demo.repos.iCourseImplementerRepo;
import lv.venta.demo.repos.iCourseRepo;
import lv.venta.demo.repos.iCourseTypeRepo;
import lv.venta.demo.repos.iDepartmentRepo;
import lv.venta.demo.repos.iEmployeeCourseRepo;
import lv.venta.demo.repos.iEmployeeRepo;
import lv.venta.demo.repos.iImplementerRepo;
import lv.venta.demo.repos.iOccupationRepo;

@SpringBootApplication
public class DasApplication {

	public static void main(String[] args) {
		SpringApplication.run(DasApplication.class, args);
	}
	@Bean
	
	public CommandLineRunner runner(iCalendarRepo calendarRepo, iCompanyRepo companyRepo,iCourseRepo courseRepo, iCourseTypeRepo courseTypeRepo, iDepartmentRepo departmentRepo, iOccupationRepo occupationRepo, iEmployeeRepo employeeRepo, iEmployeeCourseRepo emplCourseRepo, iImplementerRepo implementerRepo, iCourseImplementerRepo coImplRepo) {
		return new CommandLineRunner() {
			
			@Override
			
			public void run(String... args) throws Exception {
				// TODO Auto-generated method stub
				Company c1= new Company("Tranzits");
				//companyRepo.save(c1);
				
				Department d1= new Department("It dep", "Valdis", "Koks", c1);
				//departmentRepo.save(d1);
				
				
				Occupation o1= new Occupation("Projektu vaditajs", "Vada projektus");
				//occupationRepo.save(o1);
				
				Employee e1= new Employee("Aigars", "Miezis", d1, o1, "36254718", "aigars@inbox.lv");
				//employeeRepo.save(e1);
				
				CourseType co1= new CourseType(true, "Nezinu ko rakstit");
				//courseTypeRepo.save(co1);
				
				Course course1= new Course("Darba drošiba", "Apraksts", co1, new ArrayList<>(Arrays.asList(d1)));
				//courseRepo.save(course1);
				//d1.addNewCourse(course1);
				//departmentRepo.save(d1);
				
				EmployeeCourse empl1= new EmployeeCourse(40, e1, course1, new Date());
				//emplCourseRepo.save(empl1);
				
				Calendar cal1= new Calendar(new Date(2022), new Date(24/7/2022), new Date(28/9/2022), course1);
				//calendarRepo.save(cal1);
				
				Implementer i1= new Implementer("Buts");
				//implementerRepo.save(i1);
				
				CourseImplementer ci1= new CourseImplementer("Ugunsdrošiba", i1, cal1);
				//coImplRepo.save(ci1);
			}
		};
		
	}

}
