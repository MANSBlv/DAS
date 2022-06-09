package lv.venta.models;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "IdEm")
	@Setter(value = AccessLevel.NONE)
	private int idEm;

	@Pattern(regexp = "[A-ZŽĶĻŅČĢŠĪĀĒŪ]{1}[a-zžšķļņģčīāūē\\s]+", message = "Invalid input for Occupation Title")
	@Size(min = 2, max = 30 ,message = "Invalid input length for name")
	@Column(name = "Name")
	private String name;

	@Pattern(regexp = "[A-ZŽĶĻŅČĢŠĪĀĒŪ]{1}[a-zžšķļņģčīāūē\\s]+", message = "Invalid input for Occupation Title")
	@Size(min = 2, max = 30 ,message = "Invalid input length for surname")
	@Column(name = "Surname")
	private String surname;

	@ManyToOne
	@JoinColumn(name = "IdDe")
	private Department department;

	@OneToMany(mappedBy = "employee")
	@ToString.Exclude
	private Collection<EmployeeCourse> emCourse;
	
	@ManyToOne
	@JoinColumn(name = "IdOccupation")
	private Occupation occupation;
	
	@Size(min = 8, max = 12 ,message = "Invalid input length for phone number")
	@Column(name = "PhoneNumber")
	private String number;
	
	@Pattern(regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\\\.[A-Za-z0-9-]+)*(\\\\.[A-Za-z]{2,})$", message = "Invalid input for E-mail")
	@Column(name = "Email")
	private String email;

	public Employee(String name, String surname, Department department, Occupation occupation, String number, String email) {
		super();
		this.name = name;
		this.surname = surname;
		this.department = department;
		this.occupation = occupation;
		this.number = number;
		this.email = email;
	}
	
	
}
