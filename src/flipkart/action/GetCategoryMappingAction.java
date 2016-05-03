package flipkart.action;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

import flipkart.Db.StockDBhandler;
import flipkart.Model.CategoryModel;
import flipkart.Model.InsertProductModel;
import flipkart.Model.LastCategoryModel;
import flipkart.Model.SubCategoryModel;
import flipkart.Model.UppercategoryModel;

public class GetCategoryMappingAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
		public ArrayList<InsertProductModel> arrInsertProductModel=new ArrayList<InsertProductModel>();
		public ArrayList<UppercategoryModel> arruppercategoryModel=new ArrayList<UppercategoryModel>(); 
		public ArrayList<CategoryModel> arrCategoryModel=new ArrayList<CategoryModel>(); 
		public ArrayList<SubCategoryModel> arrSubCategoryModel=new ArrayList<SubCategoryModel>(); 
		public ArrayList<LastCategoryModel> arrLastCategoryModel=new ArrayList<LastCategoryModel>(); 
		public String execute() throws FileNotFoundException{
	try {
		StockDBhandler stockDBhandler = new StockDBhandler();
		stockDBhandler.FetchCategory(arrInsertProductModel,arruppercategoryModel,arrCategoryModel,arrSubCategoryModel,arrLastCategoryModel); 
		System.out.println("item for 1"+arrInsertProductModel.get(0).getItem_ID());
		return "success";

	} catch (Exception e) {
		// TODO: handle exception
		return "failure";
	}
}

}
