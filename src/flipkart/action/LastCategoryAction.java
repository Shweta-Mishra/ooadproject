package flipkart.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import flipkart.Db.StockDBhandler;
import flipkart.Model.LastCategoryModel;

public class LastCategoryAction extends ActionSupport implements
ModelDriven<LastCategoryModel>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	LastCategoryModel lastcategoryModel =new LastCategoryModel();
	public String execute() throws Exception {

		try {
			StockDBhandler stockDBhandler = new StockDBhandler();
		stockDBhandler.InsertLastCategory(lastcategoryModel); ;
			
			return "success";

		} catch (Exception e) {
			// TODO: handle exception
			return "failure";
		}
	}
	public String get() throws Exception {

		try {
			StockDBhandler stockDBhandler = new StockDBhandler();
			lastcategoryModel.setLC_ID(stockDBhandler.FetchsLastCategory());
			System.out.println("upid "+ lastcategoryModel.getLC_ID());
					
			
			return "success";

		} catch (Exception e) {
			// TODO: handle exception
			return "failure";
		}
	}

	@Override
	public LastCategoryModel getModel() {
		// TODO Auto-generated method stub
		return lastcategoryModel;
	}

}
