package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class Company {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="IdCo")
	@Setter(value=AccessLevel.NONE)
	private int idCo;
	
	//TODO validācijas
	@Column(name="Title")
	private String title;

	@OneToMany(mappedBy="company")
	@ToString.Exclude
	private java.util.Collection<Department> departments;
	
}
