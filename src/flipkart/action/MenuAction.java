
package flipkart.action;

import java.util.ArrayList;

import flipkart.Db.DBhandlerMenu;
import flipkart.Model.MenuModel;

import com.opensymphony.xwork2.ModelDriven;


public class MenuAction implements ModelDriven<MenuModel>  {
ArrayList<MenuModel>UpperCategory=new ArrayList<MenuModel>();
ArrayList<MenuModel>Category=new ArrayList<MenuModel>();
public ArrayList<MenuModel> getCategory() {
	return Category;
}
public void setCategory(ArrayList<MenuModel> category) {
	Category = category;
}
	//ArrayList<MenuModel>Category=new ArrayList<MenuModel>();
	MenuModel mm=new MenuModel();
	public String execute(){
		
		DBhandlerMenu db=new DBhandlerMenu();
		UpperCategory=db.fetchUpperCategory();
		/*for(int i=0;i<UpperCategory.size();i++){
			System.out.println("uid"+UpperCategory.get(i).getId());
			Category=db.fetchCategory(UpperCategory.get(i).getId());
		System.out.println("yo geeta"+Category.get(i).getCname());
		}*/
		System.out.println("ghb"+UpperCategory.get(0).getCid());
		System.out.println("ghb"+UpperCategory.get(0).getCategory().get(0));
		return "success";
	}
	public String fetchcategory (){
		System.out.println(mm.getCategoryname());
		
		
		return "success";
	}
	
	@Override
	public MenuModel getModel() {
		// TODO Auto-generated method stub
		return mm;
	}
	public ArrayList<MenuModel> getUpperCategory() {
		return UpperCategory;
	}
	public void setUpperCategory(ArrayList<MenuModel> upperCategory) {
		UpperCategory = upperCategory;
	}
	 
	
		
	
	
}
