package flipkart.action;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ModelDriven;

import flipkart.Db.DBhandlerForAccount_Setting;
import flipkart.Model.Usermodel;


public class Notification  implements SessionAware,ModelDriven<Usermodel>{
	
	public Usermodel us= new Usermodel();
	String message;
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	private Map session; 
	public Map getSession() {
		return session;
	                        }
	ArrayList<Usermodel> Orders=new ArrayList<Usermodel>();
	
	public ArrayList<Usermodel> getOrders() {
		return Orders;
	}

	public void setOrders(ArrayList<Usermodel> orders) {
		Orders = orders;
	}

	public String notification() throws FileNotFoundException, SQLException{
	

	DBhandlerForAccount_Setting op= new DBhandlerForAccount_Setting();
    String user =(String) session.get("email");
    
System.out.println(user);
System.out.println("hello");
      us.setUid(user);
      
	
 try{
	 Orders = op.getNotificationData(us);

		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("Orders",Orders);
		
	
		
		 
		
		if(us.getMessage().equals("true"))
			 return "unsuccess";
			else 
		return "success";
		
		
}
 catch (Exception e) {
		
		e.printStackTrace();
		System.out.println("error notification");
		return "error";
	
 }
	}
 public String Nonotification() throws FileNotFoundException, SQLException{
		

		DBhandlerForAccount_Setting op= new DBhandlerForAccount_Setting();
	    String user1 =(String) session.get("email");

	      us.setUid(user1);
		
	 /*try{*/
		 Orders = op.getNotificationData(us);

			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("Orders",Orders);
			
		
			
			 
			
			if(Orders.size()>=1)
				 return "success";
				else 
			return "error";
			
			
	/*catch (Exception e) {
		
		e.printStackTrace();
		System.out.println("error notification");
		return "error";
	
 }*/
	
	 
}

	@Override
	public Usermodel getModel() {
	
		return us;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
		
	}

}
