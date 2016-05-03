package flipkart.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import flipkart.Db.*;
import flipkart.Model.*;

public class PayMentAction extends ActionSupport implements
		ModelDriven<PayMentModel>,SessionAware  {
	Map Session ;
	public Map getSession() {
		return Session;
	}

	public void setSession(Map session) {
		Session = session;
	}

	private static final long serialVersionUID = 2L;

	PayMentModel payMentModel = new PayMentModel();
	ArrayList<String> NameOfProduct = new ArrayList<String>();
	ArrayList<PayMentModel> NameOfProduct1 = new ArrayList<PayMentModel>();

	public ArrayList<PayMentModel> getNameOfProduct1() {
		return NameOfProduct1;
	}

	public void setNameOfProduct1(ArrayList<PayMentModel> nameOfProduct1) {
		NameOfProduct1 = nameOfProduct1;
	}

	private String product;

	public ArrayList<String> getNameOfProduct() {
		return NameOfProduct;
	}

	public void setNameOfProduct(ArrayList<String> nameOfProduct) {
		NameOfProduct = nameOfProduct;
	}

	private String sellerId;
	private String productName;

	public String execute() throws ClassNotFoundException, SQLException {
		System.out.println("In the execute");
		String CardNumber = payMentModel.getCard1();

		System.out.println(CardNumber);

		System.out.println("Here Here");
		productDescriptionDB Credit_Pay = new productDescriptionDB();
		int i = 0;
		i = Credit_Pay.conform_Credit_Pay(payMentModel, CardNumber);
		if (i == 1) {
			payMentModel.setFlag(1);
		}
		if (i == 2) {
			payMentModel.setFlag(2);
		}
		if (i == 0) {
			payMentModel.setFlag(0);
		}
		return "success";

	}

	public String sellerBalance() throws SQLException {
		
		productDescriptionDB productDB = new productDescriptionDB();
		String s1=(String)Session.get("email");
		sellerId=s1;
		NameOfProduct = productDB.updateSeller(sellerId);
		// System.out.println("Array list is"+NameOfProduct.get(2));
		

		return "success";
	}

	public String sellerBalance1() throws SQLException {
		System.out.println(product);
		System.out.println("hi ni handler");String s = sellerBalance();
		NameOfProduct1 = new ArrayList<PayMentModel>();
		productDescriptionDB productDB = new productDescriptionDB();
		int temp = 0, p = 0;
		NameOfProduct1 = productDB.updateSeller1(payMentModel, product);
		for(int i=0;i<NameOfProduct1.size();i++)
		{
			System.out.println("name of product is "+NameOfProduct1.get(i));
		}
		/*if (payMentModel.getS_originalStock() != null
				&& payMentModel.getS_stock() != null) {
			temp = Integer.parseInt(payMentModel.getS_originalStock())
					- Integer.parseInt(payMentModel.getS_stock());
			System.out.println(temp + " tempis;;;;");

			p = temp * Integer.parseInt(payMentModel.getS_price());
			System.out.println(p + " p is;;;;");
			payMentModel.setS_price(Integer.toString(p));
			payMentModel.setS_stock(Integer.toString(temp));
		}*/

		

		return "success";

	}

	public String Debit() throws ClassNotFoundException, SQLException {
		System.out.println("In the execute");
		String CardNumber = payMentModel.getCard1();

		System.out.println(CardNumber);

		System.out.println("Here Here");
		productDescriptionDB Credit_Pay = new productDescriptionDB();
		int i = 0;
		i = Credit_Pay.conform_Debit_Pay(payMentModel, CardNumber);
		if (i == 1) {
			payMentModel.setFlag(1);
		}
		if (i == 2) {
			payMentModel.setFlag(2);
		}
		if (i == 0) {
			payMentModel.setFlag(0);
		}
		if (i == 4) {
			payMentModel.setFlag(4);
		}
		;
		return "success";

	}

	public String NetBanking() throws ClassNotFoundException, SQLException {
		System.out.println("In the execute");
		String Acc_No = payMentModel.getBank_ID();

		System.out.println("Here Here");
		productDescriptionDB Bank_Pay = new productDescriptionDB();
		int i = 0;
		i = Bank_Pay.conform_NetBanking_Pay(payMentModel, Acc_No);
		if (i == 1) {
			payMentModel.setFlag(1);
		}
		if (i == 2) {
			payMentModel.setFlag(2);
		}
		if (i == 0) {
			payMentModel.setFlag(0);
		}
		return "success";

	}

	@Override
	public PayMentModel getModel() {
		System.out.println("I am in getModel");
		// TODO Auto-generated method stub
		return payMentModel;
	}

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	

}