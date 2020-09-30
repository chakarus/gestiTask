package comspring.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
public class User {


	@Id
	@Email
	@NotEmpty
	@Column(unique=true)
	private String email;
	
	@Size(min=4)
	private String password;
	
	@NotEmpty
	private String username;
	
	@OneToMany(mappedBy="user",cascade = CascadeType.ALL)
	private List<Task> tasks;
	
	@ManyToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinTable(name="user_roles",
	joinColumns= {@JoinColumn(name="user_email",referencedColumnName="email")},
	inverseJoinColumns ={@JoinColumn(name="role_name",referencedColumnName="name")} )
	private List<Role> roles;
	
	//constructor ******************************** constructor *****************************************
	public User() {
	
	}
	public User( String email, String password, String username) {
	
		
		this.email = email;
		this.password = password;
		this.username = username;
	}
	
//********************************Getters && Setters*****************************************************
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public List<Task> getTasks() {
		return tasks;
	}
	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
		
	
}
