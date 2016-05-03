package flipkart.action;

import java.util.ArrayList;

import flipkart.Db.DBHofTrackorder;

import flipkart.Model.TrackOrderModel;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class TrackOrder  extends ActionSupport implements ModelDriven<TrackOrderModel>{
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		TrackOrderModel TM=new TrackOrderModel();
		public ArrayList<TrackOrderModel> OrderList= new ArrayList<TrackOrderModel>();
		public ArrayList<TrackOrderModel> DetailList= new ArrayList<TrackOrderModel>();
		private String term;

	public String getTerm() {
			return term;
		}

		public void setTerm(String term) {
			this.term = term;
		}

	public String execute(){
		System.out.println("m in execute of trackorder");
		DBHofTrackorder db = new DBHofTrackorder();
		OrderList=db.trackOrder();
		
		return "success";
		
		
	}
	
	public String getOrderDetail(){
		System.out.println("m in getOrderDetail of trackorder and orderid="+TM.getOrder_Id());
		DBHofTrackorder db=new DBHofTrackorder();
		DetailList=db.orderDetail(TM.getOrder_Id());
		return "success";
	}
	
	public String cancelOrder(){
		System.out.println("you r in cancel order and Orderid="+term);
		DBHofTrackorder db=new DBHofTrackorder();
		db.CancelOrder(term);
		return "success";	
	}
	
	public String recievedOrder(){
		System.out.println("you r in cancel order and Orderid="+term);
		DBHofTrackorder db=new DBHofTrackorder();
		db.RecievedOrder(term);
		return "success";	
	}
	
	
	
	@Override
	public TrackOrderModel getModel() {
		// TODO Auto-generated method stub
		return TM;
	}
	

}
