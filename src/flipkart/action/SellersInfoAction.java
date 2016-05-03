package flipkart.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import flipkart.Db.StockDBhandler;
import flipkart.Model.SellersInfoModel;



public class SellersInfoAction extends ActionSupport implements ModelDriven<SellersInfoModel> {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5436191746284364919L;
	SellersInfoModel sellersInfoModel=new SellersInfoModel() ;
	public String execute() throws Exception {
		
		try {
			System.out.println("sellersInfoModel.getSeller_ID() in action" + sellersInfoModel.getSeller_ID());
			System.out.println("sellersInfoModel.getSeller_ID() in action" + sellersInfoModel.getSeller_name());
			StockDBhandler stockDBhandler = new StockDBhandler();
			stockDBhandler.SellersInfo(sellersInfoModel);
			System.out.println("sellersInfoAction ");
			return "success";

		} catch (Exception e) {
			// TODO: handle exception
			return "failure";
		}
	
	}

	public String get() throws Exception {

		try {
			StockDBhandler stockDBhandler = new StockDBhandler();
			sellersInfoModel.setSeller_ID(stockDBhandler.FetchsSellerid());
			
					
			
			return "success";

		} catch (Exception e) {
			// TODO: handle exception
			return "failure";
		}
	}
	@Override
	public SellersInfoModel getModel() {
		// TODO Auto-generated method stub
		return sellersInfoModel;
	}
		}

	


