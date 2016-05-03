package flipkart.Model;

import java.util.ArrayList;

public class ProductInfo {

	String product_name;
	String product_id,Avg_Rating,SP_ID;

	public String getSP_ID() {
		return SP_ID;
	}

	public void setSP_ID(String sP_ID) {
		SP_ID = sP_ID;
	}

	public String getAvg_Rating() {
		return Avg_Rating;
	}

	public void setAvg_Rating(String avg_Rating) {
		Avg_Rating = avg_Rating;
	}
	String product_description;
	int stock;
	int price;
	String brand;
	String image;
	boolean f,t;
	int count;
	String destpath;
	 

	public String getDestpath() {
		return destpath;
	}

	public void setDestpath(String destpath) {
		this.destpath = destpath;
	}

	public int getCount() {
	return count;
}
	
public void setCount(int count) {
	this.count = count;
}
	public boolean isF() {
	return f;
}

public void setF(boolean f) {
	this.f = f;
}

public boolean isT() {
	return t;
}

public void setT(boolean t) {
	this.t = t;
}
	ArrayList<String> subcategory=new ArrayList<String>();
	ArrayList<String> lastcategory=new ArrayList<String>();

	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public ArrayList<String> getSubcategory() {
		return subcategory;
	}
	public void setSubcategory(ArrayList<String> subcategory) {
		this.subcategory = subcategory;
	}

	
	public ArrayList<String> getLastcategory() {
		return lastcategory;
	}
	public void setLastcategory(ArrayList<String> lastcategory) {
		this.lastcategory = lastcategory;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getProduct_description() {
		return product_description;
	}
	public void setProduct_description(String product_description) {
		this.product_description = product_description;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}

}
