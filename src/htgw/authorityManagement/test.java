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
		//SessionFactory sf=cfg.configure().buildSessionFactory();//*过期方法*解析Hibernate.cfg.xml 然后返回一个已经拥有配置选项的Configuration
		org.hibernate.service.ServiceRegistry sr=new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).getBootstrapServiceRegistry();
		//SessionFactory类似数据库库的一个Connection
		SessionFactory sf =cfg.buildSessionFactory(sr);
		//打开一个连接
		Session session =sf.openSession();
		//开始一个事务
		Transaction t=session.beginTransaction();*/
		Authority a1=new Authority();
		Authority a2=new Authority();
		
		
		a1.setName("测试权力1");
		a2.setName("测试权力2");
		session.save(a1);
		session.save(a2);
		Set<Authority> authorities=new HashSet<>();
		authorities.add(a1);
		authorities.add(a2);
		User user=new User();
		user.setName("张三");
		user.setAge(23);
		user.setCellphone("18638397277");
		user.setAuthorities(authorities);
		Role r1=new Role();
		r1.setName("管理角色");
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
