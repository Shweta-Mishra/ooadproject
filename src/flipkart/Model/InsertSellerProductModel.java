package flipkart.Model;

public class InsertSellerProductModel {
	String Seller_name;
	String Item_name;
	String SP_ID;
	String Price;
	public String getPrice() {
		return Price;
	}
	public void setPrice(String price) {
		Price = price;
	}
	int Deliverycharge;
	int Stock;
	
	
	public String getSeller_name() {
		return Seller_name;
	}
	public void setSeller_name(String seller_name) {
		Seller_name = seller_name;
	}
	public String getItem_name() {
		return Item_name;
	}
	public void setItem_name(String item_name) {
		Item_name = item_name;
	}
	public String getSP_ID() {
		return SP_ID;
	}
	public void setSP_ID(String sP_ID) {
		SP_ID = sP_ID;
	}
	
	public int getDeliverycharge() {
		return Deliverycharge;
	}
	public void setDeliverycharge(int deliverycharge) {
		Deliverycharge = deliverycharge;
	}
	public int getStock() {
		return Stock;
	}
	public void setStock(int stock) {
		Stock = stock;
	}
	
}
