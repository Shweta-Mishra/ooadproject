package flipkart.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import flipkart.Db.StockDBhandler;
import flipkart.Model.SubCategoryModel;


public class SubCategoryAction  extends ActionSupport implements
ModelDriven<SubCategoryModel>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	SubCategoryModel subcategoryModel =new SubCategoryModel();
	public String execute() throws Exception {

		try {
			StockDBhandler stockDBhandler = new StockDBhandler();
		stockDBhandler.InsertSubCategory(subcategoryModel); ;
			
			return "success";

		} catch (Exception e) {
			// TODO: handle exception
			return "failure";
		}
	}
	public String get() throws Exception {

		try {
			StockDBhandler stockDBhandler = new StockDBhandler();
			subcategoryModel.setSC_ID(stockDBhandler.FetchsSubCategory());
			System.out.println("scid "+ subcategoryModel.getSC_ID());
					
			
			return "success";

		} catch (Exception e) {
			// TODO: handle exception
			return "failure";
		}
	}

	@Override
	public SubCategoryModel getModel() {
		// TODO Auto-generated method stub
		return subcategoryModel;
	}

}
