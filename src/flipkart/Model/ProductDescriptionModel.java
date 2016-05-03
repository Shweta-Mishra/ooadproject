package flipkart.Model;

import java.io.File;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

public class ProductDescriptionModel 
{
	 private  String destpath;
	 private  String productName,price,seller,brand;
	 private  String description;
	private HttpServletRequest servletRequest;
	private String Feature,F_Value,SP_ID;
	private String Review_Description, Review_Heding , Personal_Rating , User,Avg_Rating,deliverycharge;
	public String getReview_Description() {
		return Review_Description;
	}
	public void setReview_Description(String review_Description) {
		Review_Description = review_Description;
	}
	public String getReview_Heding() {
		return Review_Heding;
	}
	public void setReview_Heding(String review_Heding) {
		Review_Heding = review_Heding;
	}
	public String getPersonal_Rating() {
		return Personal_Rating;
	}
	public void setPersonal_Rating(String personal_Rating) {
		Personal_Rating = personal_Rating;
	}
	public String getUser() {
		return User;
	}
	public void setUser(String user) {
		User = user;
	}
	public String getDestpath() {
		return destpath;
	}
	public void setDestpath(String destpath) {
		this.destpath = destpath;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getSeller() {
		return seller;
	}
	public void setSeller(String seller) {
		this.seller = seller;
	}

	
	public HttpServletRequest getServletRequest() {
		return servletRequest;
	}
	public void setServletRequest(HttpServletRequest servletRequest) {
		this.servletRequest = servletRequest;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getF_Value() {
		return F_Value;
	}
	public void setF_Value(String f_Value) {
		F_Value = f_Value;
	}
	public String getFeature() {
		return Feature;
	}
	public void setFeature(String feature) {
		Feature = feature;
	}
	public String getSP_ID() {
		System.out.println("In the getter of seller id");
		return SP_ID;
	}
	public void setSP_ID(String sP_ID) {
		System.out.println("In the setter of seller id");
		SP_ID = sP_ID;
	}
	public String getAvg_Rating() {
		return Avg_Rating;
	}
	public void setAvg_Rating(String avg_Rating) {
		Avg_Rating = avg_Rating;
	}
	public String getDeliverycharge() {
		return deliverycharge;
	}
	public void setDeliverycharge(String deliverycharge) {
		this.deliverycharge = deliverycharge;
	}

}