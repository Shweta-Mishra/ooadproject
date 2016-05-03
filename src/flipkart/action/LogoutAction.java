package flipkart.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport implements SessionAware {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//	private Map<String,Object> session;
	
	Map<String, Object> session = ActionContext.getContext().getSession();
	public String execute()
	{
		session.remove("email");
		session.clear();
		return "logout";
	}
	

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.session=session;
		
	}

}
