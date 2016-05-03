package flipkart.action;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import flipkart.Db.DBhandlerForAccount_Setting;
import flipkart.Model.Usermodel;

import com.opensymphony.xwork2.ModelDriven;

public class UpdateAddress implements SessionAware,ModelDriven<Usermodel>
{
public Usermodel us= new Usermodel();
private Map session; 

public Map getSession() {
	return session;
}

       public String updateaddresses() throws FileNotFoundException, SQLException
       {
    	   DBhandlerForAccount_Setting op= new DBhandlerForAccount_Setting();
	    String user1 =(String) session.get("email");
	
          us.setUid(user1);
		op.updateaddress(us);
		return "success";
       }
public Usermodel getModel() {
	
	return us;
}
@Override
public void setSession(Map<String, Object> session) {

	this.session=session;
}
}


