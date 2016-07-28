package htgw.authorityManagement;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity()
@Table(name="user")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="userId",unique=true,nullable=false)
	private Integer userId;
	private String name;
	private Integer age;
	private String cellphone;
	private String password;
	@ManyToMany(targetEntity=Authority.class,mappedBy="users")
	//@JoinTable(name="user_authority",joinColumns={@JoinColumn(name="userId",referencedColumnName="userId")},inverseJoinColumns={@JoinColumn(name="authorityId",referencedColumnName="authorityId")})
	private Set<Authority> authorities=new HashSet<>();
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	public Set<Authority> getAuthorities() {
		return authorities;
	}
	public void setAuthorities(Set<Authority> authorities) {
		this.authorities = authorities; 
	}
	@ManyToMany(targetEntity=Role.class,fetch=FetchType.LAZY,mappedBy="users" )
	//@JoinTable(name="user_role",joinColumns={@JoinColumn(name="userId",referencedColumnName="userId")},inverseJoinColumns={@JoinColumn(name="roleId",referencedColumnName="roleId")})
	private Set<Role> roles=new HashSet<>();
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	}
