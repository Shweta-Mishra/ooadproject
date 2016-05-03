package flipkart.action;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ModelDriven;


import flipkart.Db.DBhandlerForAccount_Setting;
import flipkart.Model.Usermodel;




public class FetchPersonalInfo implements SessionAware,ModelDriven<Usermodel>{

public Usermodel us= new Usermodel();
private Map session; 
String userid;


/*public String fetchinfo() throws FileNotFoundException{
	DBhandlerForAccount_Setting op= new DBhandlerForAccount_Setting();
		try
		{
			
//session.put("userid", us.getUid());

String user1=(String) session.get("userid");
System.out.println(user1);
 us.setUid(user1);
		op.fetchdetails(us);
		
		return "success";
	}catch(Exception e)
	    {
		e.printStackTrace();
		return "error";
		
		}
	}
*/
public String getinfo() throws FileNotFoundException{
	DBhandlerForAccount_Setting op= new DBhandlerForAccount_Setting();
	try
	{
		
//session.put("userid", us.getUid());

String user1=(String) session.get("email");
System.out.println(user1);
us.setUid(user1);
	op.fetchdetails(us);
	
	return "success";
}catch(Exception e)
    {
	e.printStackTrace();
	return "error";
	
	}
}






public Usermodel getModel() {
	return us;
}


@Override
public void setSession(Map<String, Object> session) {
	// TODO Auto-generated method stub
	this.session=session;
	
}

	
}
