package flipkart.action;

import java.io.FileNotFoundException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;


import flipkart.Db.DBhandlerForAccount_Setting;
import flipkart.Model.Usermodel;

import com.opensymphony.xwork2.ModelDriven;

public class GetUserAddress implements SessionAware,ModelDriven<Usermodel>
{
	public Usermodel ad= new Usermodel();
	private Map session; 
	String userid;
	
	public String getaddresses() throws FileNotFoundException{
		DBhandlerForAccount_Setting op= new DBhandlerForAccount_Setting();
		String uid=(String) session.get("email");
		System.out.println(uid);
		 ad.setUid(uid);;	
        //System.out.println(ad.getUid());
		op.fetchaddress(ad);
		
		return "success";
	}

	public Usermodel getModel() {
		
		return ad;
	}

	
	public void setSession(Map<String, Object> session) {
		
		this.session=session;
	}

}
