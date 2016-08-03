package htgw.authorityManagement;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
@Entity()
@Table(name="role",catalog="htgw")
public class Role {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="roleId")
	private Integer roleId;
	private String name;
	@ManyToMany(targetEntity=Authority.class)
	@JoinTable(name="role_authority",joinColumns={@JoinColumn(name="roleId",referencedColumnName="roleId")},inverseJoinColumns={@JoinColumn(name="authorityId",referencedColumnName="authorityId")})
	@NotFound(action=NotFoundAction.IGNORE) 
	private Set<Authority> authorities=new HashSet<>();
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Authority> getAuthorities() {
		return authorities;
	}
	public void setAuthorities(Set<Authority> authorities) {
		this.authorities = authorities;
	}
	@ManyToMany(targetEntity=User.class)
	@JoinTable(name="user_role",joinColumns={@JoinColumn(name="roleId",referencedColumnName="roleId")},inverseJoinColumns={@JoinColumn(name="userId",referencedColumnName="userId")})
	@NotFound(action=NotFoundAction.IGNORE) 
	private Set<User> users=new HashSet<>();
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
}
