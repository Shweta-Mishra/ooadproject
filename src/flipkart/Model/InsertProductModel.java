package flipkart.Model;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
public class InsertProductModel {
	private String Item_ID;
	private String Item_name;
	private String Item_Description;
	private String Brand;
	private File photo1;
	private File photo2;
	private File photo3;
	private File photo4;
	private String photo1FileName;
	private String photo1ContentType;
	private String photo2FileName;
	private String photo2ContentType;
	private String photo3FileName;
	private String photo3ContentType;
	private String photo4FileName;
	private String photo4ContentType;
	private HttpServletRequest servletRequest;
	String destpath="/home/shweta/OOAD/Super_FinalFlipkart/WebContent/images";

//getter and setters:-
	public void setServletRequest(HttpServletRequest servletRequest) {
		this.servletRequest = servletRequest;
		this.destpath = getServletRequest().getContextPath();
		System.out.println(this.destpath);

	}
	public String getDestpath() {
		return destpath;
	}
	public void setDestpath(String destpath) {
		this.destpath = getServletRequest().getContextPath();
		System.out.println(this.destpath);
	}
	public HttpServletRequest getServletRequest() {
		return servletRequest;
	}
	public String getPhoto1FileName() {
		return photo1FileName;
	}
	public void setPhoto1FileName(String photo1FileName) {
		this.photo1FileName = photo1FileName;
	}
	public String getPhoto1ContentType() {
		return photo1ContentType;
	}
	public void setPhoto1ContentType(String photo1ContentType) {
		this.photo1ContentType = photo1ContentType;
	}
	public String getPhoto2FileName() {
		return photo2FileName;
	}
	public void setPhoto2FileName(String photo2FileName) {
		this.photo2FileName = photo2FileName;
	}
	public String getPhoto2ContentType() {
		return photo2ContentType;
	}
	public void setPhoto2ContentType(String photo2ContentType) {
		this.photo2ContentType = photo2ContentType;
	}
	public String getPhoto3FileName() {
		return photo3FileName;
	}
	public void setPhoto3FileName(String photo3FileName) {
		this.photo3FileName = photo3FileName;
	}
	public String getPhoto3ContentType() {
		return photo3ContentType;
	}
	public void setPhoto3ContentType(String photo3ContentType) {
		this.photo3ContentType = photo3ContentType;
	}
	public String getPhoto4FileName() {
		return photo4FileName;
	}
	public void setPhoto4FileName(String photo4FileName) {
		this.photo4FileName = photo4FileName;
	}
	public String getPhoto4ContentType() {
		return photo4ContentType;
	}
	public void setPhoto4ContentType(String photo4ContentType) {
		this.photo4ContentType = photo4ContentType;
	}
	
	
	public String getItem_ID() {
		return Item_ID;
	}
	public void setItem_ID(String item_ID) {
		Item_ID = item_ID;
		System.out.println("value of item id from model class"+Item_ID);
	}
	public String getItem_name() {
		return Item_name;
	}
	public void setItem_name(String item_name) {
		Item_name = item_name;
	}
	public String getItem_Description() {
		return Item_Description;
	}
	public void setItem_Description(String item_Description) {
		Item_Description = item_Description;
	}
	public String getBrand() {
		return Brand;
	}
	public void setBrand(String brand) {
		Brand = brand;
	}
	public File getPhoto1() {
		return photo1;
	}
	public void setPhoto1(File photo1) {
		this.photo1 = photo1;
	}
	public File getPhoto2() {
		return photo2;
	}
	public void setPhoto2(File photo2) {
		this.photo2 = photo2;
	}
	public File getPhoto3() {
		return photo3;
	}
	public void setPhoto3(File photo3) {
		this.photo3 = photo3;
	}
	public File getPhoto4() {
		return photo4;
	}
	public void setPhoto4(File photo4) {
		this.photo4 = photo4;
	}
	
}
