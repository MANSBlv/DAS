package lv.venta.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

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
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date startingDate;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date endDate;
	
	@OneToMany(mappedBy = "calendar")
	@ToString.Exclude
	private Collection<Course> course;

	@ManyToMany(mappedBy = "occupationCallendar")
	@ToString.Exclude
	private Collection<Occupation> occupation= new ArrayList<Occupation>();
	
	@OneToMany(mappedBy = "calendar")
	@ToString.Exclude
	private Collection<CourseImplementer> coImpl;
	
	public Calendar(Date year, Date startingDate, Date endDate) {
		
		this.year = year;
		this.startingDate = startingDate;
		this.endDate = endDate;
	}
	
	
	
}
