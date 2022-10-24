package lv.venta.demo.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

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
public class Calendar {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "IdCalendar")
	@Setter(value = AccessLevel.NONE)
	private int idCalendar;
	
	@DateTimeFormat(pattern = "yyyy")
	private Date year;
	
	//@DateTimeFormat(iso = ISO.DATE)
	//@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startingDate;
	
	//@DateTimeFormat(iso = ISO.DATE)
	//@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endDate;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name= "IdCourse")
	@ToString.Exclude
	private Course course;

	@ManyToMany(mappedBy = "occupationCallendar")
	@ToString.Exclude
	private Collection<Occupation> occupation= new ArrayList<Occupation>();
	
	@OneToMany(mappedBy = "calendar")
	@ToString.Exclude
	private Collection<CourseImplementer> coImpl;
	
	public Calendar(Date year, Date startingDate, Date endDate, Course course) {
		
		this.year = year;
		this.startingDate = startingDate;
		this.endDate = endDate;
		this.course=course;
	}
	
	
	
}
