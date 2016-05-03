package flipkart.action;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import flipkart.Db.StockDBhandler;
import flipkart.Model.CategoryModel;
import flipkart.Model.InsertMappingModel;
import flipkart.Model.InsertProductModel;
import flipkart.Model.LastCategoryModel;
import flipkart.Model.SubCategoryModel;
import flipkart.Model.UppercategoryModel;

public class InsertCategoryMappingAction extends ActionSupport implements ModelDriven<InsertMappingModel >{

	private static final long serialVersionUID = 5975020107461435828L;
	public ArrayList<InsertProductModel> arrInsertProductModel=new ArrayList<InsertProductModel>();
	public ArrayList<UppercategoryModel> arruppercategoryModel=new ArrayList<UppercategoryModel>(); 
	public ArrayList<CategoryModel> arrCategoryModel=new ArrayList<CategoryModel>(); 
	public ArrayList<SubCategoryModel> arrSubCategoryModel=new ArrayList<SubCategoryModel>(); 
	public ArrayList<LastCategoryModel> arrLastCategoryModel=new ArrayList<LastCategoryModel>(); 
	InsertMappingModel insertMappingModel = new InsertMappingModel();
	public String execute() throws FileNotFoundException{
		try {
			//System.out.println("insside action"+InsertMappingModel.getSeller_name());
			StockDBhandler stockDBhandler = new StockDBhandler();
		stockDBhandler.InsertMapping(insertMappingModel); 
		stockDBhandler.FetchCategory(arrInsertProductModel, arruppercategoryModel, arrCategoryModel, arrSubCategoryModel, arrLastCategoryModel);	
		System.out.println("Item name"+arrInsertProductModel.get(0).getItem_name());
			
		return "success";

		} catch (Exception e) {
			// TODO: handle exception
			return "failure";
		}
	}
	@Override
	public InsertMappingModel getModel() {
		// TODO Auto-generated method stub
		return insertMappingModel;
	}

}
