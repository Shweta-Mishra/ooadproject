package flipkart.action;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import flipkart.Db.DBHandlerLogin;
import flipkart.Db.*;
import flipkart.Model.LoginModel;
import flipkart.Model.User;
import java.util.*;
public class LoginAction extends ActionSupport implements ModelDriven<LoginModel>,SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	LoginModel ldetails = new LoginModel();
	DBHandlerLogin dbh = new DBHandlerLogin();
	CartDBhandler cdb=new CartDBhandler();
	
	private String message;
	User user1 = new User();


	Map<String, Object> session = ActionContext.getContext().getSession();


	public User getUser1() {
		return user1;
	}

	public void setUser1(User user1) {
		this.user1 = user1;
	}

	public void setLdetails(LoginModel ldetails) {
		this.ldetails = ldetails;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}







	public String execute() throws Exception
	{

		String role;
		String User_ID ;


		//User U1 = (User)session.put("email", ldetails.getEmail());
		//System.out.println("session"+U1);

		//if(U1!= null)
		
		String fname = dbh.getFname(ldetails.getEmail(),ldetails.getPassword());
		role = dbh.getRole(ldetails.getEmail());
		//		m.put("fname",fname);

		if(fname.equalsIgnoreCase("wrong"))
		{
			message = "Invalid Credentials";
			
			return "error";	
			
		}else
		{
			session.put("fname", fname);
			session.put("email", ldetails.getEmail());
			System.out.println(session.get("email"));
			System.out.println(session.get("fname"));	
			//System.out.prin();

			message =  fname;//for ajax call

			if(!((fname.equals("wrong")) && (role.equalsIgnoreCase("invalid"))))
			{

				user1.setFname(fname);
				cdb.ChangeUserAfterLogin(ldetails.getEmail());
				//System.out.println(user1.getFname());
				//System.out.println(fname);
				return role; 
			}
			else
			{
				return "error";
				}
		}	
	
	}

	@Override
	public LoginModel getModel() {
		// TODO Auto-generated method stub
		return ldetails;
	}

	@Override
	public void setSession(Map session) {
		this.ldetails.session=session;

	}

}




