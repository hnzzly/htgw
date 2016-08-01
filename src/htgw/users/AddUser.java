package htgw.users;

import htgw.authorityManagement.User;
import htgw.dao.Dao;
import htgw.daoImpl.DaoImplement;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AddUser extends ActionSupport{
	private User user;
	
	private DaoImplement<User> dao=new DaoImplement<User>();
	
	public String preAdd(){
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
			if(dao.saveOrUpdate(user)){
				act.put("tip", "�޸ĳɹ���");
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
}
