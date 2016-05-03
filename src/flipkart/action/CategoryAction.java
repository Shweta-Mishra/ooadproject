package flipkart.action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import flipkart.Db.StockDBhandler;
import flipkart.Model.CategoryModel;
public class CategoryAction extends ActionSupport implements
		ModelDriven<CategoryModel> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2441628391140999078L;
	CategoryModel categoryModel =new CategoryModel();
	public String execute() throws Exception {

		try {
			StockDBhandler stockDBhandler = new StockDBhandler();
		stockDBhandler.InsertCategory(categoryModel); ;
			
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
