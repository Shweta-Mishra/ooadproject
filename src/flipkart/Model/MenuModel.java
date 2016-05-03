
package flipkart.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuModel {
	private String pmane;
	private String categoryname;
	private String id;
	private String name;
	private String cid;
	private String cname;
	private String uid;
	private String cbrand;
	public String getCbrand() {
		return cbrand;
	}
	public void setCbrand(String cbrand) {
		this.cbrand = cbrand;
	}
	private Map<String,List<String>>col =new HashMap<String,List<String>>(1);
	
	public Map<String, List<String>> getCol() {
		return col;
	}
	public void setCol(Map<String, List<String>> col) {
		this.col = col;
	}
	//private ArrayList<String,String> cat;
	private ArrayList<String> Uppercategory;
	private ArrayList<String> category;
	private ArrayList<String> Subcategory;
	private ArrayList<String> Brand;
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCategoryname() {
		return categoryname;
	}
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	public String getPmane() {
		return pmane;
	}
	public void setPmane(String pmane) {
		this.pmane = pmane;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<String> getUppercategory() {
		return Uppercategory;
	}
	public void setUppercategory(ArrayList<String> uppercategory) {
		Uppercategory = uppercategory;
	}
	public ArrayList<String> getCategory() {
		return category;
	}
	public void setCategory(ArrayList<String> category) {
		this.category = category;
	}
	public ArrayList<String> getSubcategory() {
		return Subcategory;
	}
	public void setSubcategory(ArrayList<String> subcategory) {
		Subcategory = subcategory;
	}
	public ArrayList<String> getBrand() {
		return Brand;
	}
	public void setBrand(ArrayList<String> brand) {
		Brand = brand;
	}
	
	

}
