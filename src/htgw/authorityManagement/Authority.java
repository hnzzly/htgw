
package htgw.authorityManagement;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
@Entity
@Table(name="authority")
public class Authority {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="authorityId")
private Integer authorityId;
private String name;
@ManyToMany(targetEntity=User.class,cascade=CascadeType.PERSIST)
@JoinTable(name="user_authority",joinColumns={@JoinColumn(name="authorityId",referencedColumnName="authorityId")},inverseJoinColumns={@JoinColumn(name="userId",referencedColumnName="userId")})
@NotFound(action=NotFoundAction.IGNORE) 
private Set<User> users=new HashSet<>();

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Set<User> getUsers() {
	return users;
}
public void setUsers(Set<User> users) {
	this.users = users;
}

@ManyToMany(targetEntity=Role.class,cascade=CascadeType.PERSIST)
@JoinTable(name="role_authority",joinColumns={@JoinColumn(name="authorityId",referencedColumnName="authorityId")},inverseJoinColumns={@JoinColumn(name="roleId",referencedColumnName="roleId")})
@NotFound(action=NotFoundAction.IGNORE) 
private Set<Role> roles=new HashSet<>();

public Integer getAuthorityId() {
	return authorityId;
}
public void setAuthorityId(Integer authorityId) {
	this.authorityId = authorityId;
}
public Set<Role> getRoles() {
	return roles;
}
public void setRoles(Set<Role> roles) {
	this.roles = roles;
}

}
