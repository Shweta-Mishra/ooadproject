package flipkart.action;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;


import flipkart.Db.DBhandlerForAccount_Setting;
import flipkart.Model.Usermodel;

import com.opensymphony.xwork2.ModelDriven;



public class UpdatePersonal_Info implements SessionAware,ModelDriven<Usermodel>
{
public Usermodel us= new Usermodel();
private Map session; 

public Map getSession() {
	return session;
}



public String updateinfo() throws FileNotFoundException{
	
	DBhandlerForAccount_Setting op= new DBhandlerForAccount_Setting();
		try
		{
	String uid=	(String) session.get("email");
         us.setUid(uid);
		 op.updatedetails(us);
		 return "success";
	}
         catch(Exception e) {
		 e.printStackTrace();
		 return "error";
		}
}

public String Validate() throws SQLException
{
	System.out.println("function");
	String uid=	(String) session.get("email");
    us.setUid(uid);
	String compare;
	DBhandlerForAccount_Setting db= new DBhandlerForAccount_Setting();
	
	compare=db.chkForEmailID_PasswordAlreadyExists(us);
	String message;
	if(compare.equals("invalid"))
	{
		System.out.println(us.getUid());
		message = "notavailable";
	}
	else
	{
		message="available";
	}
	System.out.println(message);

	return "success";

}


public String executechangepass() throws Exception{
	
	
	DBhandlerForAccount_Setting op= new DBhandlerForAccount_Setting();
	try
	{
	String uid=	(String) session.get("email");
	
    us.setUid(uid);
    
	us.setPassword(us.getNewpassword());
	
	op.changepassword(us);
	return "success";
		
	} catch(Exception e) {
		// TODO Auto-generated catch block
	e.printStackTrace();
		return "error";
	}
}

public String executemail() {
	
	System.out.println("abcccc");

	
	DBhandlerForAccount_Setting op= new DBhandlerForAccount_Setting();
	try
	{
	String uid=(String) session.get("email");
	System.out.println(uid);
	us.setUid(uid);
	//us.setUid(us.getNewemail());
	us.setNewemail(us.getNewemail());
    
   
	
	op.changemail(us);
	return "success";
	
	} catch(Exception e) {
		
	e.printStackTrace();
		return "error";
	}
}


public Usermodel getModel() {

	// TODO Auto-generated method stub
	return us;
}



@Override
public void setSession(Map<String, Object> session) {
	this.session=session;
}
	// TODO Auto-generated method stub
	
}

	
