package flipkart.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import flipkart.Db.DBHandlerLogin;
import flipkart.Model.*;


public class SignupAction extends ActionSupport implements ModelDriven<SignupModel>,SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	SignupModel sm = new SignupModel();
	DBHandlerLogin dbh = new DBHandlerLogin();
	String compare;
	String Check;
	String result = "error";
	String message = null;
 	
	public String getMessage() {
		return message;
	}





	public void setMessage(String message) {
		this.message = message;
	}





	public String execute() throws Exception{
		
		Check = dbh.CheckForU_IDAlreadyExist(sm.getEmail());
		if (Check.equals("valid"))
		{
		compare =  dbh.AddUser(sm);
		if(compare.equals("user"))
			
			result = "user";
		else
			result = "error";
		message = "Email Id Already Exist! ";
		}
		return result;
	}
	
	
	
	
	
	public SignupModel getSm() {
		return sm;
	}

	public void setSm(SignupModel sm) {
		this.sm = sm;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public SignupModel getModel() {
		// TODO Auto-generated method stub
		return sm;
	}

} 
