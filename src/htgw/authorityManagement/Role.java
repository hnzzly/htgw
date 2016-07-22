package htgw.authorityManagement;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
@Entity()
@Table(name="role",catalog="htgw")
public class Role {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="roleId")
	private Integer roleId;
	private String name;
	@ManyToMany(targetEntity=Authority.class,cascade=CascadeType.PERSIST)
	@JoinTable(name="role_authority",joinColumns={@JoinColumn(name="roleId",referencedColumnName="roleId")},inverseJoinColumns={@JoinColumn(name="authorityId",referencedColumnName="authorityId")})
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
	
}
