package htgw.daoImpl;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import htgw.dao.*;

public class DaoImplement<T> implements Dao<T>{

	@Override
	public boolean saveOrUpdate(T o) {
		Session session=HibernateUtil.getSession();
		Transaction trans=session.beginTransaction();
		try{
			
			session.saveOrUpdate(o);
			trans.commit();
			return true;
		}
		catch(Exception e){
			trans.rollback();
			System.out.println("向数据库存入对象时出错");
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean del(T o) {
		Session session=HibernateUtil.getSession();
		Transaction trans=session.beginTransaction();
		try{

			session.delete(o);
			trans.commit();
			return true;
		}
		catch(Exception e){
			trans.rollback();
			return false;	
		}
	}

	@Override
	public boolean delBycondition(String condition) {
		Session session=HibernateUtil.getSession();
		Transaction trans=session.beginTransaction();
		try{
			String hqlStatement=condition;
			
			Query<T> query=session.createQuery(hqlStatement);
			query.executeUpdate();
			trans.commit();
			return true;
		}
		catch(Exception e){
			trans.rollback();
			return false;	
		}
	}

	@Override
	public List<T> query(String hql) {
		
			Session session=HibernateUtil.getSession();
			Transaction trans=session.beginTransaction();
			try{
				List<T> ts;
				String hqlStatement=hql;
				System.out.println(hqlStatement);
				Query<T> query=session.createQuery(hqlStatement);
				ts=query.getResultList();
				
				trans.commit();
				return ts;
			}
			catch(Exception e){
				trans.rollback();
				System.out.println("向数据库查询对象时出错");
				return null;	
			}
	}

	@Override
	public boolean isRepeat(String hqlStatement) {
		List<T> ts=query(hqlStatement);
		if (ts==null ||ts.isEmpty()){
			return false;
		}else{
			return true;
		}
	}

}
