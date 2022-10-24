package lv.venta.demo.models;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
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
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "IdCo")
	@Setter(value = AccessLevel.NONE)
	private int idCo;

	// TODO validācijas
	@NotNull
	@Column(name = "Title")
	@Pattern(regexp = "[A-ZŽĶĻŅČĢŠĪĀĒŪ]{1}[a-zžšķļņģčīāūē\\s]+", message = "Invalid input for Company Title")
	@Size(min = 2, max = 30, message = "Invalid input length for Company title")
	private String title;

	@OneToMany(mappedBy = "company")
	@ToString.Exclude
	private Collection<Department> departments;

	public Company( String title) {
		
		this.title = title;
		
	}
	
	
	
	

}
