package lv.venta.models;

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
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

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
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "IdDe")
	@Setter(value = AccessLevel.NONE)
	private int idDe;

	@Pattern(regexp = "[A-ZŽĶĻŅČĢŠĪĀĒŪ]{1}[a-zžšķļņģčīāūē\\s]+", message = "Invalid input for Department Title")
	@Size(min = 2, max = 30 , message = "Invalid input length for Department Title")
	@Column(name = "Title")
	private String title;

	// TODO vadītāja mainīgie
	@Pattern(regexp = "[A-ZŽĶĻŅČĢŠĪĀĒŪ]{1}[a-zžšķļņģčīāūē\\s]+", message = "Invalid input for Head of Department Name")
	@Size(min = 2, max = 20 , message = "Invalid input length for Head of Department Name")
	@Column(name = "HeadDepName")
	private String headDepName;
	
	@Pattern(regexp = "[A-ZŽĶĻŅČĢŠĪĀĒŪ]{1}[a-zžšķļņģčīāūē\\s]+", message = "Invalid input for Head of Department Surname")
	@Size(min = 2, max = 20  ,message = "Invalid input length for Head of Department Surname")
	@Column(name = "HeadDepSurname")
	private String headDepSurname;
	
	@ManyToOne
	@JoinColumn(name = "IdCo")
	private Company company;

	@OneToMany(mappedBy = "department")
	@ToString.Exclude
	private Collection<Employee> employees;

	@ManyToMany
	@JoinTable(joinColumns = @JoinColumn(name = "IdDe"), inverseJoinColumns = @JoinColumn(name = "IdCourse"))
	@ToString.Exclude
	private Collection<Course> courses = new ArrayList<Course>();

	public void addNewCourse(Course course) {
		courses.add(course);
	}

	public Department(String title,String headDepName,String headDepSurname) {
		
		this.title = title;
		this.headDepName = headDepName;
		this.headDepSurname = headDepSurname;
	}
	
	
	
}
