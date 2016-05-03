package flipkart.Model;

import java.sql.Date;

public class TrackOrderModel {
private int Order_Id;
private String Product_Name;
private String Status;
private int total;
private String SP_ID;
private Date Approve_Date;
private String seller_name;
private String seller_id;
private String price;
private String destpath;
private String description;
private int OI;
private String address;
private String D_Name;
private int stock;



public int getOI() {
	return OI;
}
public void setOI(int oI) {
	OI = oI;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getDestpath() {
	return destpath;
}
public void setDestpath(String destpath) {
	this.destpath = destpath;
}
public String getPrice() {
	return price;
}
public void setPrice(String price) {
	this.price = price;
}
public int getOrder_Id() {
	return Order_Id;
}
public void setOrder_Id(int order_Id) {
	Order_Id = order_Id;
}
public String getSeller_name() {
	return seller_name;
}
public void setSeller_name(String seller_name) {
	this.seller_name = seller_name;
}
public String getSeller_id() {
	return seller_id;
}
public void setSeller_id(String seller_id) {
	this.seller_id = seller_id;
}
public String getProduct_Name() {
	return Product_Name;
}
public void setProduct_Name(String product_Name) {
	Product_Name = product_Name;
}
public String getStatus() {
	return Status;
}
public void setStatus(String status) {
	Status = status;
}
public int getTotal() {
	return total;
}
public void setTotal(int total) {
	this.total = total;
}
public String getSP_ID() {
	return SP_ID;
}
public void setSP_ID(String sP_ID) {
	SP_ID = sP_ID;
}
public Date getApprove_Date() {
	return Approve_Date;
}
public void setApprove_Date(Date approve_Date) {
	Approve_Date = approve_Date;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getD_Name() {
	return D_Name;
}
public void setD_Name(String d_Name) {
	D_Name = d_Name;
}
public int getStock() {
	return stock;
}
public void setStock(int stock) {
	this.stock = stock;
}
}
