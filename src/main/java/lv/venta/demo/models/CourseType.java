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
public class CourseType {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "IdTy")
	@Setter(value = AccessLevel.NONE)
	private int idTy;

	@Column(name = "IsObligatory")
	@NotNull
	private boolean isObligatory;

	@Pattern(regexp = "[A-ZŽĶĻŅČĢŠĪĀĒŪ]{1}[a-zžšķļņģčīāūē\\s]+", message = "Invalid input for Course Type Description")
	@Size(min = 2, max = 20 , message = "Invalid input length for Course Type description")
	@Column(name = "Description")
	@NotNull
	private String description;

	@OneToMany(mappedBy = "type")
	@ToString.Exclude
	private Collection<Course> courses;

	public CourseType(boolean isObligatory,String description) {
		
		this.isObligatory = isObligatory;
		this.description = description;
	}
	
	
}
