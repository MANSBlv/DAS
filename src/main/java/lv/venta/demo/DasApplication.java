package lv.venta.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lv.venta.repos.iCalendarRepo;
import lv.venta.repos.iCompanyRepo;
import lv.venta.repos.iCourseImplementerRepo;
import lv.venta.repos.iCourseRepo;
import lv.venta.repos.iCourseTypeRepo;
import lv.venta.repos.iDepartmentRepo;
import lv.venta.repos.iEmployeeCourseRepo;
import lv.venta.repos.iEmployeeRepo;
import lv.venta.repos.iImplementerRepo;
import lv.venta.repos.iOccupationRepo;

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
				
			}
		};
		
	}

}
