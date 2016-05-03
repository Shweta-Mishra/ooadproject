package flipkart.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import flipkart.Db.*;
import flipkart.Model.*;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class deliveryProduct extends ActionSupport implements ModelDriven<deliveryProductModel>
{
	private static final long serialVersionUID = 1L;
	
	private String pid;
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}	
	
	deliveryProductModel deliveryModel=new deliveryProductModel();
	
	ArrayList<deliveryProductModel> orderDetail1 =new ArrayList<deliveryProductModel>();
	ArrayList<deliveryProductModel> BillDetail =new ArrayList<deliveryProductModel>();
	
	public ArrayList<deliveryProductModel> getBillDetail() {
		return BillDetail;
	}
	public void setBillDetail(ArrayList<deliveryProductModel> billDetail) {
		BillDetail = billDetail;
	}
	public ArrayList<deliveryProductModel> getOrderDetail1() {
		return orderDetail1;
	}
	public void setOrderDetail1(ArrayList<deliveryProductModel> orderDetail1) {
		this.orderDetail1 = orderDetail1;
	}


	productDescriptionDB  prodDB;
	public String execute() throws ClassNotFoundException, SQLException
	{
		productDescriptionDB.Total_Payment = deliveryModel.getTotal();
		prodDB =new productDescriptionDB();
		prodDB.store(deliveryModel);
		orderDetail1 =prodDB.retriveDetail(deliveryModel,pid);
		//System.out.println("hiiiiiiiiiiiiiiiii"+orderDetail1.get(0).getItem());
		deliveryModel.setFlag(1);
		
		return "success";
		
	}
	public String mainBill() throws ClassNotFoundException, SQLException
	{
		prodDB =new productDescriptionDB();
		BillDetail =prodDB.retriveDetail(deliveryModel,pid);
		System.out.println("BillDetail"+BillDetail.get(0).getItem());
		int s=(Integer.parseInt(deliveryModel.getDeliverycharge())* Integer.parseInt(deliveryModel.getQty()));
		
		int total=Integer.parseInt(deliveryModel.getTotal())+s;
		//total=(total*5)/100;
		deliveryModel.setTotal(Integer.toString(total));
		System.out.println("delivery charge is "+(Integer.parseInt(deliveryModel.getDeliverycharge())* Integer.parseInt(deliveryModel.getQty())));
		
		return "success";
		
	}
	
	public String Total() throws ClassNotFoundException, SQLException
	{
		productDescriptionDB.Total_Payment = deliveryModel.getTotal();
		System.out.println("Quantity is"+deliveryModel.getQty());
		productDescriptionDB.quantity = deliveryModel.getQty();
		return "success";
		
	}
	
	public String Cartexecute() throws ClassNotFoundException, SQLException
	{
		
		prodDB =new productDescriptionDB();
		prodDB.store(deliveryModel);
		orderDetail1 =prodDB.retriveDetail(deliveryModel,pid);
		System.out.println("hiiiiiiiiiiiiiiiii"+orderDetail1.get(0).getItem());
		deliveryModel.setFlag(1);
		
		return "success";
		
	}
	
	
	
	@Override
	public deliveryProductModel getModel() {
		// TODO Auto-generated method stub
		return deliveryModel;
	}

}