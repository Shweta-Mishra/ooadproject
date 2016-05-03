package flipkart.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ModelDriven;


import flipkart.Db.DBhandlerForAccount_Setting;
import flipkart.Model.Usermodel;



public class Deactive_acc implements SessionAware,ModelDriven<Usermodel>{
	Usermodel us =new Usermodel();
	private Map session; 
	public String Deactiveaccount()
	{
		System.out.println("abc");
		String user1=(String) session.get("email");
		  us.setUid(user1);
		System.out.println(user1);
		DBhandlerForAccount_Setting db = new DBhandlerForAccount_Setting();
		
		try {
			db.deactivateAccount(us);
		
			System.out.println("abcd");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			return "error";
		}
		
		return "success";
		
	}
	@Override
	public Usermodel getModel() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session=session;
	}
}
