package models;

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
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="IdCourse")
	@Setter(value=AccessLevel.NONE)
	private int idCourse;
	
	@Column(name="Title")
	private String title;
	
	@ManyToOne
	@JoinColumn(name="IdTy")
	private Type type;
	
	@ManyToMany
	@JoinTable(joinColumns = @JoinColumn(name="IdCourse"), inverseJoinColumns = @JoinColumn(name="IdDe"))
	@ToString.Exclude
	private java.util.Collection<Department> departments = new ArrayList<Department>();
	//caur konstruktoru pievienot atbilstošos departments objektus
	
	@OneToMany(mappedBy="course")
	@ToString.Exclude
	private Collection<Employee_Course> emCourse;
}
