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
public class Occupation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "IdOccupation")
	@Setter(value = AccessLevel.NONE)
	private int idOc;

	@Pattern(regexp = "[A-ZŽĶĻŅČĢŠĪĀĒŪ]{1}[a-zžšķļņģčīāūē\\s]+", message = "Invalid input for Occupation Title")
	@Size(min = 2, max = 30 ,message = "Invalid input length for Occupation Title")
	@Column(name = "Title")
	private String title;
	
	@Pattern(regexp = "[A-ZŽĶĻŅČĢŠĪĀĒŪ]{1}[a-zžšķļņģčīāūē\\s]+", message = "Invalid input for Occupation Description")
	@Size(min = 2, max = 30,message = "Invalid input length for Occupation Description")
	@Column(name = "Description")
	private String description;

	@OneToMany(mappedBy = "occupation")
	@ToString.Exclude
	private Collection<Employee> employee;

	@ManyToMany
	@JoinTable(joinColumns = @JoinColumn(name = "IdOccupation"), inverseJoinColumns = @JoinColumn(name = "IdCalendar"))
	@ToString.Exclude
	private Collection<Calendar> occupationCallendar= new ArrayList<Calendar>();
	
	public Occupation(String title, String description) {
		
		this.title = title;
		this.description = description;
	}
	
	
}
