package flipkart.action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ModelDriven;

import flipkart.Db.DBhandler;
import flipkart.Model.ShowcategoryModel;

public class Showcategory implements ModelDriven<ShowcategoryModel>{
	//public ArrayList<String>category=new ArrayList<String>();
	ShowcategoryModel SM= new ShowcategoryModel();
	public String execute() {
		
		System.out.println("m in execute of showcat");
		DBhandler db = new DBhandler();
		SM.setFetchcat(db.Fetchcategory(SM));
		return "success";
	}
	@Override
	public ShowcategoryModel getModel() {
		// TODO Auto-generated method stub
		return SM;
	}
	
}
