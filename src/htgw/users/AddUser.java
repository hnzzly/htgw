package htgw.users;

import htgw.authorityManagement.*;
import htgw.dao.Dao;
import htgw.daoImpl.DaoImplement;
import javassist.bytecode.Descriptor.Iterator;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AddUser extends ActionSupport{
	private User user;
	private List<Authority> authorities;
	private List<Role> roles;
	private List<String> sAuthorities;
	private List<String> sRoles;
	private DaoImplement<User> dao=new DaoImplement<User>();
	private DaoImplement<Authority> adao=new DaoImplement<Authority>();
	private DaoImplement<Role> rdao=new DaoImplement<Role>();

	
	public List<String> getsAuthorities() {
		return sAuthorities;
	}
	public void setsAuthorities(List<String> sAuthorities) {
		this.sAuthorities = sAuthorities;
	}
	public List<String> getsRoles() {
		return sRoles;
	}
	public void setsRoles(List<String> sRoles) {
		this.sRoles = sRoles;
	}
	public String preAdd(){
		
		authorities=adao.query("from Authority");
		roles=rdao.query("from Role");
		
		return "addUser";
	}
	public String add(){
		//��ѯ�Ƿ��пջ��������û�
		ActionContext act=ActionContext.getContext();
		if(user.getName().isEmpty()||(user.getName()==null)){
			act.put("tip", "�û�������Ϊ�գ�����д�û���������");
			return "error";
		}
		String hqlStatement="from User where name='"+user.getName()+"'";
		
		if (dao.isRepeat(hqlStatement)){
			act.put("tip", "��Ϊ���û����ظ����Բ�����ӣ�������û���������");
			return "error";
			
		}else{
			
			if(saveUser()){
				act.put("tip", "��ӳɹ���");
				return "success";
			}else{
				act.put("tip", "��Ϊδ֪��ԭ������û�û�гɹ���");
				return "error";
			}
		}
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Authority> getAuthorities() {
		return authorities;
	}
	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	private boolean saveUser(){
		Session session=HibernateUtil.getSession();
		Transaction tran=session.beginTransaction();
		
		try{
			for(int i=0;i<sRoles.size();i++){
				Role r=session.load(Role.class,Integer.parseInt(sRoles.get(i)));
				r.getUsers().add(user);
				session.update(r);
			}
			for(int i=0;i<sAuthorities.size();i++){
				
				Authority a=session.load(Authority.class,Integer.parseInt(sAuthorities.get(i)));
				a.getUsers().add(user);
				session.update(a);
			}
		session.saveOrUpdate(user);
		tran.commit();
		return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
}
