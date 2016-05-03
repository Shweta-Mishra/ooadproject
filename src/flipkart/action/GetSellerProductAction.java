package flipkart.action;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import flipkart.Db.StockDBhandler;
import flipkart.Model.InsertProductModel;
import flipkart.Model.SellersInfoModel;

public class GetSellerProductAction extends ActionSupport implements SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	Map session;
	public Map getSession() {
		return session;
	}
	public void setSession(Map session) {
		this.session = session;
	}
	private String SP_id="abc";
	
	public String getSP_id() {
		return SP_id;
	}
	public void setSP_id(String sP_id) {
		SP_id = sP_id;
	}
	public ArrayList<SellersInfoModel> arrSellersInfoModel=new ArrayList<SellersInfoModel>(); 
	public ArrayList<InsertProductModel> arrInsertProductModel=new ArrayList<InsertProductModel>();
	public String execute() throws FileNotFoundException{
	try {
		StockDBhandler stockDBhandler = new StockDBhandler();
	stockDBhandler.FetchSellerProduct(arrSellersInfoModel,arrInsertProductModel); 
		System.out.println("item for 1"+arrInsertProductModel.get(0).getItem_ID());
		setSP_id(stockDBhandler.FetchsSPid());
		System.out.println("Sp-id "+ SP_id);
		return "success";

	} catch (Exception e) {
		// TODO: handle exception
		return "failure";
	}
}
	public String get() throws FileNotFoundException{
		try {
			String uid=(String)session.get("email");
			StockDBhandler stockDBhandler = new StockDBhandler();
			stockDBhandler.FetchSellerProductAccount(arrInsertProductModel,uid); 
			System.out.println("item for 1"+arrInsertProductModel.get(0).getItem_ID());
			return "success";

		} catch (Exception e) {
			// TODO: handle exception
			return "failure";
		}
	}

	
}
