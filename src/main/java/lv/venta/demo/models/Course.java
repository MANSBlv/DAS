package lv.venta.demo.models;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString
@Table
@Entity
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "IdCourse")
	@Setter(value = AccessLevel.NONE)
	private int idCourse;

	@Pattern(regexp = "[A-ZŽĶĻŅČĢŠĪĀĒŪ]{1}[a-zžšķļņģčīāūē\\s]+", message = "Invalid input for Course Title")
	@Size(min = 2, max = 30, message = "Invalid input length for Course Title")
	@Column(name = "Title")
	@NotNull
	private String title;
	
	@Pattern(regexp = "[A-ZŽĶĻŅČĢŠĪĀĒŪ]{1}[a-zžšķļņģčīāūē\\s]+", message = "Invalid input for Course Description")
	@Size(min = 2, max = 30 ,message = "Invalid input length for Course Description")
	@Column(name = "Description")
	@NotNull
	private String description;

	@ManyToOne
	@Cascade(CascadeType.ALL)
	@JoinColumn(name = "IdTy")
	@NotNull
	private CourseType type;

	@ManyToMany(mappedBy = "courses")
	@ToString.Exclude
	private Collection<Department> departments = new ArrayList<Department>();
	// caur konstruktoru pievienot atbilstošos departments objektus
	
	public void addNewDepartment(Department department) {
		departments.add(department);
	}

	@OneToMany(mappedBy = "course")
	@ToString.Exclude
	private Collection<EmployeeCourse> emCourse;
	
	@OneToMany(mappedBy = "course")
	@ToString.Exclude
	private Collection<Calendar> calendar;
	
	public Course( String title,String description, CourseType type ,  Collection<Department> department) {
		
		this.title = title;
		this.description = description;
		this.type=type;
		this.departments=department; 
	}

	
	
	
	
	
}
