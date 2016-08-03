package htgw.authorityManagement;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.hibernate.Session;

import org.hibernate.Transaction;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Login extends ActionSupport{
	private String userName="";
	private String password="";
	public String execute() throws Exception {
		ActionContext act=ActionContext.getContext();	
		
	
		
		if(!(userName.isEmpty())){
			String hqlStatement="from User where name=:userName and password=:password";
			Session session=HibernateUtil.getSession();
			Transaction transaction=session.beginTransaction();
			List users;
			
				users= session.createQuery(hqlStatement).setParameter("userName", userName).setParameter("password",password).getResultList();
				transaction.commit();
			
			
					
			if (users.isEmpty()){
				act.put("tip", "对不起，您的用户名或密码错误！");
				return "loginError";
			}else{
				String hqlStatement1="select distinct u from User u left join fetch u.authorities left join fetch u.roles as role left join fetch role.authorities where u.name=:userName and u.password=:password";
				Session session1=HibernateUtil.getSession();
				Transaction ts=session1.beginTransaction();
				List users1=session1.createQuery(hqlStatement1).setParameter("userName", userName).setParameter("password",password).getResultList();
				User u=(User)users1.get(0);
				ts.commit();
				act.getSession().put("user", u);
				/*for(Role r:u.getRoles()){
					for(Authority a:r.getAuthorities()){
						System.out.println(a.getName());
					}
				}
				*/
				return "success";
			}
		}
		act.put("tip", "用户名为空！");
		return "loginError";
	
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
	
		this.password = password;
	}
}
