package htgw.authorityManagement;

import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class test extends ActionSupport{
	public static void main(String[] args){
		 Configuration config=new Configuration().configure();
		SessionFactory sessionfactory=config.buildSessionFactory();
		Session session=sessionfactory.openSession();
		Transaction t=session.beginTransaction();
		
		/*Configuration cfg = new Configuration();
		cfg.configure();
		//SessionFactory sf=cfg.configure().buildSessionFactory();//*���ڷ���*����Hibernate.cfg.xml Ȼ�󷵻�һ���Ѿ�ӵ������ѡ���Configuration
		org.hibernate.service.ServiceRegistry sr=new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).getBootstrapServiceRegistry();
		//SessionFactory�������ݿ���һ��Connection
		SessionFactory sf =cfg.buildSessionFactory(sr);
		//��һ������
		Session session =sf.openSession();
		//��ʼһ������
		Transaction t=session.beginTransaction();*/
		Authority a1=new Authority();
		Authority a2=new Authority();
		
		
		a1.setName("����Ȩ��1");
		a2.setName("����Ȩ��2");
		session.save(a1);
		session.save(a2);
		Set<Authority> authorities=new HashSet<>();
		authorities.add(a1);
		authorities.add(a2);
		User user=new User();
		user.setName("����");
		user.setAge(23);
		user.setCellphone("18638397277");
		user.setAuthorities(authorities);
		Role r1=new Role();
		r1.setName("�����ɫ");
		r1.setAuthorities(authorities);
		session.save(r1);
		Set<Role> rules=new HashSet<>();
		rules.add(r1);
		user.setRoles(rules);
		
		session.save(user);
		t.commit();
		session.close();
	}
	public String execute() throws Exception {
		return "success";
	}
	
}
