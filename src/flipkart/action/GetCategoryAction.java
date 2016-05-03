package flipkart.action;

import java.io.FileNotFoundException;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import flipkart.Db.StockDBhandler;
import flipkart.Model.CategoryModel;


public class GetCategoryAction extends ActionSupport implements
ModelDriven<CategoryModel> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	CategoryModel categoryModel = new CategoryModel();
	public String execute() throws FileNotFoundException{
		try {
			StockDBhandler stockDBhandler = new StockDBhandler();
			categoryModel.setC_ID(stockDBhandler.FetchCategory());
			System.out.println("cid "+ categoryModel.getC_ID());
			return "success";

		} catch (Exception e) {
			// TODO: handle exception
			return "failure";
		}
	}
	@Override
	public CategoryModel getModel() {
		// TODO Auto-generated method stub
		return categoryModel;
	}
}
