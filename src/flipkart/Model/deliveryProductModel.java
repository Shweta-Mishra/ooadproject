package flipkart.Model;

public class deliveryProductModel
{

	private String userName;
	private String pincode;
	private String city;
	private String phone;
	private String address;
	private String U_ID;
	private String STOCK,item,price,detail,subtotal,total,seller,brand,destpath,SP_ID,qty,itemName,deliverycharge;
	
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(String subtotal) {
		this.subtotal = subtotal;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	private int flag;
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getU_ID() {
		return U_ID;
	}
	public void setU_ID(String u_ID) {
		U_ID = u_ID;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	
	public String getSeller() {
		return seller;
	}
	public void setSeller(String seller) {
		this.seller = seller;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getDestpath() {
		return destpath;
	}
	public void setDestpath(String destpath) {
		this.destpath = destpath;
	}
	public String getSP_ID() {
		return SP_ID;
	}
	public void setSP_ID(String sP_ID) {
		SP_ID = sP_ID;
	}
	public String getSTOCK() {
		return STOCK;
	}
	public void setSTOCK(String sTOCK) {
		STOCK = sTOCK;
	}
	public String getQty() {
		return qty;
	}
	public void setQty(String qty) {
		System.out.println("Quantity setter"+qty);
		this.qty = qty;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getDeliverycharge() {
		return deliverycharge;
	}
	public void setDeliverycharge(String deliverycharge) {
		this.deliverycharge = deliverycharge;
	}
	

}