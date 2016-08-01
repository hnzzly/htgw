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
		//查询是否有空或重名的用户
		ActionContext act=ActionContext.getContext();
		if(user.getName().isEmpty()||(user.getName()==null)){
			act.put("tip", "用户名不能为空，请填写用户名后再试");
			return "error";
		}
		String hqlStatement="from User where name='"+user.getName()+"'";
		
		if (dao.isRepeat(hqlStatement)){
			act.put("tip", "因为有用户名重复所以不能添加，请更换用户名后再试");
			return "error";
			
		}else{
			if(dao.saveOrUpdate(user)){
				act.put("tip", "修改成功！");
				return "success";
			}else{
				act.put("tip", "因为未知的原因添加用户没有成功！");
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
