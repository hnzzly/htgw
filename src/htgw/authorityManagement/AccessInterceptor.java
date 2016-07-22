package htgw.authorityManagement;

import java.util.Iterator;
import java.util.Map;

import org.hibernate.cfg.Configuration;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import htgw.authorityManagement.Role;
public class AccessInterceptor extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
				// TODO Auto-generated method stub
		ActionContext act=arg0.getInvocationContext();
		//�û���¼��Ҫ��session�з���userName��userAuthorities������
		Map<String,Object> session=act.getSession();
		User user=(User)session.get("user");
		if (user==null){
			act.put("tip", "�Բ�������û�е�¼");
			return "error";
		}else
		{
			String action=act.getName();
			Map<String,String> authorityList=(Map<String,String>)act.getApplication().get("authorityList");
			String authorities=(String)authorityList.get(action);
			if (authorities==null){
				act.put("tip", "����Ա��û�жԱ�ACTION��authorityConfig.xml�н��й�����һ�ε�����");
				return "error";
			}else{
				for(Iterator a=user.getAuthorities().iterator();a.hasNext();){
					Authority authority=(Authority)a.next();
					if(authorities.contains(authority.getAuthorityId().toString())){
						arg0.invoke();
					}
				}
				for(Iterator r=user.getRoles().iterator();r.hasNext();){
					Role role=(Role)r.next();
					for(Iterator a=role.getAuthorities().iterator();a.hasNext();){
						Authority authority=(Authority)a.next();
						if(authorities.contains(authority.getAuthorityId().toString())){
							arg0.invoke();
						}
					}
				}
				
			}
			act.put("tip","��û�б�������Ȩ��");
			return "error";
		}
	}

}
