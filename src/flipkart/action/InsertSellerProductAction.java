package flipkart.action;

import java.io.FileNotFoundException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import flipkart.Db.StockDBhandler;
import flipkart.Model.InsertSellerProductModel;

public class InsertSellerProductAction extends ActionSupport implements SessionAware,ModelDriven<InsertSellerProductModel >{

	private static final long serialVersionUID = 5975020107461435828L;
	
	InsertSellerProductModel insertSellerProductModel = new InsertSellerProductModel();
	Map session;
	public Map getSession() {
		return session;
	}
	public void setSession(Map session) {
		this.session = session;
	}
	public String execute() throws FileNotFoundException{
		try {
			System.out.println("insside action"+insertSellerProductModel.getSeller_name());
			StockDBhandler stockDBhandler = new StockDBhandler();
		stockDBhandler.InsertSellerProduct(insertSellerProductModel); 
		
		return "success";

		} catch (Exception e) {
			// TODO: handle exception
			return "failure";
		}
	}
	public String get() throws FileNotFoundException{
		try {
			System.out.println("insside action");
			StockDBhandler stockDBhandler = new StockDBhandler();
			String uid=(String)session.get("email");
			System.out.println("insside action"+insertSellerProductModel.getPrice());
			
			
			stockDBhandler.UpdateSellerProduct(insertSellerProductModel,uid); 
		return "success";

		} catch (Exception e) {
			// TODO: handle exception
			return "failure";
		}
	}
	@Override
	public InsertSellerProductModel getModel() {
		// TODO Auto-generated method stub
		return insertSellerProductModel;
	}

}
