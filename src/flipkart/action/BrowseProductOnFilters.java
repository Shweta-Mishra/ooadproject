package flipkart.action;

import java.sql.SQLException;
import java.util.ArrayList;

import flipkart.Db.DBhandler;
import flipkart.Model.ProductInfo;

public class BrowseProductOnFilters {
	private String category;
	private int count, countprice;
	private String brand, price;
	private String[] brandnames;
	private String[] pricelist;
	private String categoryname;
//	ArrayList<String> categoryList, categoryListtemp; 
	ArrayList<ProductInfo> productinfo=new ArrayList<ProductInfo>();
	 public ArrayList<ProductInfo> getProductinfo() {
		return productinfo;
	}

	public void setProductinfo(ArrayList<ProductInfo> productinfo) {
		this.productinfo = productinfo;
	}

	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getCountprice() {
		return countprice;
	}

	public void setCountprice(int countprice) {
		this.countprice = countprice;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String[] getBrandnames() {
		return brandnames;
	}

	public void setBrandnames(String[] brandnames) {
		this.brandnames = brandnames;
	}

	public String[] getPricelist() {
		return pricelist;
	}

	public void setPricelist(String[] pricelist) {
		this.pricelist = pricelist;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
/*
	public ArrayList<String> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(ArrayList<String> categoryList) {
		this.categoryList = categoryList;
	}

	public ArrayList<String> getCategoryListtemp() {
		return categoryListtemp;
	}

	public void setCategoryListtemp(ArrayList<String> categoryListtemp) {
		this.categoryListtemp = categoryListtemp;
	}*/

	public String execute() 
	 {
		 
		DBhandler db= new DBhandler();
//		 categoryList = new ArrayList<String>();
//			categoryListtemp = new ArrayList<String>();
			System.out.println("cat name"+categoryname);
			if(brand != null)
				brandnames = brand.split(",");
			if(price != null)
				pricelist = price.split(",");
			try {
				productinfo = db.getproductlistoncategoryfilter(brandnames,pricelist,categoryname,count,countprice);
		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 return "success";
		 
	 }

	
}
