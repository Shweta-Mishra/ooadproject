package flipkart.action;

import flipkart.Db.StockDBhandler;
import flipkart.Model.InsertProductModel;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class InsertProductAction extends ActionSupport implements ModelDriven<InsertProductModel> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 InsertProductModel insertProductModel=new InsertProductModel() ;
	public String execute() throws Exception {
		
		try {
			
			StockDBhandler stockDBhandler = new StockDBhandler();
			stockDBhandler.InsertProduct(insertProductModel);
			System.out.println("InsertProductAction  "+insertProductModel.getItem_ID());
			return "success";

		} catch (Exception e) {
			// TODO: handle exception
			return "failure";
		}
	}
	public String get() throws Exception {

		try {
			StockDBhandler stockDBhandler = new StockDBhandler();
			insertProductModel.setItem_ID(stockDBhandler.FetchPid());
			System.out.println("upid "+ insertProductModel.getItem_ID());
					
			
			return "success";

		} catch (Exception e) {
			// TODO: handle exception
			return "failure";
		}
	}

	@Override
	public InsertProductModel getModel() {
		// TODO Auto-generated method stub
		return insertProductModel;
	}

}
