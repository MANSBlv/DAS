package lv.venta.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
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
public class CourseImplementer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "IdCourseImpl")
	@Setter(value = AccessLevel.NONE)
	private int idCourseImpl;
	
	@Pattern(regexp = "[A-ZŽĶĻŅČĢŠĪĀĒŪ]{1}[a-zžšķļņģčīāūē\\s]+", message = "Invalid input for Course Implementer notes")
	@Size( max = 150, message = "Invalid input length for Course Implementer notes")
	@Column(name= "Notes")
	private String notes;
	
	@ManyToOne
	@Cascade(CascadeType.ALL)
	@JoinColumn(name = "IdImpl")
	private Implementer implementer;
	
	@ManyToOne
	@Cascade(CascadeType.ALL)
	@JoinColumn(name = "IdCalendar")
	private Calendar calendar;

	public CourseImplementer( String notes, Implementer implementer, Calendar calendar) {
		
		this.notes = notes;
		this.implementer = implementer;
		this.calendar = calendar;
	}
	
	
}
