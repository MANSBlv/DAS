package models;


import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="IdDe")
	@Setter(value=AccessLevel.NONE)
	private int idDe;
	
	@Column(name="Title")
	private String title;
	
	//TODO vadītāja mainīgie
	@ManyToOne
	@JoinColumn(name="IdCo")
	private Company company;
	
	@OneToMany(mappedBy="department")
	@ToString.Exclude
	private java.util.Collection<Employee> employees;
	
	@ManyToMany(mappedBy="departments")
	@ToString.Exclude
	private java.util.Collection<Course> courses = new ArrayList<Course>();
	
	public  void addNewCourse(Course course)
	{
		courses.add(course);
	}
}
