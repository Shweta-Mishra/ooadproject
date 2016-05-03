package flipkart.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import flipkart.Db.StockDBhandler;
import flipkart.Model.Usermodel;

public class GetSellerAction extends ActionSupport implements
 SessionAware,ModelDriven<Usermodel>{
	Map session;
	public Map getSession() {
		return session;
	}
	public void setSession(Map session) {
		this.session = session;
	}
	/**
	 * 
	 */
	Usermodel usermodel =new Usermodel();
	private static final long serialVersionUID = 1L;
	public String execute() throws Exception {

		try {
			String uid=(String)session.get("email");
			StockDBhandler stockDBhandler = new StockDBhandler();
		stockDBhandler.GetSellerInfo(usermodel,uid); ;
			
			return "success";

		} catch (Exception e) {
			// TODO: handle exception
			return "failure";
		}
	}

	@Override
	public Usermodel getModel() {
		// TODO Auto-generated method stub
		return usermodel;
	}

}
