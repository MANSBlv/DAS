package lv.venta.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
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
public class EmployeeCourse {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "IdEmCo")
	@Setter(value = AccessLevel.NONE)
	private int idEmCo;

	@Min(value = 0)
	@Max(value = 100)
	@Column(name = "ValuePr")
	private float valuePr;

	@ManyToOne
	@JoinColumn(name = "IdEm")
	private Employee employee;

	@ManyToOne
	@JoinColumn(name = "IdCourse")
	private Course course;
	
	@NotNull
	@PastOrPresent
	@Column(name = "Date")
	private Date date;

	public EmployeeCourse( float valuePr, Employee employee, Course course, Date date) {
		super();
		this.valuePr = valuePr;
		this.employee = employee;
		this.course = course;
		this.date = date;
	}
	
	
}
