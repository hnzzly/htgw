package htgw.users;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import htgw.authorityManagement.*;
import htgw.daoImpl.*;
public class UpdateUser extends ActionSupport{
	private User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String execute(){
		DaoImplement<User> dao=new DaoImplement<User>();
		
		if(dao.saveOrUpdate(user)){
			ActionContext.getContext().put("tip", "修改成功！");
			return "success";
		}else{
			ActionContext.getContext().put("tip", "修改失败！");
			return "error";

		}
	}
}
