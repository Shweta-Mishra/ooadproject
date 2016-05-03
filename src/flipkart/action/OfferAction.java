package flipkart.action;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

import flipkart.Db.StockDBhandler;
import flipkart.Model.InsertProductModel;

public class OfferAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ArrayList<InsertProductModel> arrInsertProductModelFirst=new ArrayList<InsertProductModel>();
	public ArrayList<InsertProductModel> arrInsertProductModelSecond=new ArrayList<InsertProductModel>();
	public ArrayList<InsertProductModel> arrInsertProductModelFree=new ArrayList<InsertProductModel>();
	public String execute() throws FileNotFoundException{
		try {
			StockDBhandler stockDBhandler = new StockDBhandler();
			//stockDBhandler.FetchCategory(arrInsertProductModel,arruppercategoryModel,arrCategoryModel,arrSubCategoryModel,arrLastCategoryModel); 
			//System.out.println("item for 1"+arrInsertProductModel.get(0).getItem_ID());
			return "success";

		} catch (Exception e) {
			// TODO: handle exception
			return "failure";
		}
	}

}
