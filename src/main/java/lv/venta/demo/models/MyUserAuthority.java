package lv.venta.demo.models;

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
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table
@Entity
public class MyUserAuthority {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Setter(value=AccessLevel.NONE)
	@Column(name="IdAuth")
	private long idAuth;
	
	@Column(name="Role")
	private String role;
	
	@ManyToMany
	@JoinTable(name = "User_Authority",
	joinColumns = @JoinColumn(name = "IdUser"),
	inverseJoinColumns = @JoinColumn(name = "IdAuth"))
	private Collection<MyUser> allUsers = new ArrayList<>();
	
	public MyUserAuthority(String role) {
		this.role = role;
	}
	
	public void addUser(MyUser user) {
		allUsers.add(user);
	}
	public void removeUser(MyUser user) {
		allUsers.remove(user);
	}
}
