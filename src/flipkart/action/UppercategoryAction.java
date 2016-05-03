package flipkart.action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import flipkart.Db.StockDBhandler;
import flipkart.Model.UppercategoryModel;
public class UppercategoryAction extends ActionSupport implements
		ModelDriven<UppercategoryModel> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2441628391140999078L;
	UppercategoryModel uppercategoryModel =new UppercategoryModel();
	public String execute() throws Exception {

		try {
			StockDBhandler stockDBhandler = new StockDBhandler();
		stockDBhandler.InsertUpperCategory(uppercategoryModel); ;
			
			return "success";

		} catch (Exception e) {
			// TODO: handle exception
			return "failure";
		}
	}
	public String get() throws Exception {

		try {
			StockDBhandler stockDBhandler = new StockDBhandler();
			uppercategoryModel.setUP_ID(stockDBhandler.FetchsUpperCategory());
			System.out.println("upid "+ uppercategoryModel.getUP_ID());
					
			
			return "success";

		} catch (Exception e) {
			// TODO: handle exception
			return "failure";
		}
	}

	@Override
	public UppercategoryModel getModel() {
		// TODO Auto-generated method stub
		return uppercategoryModel;
	}

}
