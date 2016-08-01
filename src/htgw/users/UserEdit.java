package htgw.users;

import java.util.Map;



import htgw.authorityManagement.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class UserEdit extends ActionSupport{
	//这个用户是从SESSION里读出来的，将来也可以从数据库里取
	private User user;
	ActionContext act=ActionContext.getContext();
	public String execute(){
		Map<String,Object> session=act.getSession();
		user=(User)session.get("user");
		return "showUser";
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
