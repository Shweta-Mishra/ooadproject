package flipkart.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import flipkart.Db.*;
import flipkart.Model.*;

public class productDescription extends ActionSupport implements ModelDriven<ProductDescriptionModel>
{
	
	private static final long serialVersionUID = 1L;
	ProductDescriptionModel prodModel=new ProductDescriptionModel();
	productDescriptionDB prodDB;
	private String pid;
	ArrayList<ProductDescriptionModel> im=new ArrayList<ProductDescriptionModel>();
	ArrayList<ProductDescriptionModel> productInfo=new ArrayList<ProductDescriptionModel>();
	ArrayList<ProductDescriptionModel> description1=new ArrayList<ProductDescriptionModel>();
	ArrayList<ProductDescriptionModel> Attri_List = new ArrayList<ProductDescriptionModel>();
	ArrayList<ProductDescriptionModel> Reviews = new ArrayList<ProductDescriptionModel>();
	
	


	public ArrayList<ProductDescriptionModel> getReviews() {
		return Reviews;
	}


	public void setReviews(ArrayList<ProductDescriptionModel> reviews) {
		Reviews = reviews;
	}

	


	public ArrayList<ProductDescriptionModel> getAttri_List() {
		return Attri_List;
	}


	public void setAttri_List(ArrayList<ProductDescriptionModel> attri_List) {
		Attri_List = attri_List;
	}


	public ArrayList<ProductDescriptionModel> getDescription1() {
		return description1;
	}


	public void setDescription1(ArrayList<ProductDescriptionModel> description1) {
		this.description1 = description1;
	}


	public ArrayList<ProductDescriptionModel> getIm() {
		return im;
	}
	
	
	public void setIm(ArrayList<ProductDescriptionModel> im) {
		this.im = im;
	}
	
	
	public ArrayList<ProductDescriptionModel> getProductInfo() {
		return productInfo;
	}
	
	
	public void setProductInfo(ArrayList<ProductDescriptionModel> productInfo) {
		this.productInfo = productInfo;
	}
	
	
	public String execute() throws ClassNotFoundException, SQLException 
	{	
		
		productDescriptionDB.Product_Id = pid;
		
			//for product Description
		productDescriptionDB prodDes = new productDescriptionDB();
		description1 = prodDes.productDescription(prodModel,pid);
		//In order to fetch main Image
		int i;
		for(i=0;i<description1.size();i++){
			System.out.println("Dhruv"+description1.get(i));
		}
		productDescriptionDB fetchMainImage = new productDescriptionDB();
		i = fetchMainImage.mainImage(prodModel,pid);
		String p = prodModel.getDestpath();
		
		
		//in order to fetch side image
		productDescriptionDB fetchSmallImage = new productDescriptionDB();
		im = fetchSmallImage.smallImage(prodModel,pid);
		
		//for product Detail
		prodDB=new productDescriptionDB();
		prodModel.setDestpath(p);
		productInfo= prodDB.fetchDB(prodModel,pid);
		productDescriptionDB prodAtrri = new productDescriptionDB();
		Attri_List = prodAtrri.FetchAttribute(prodModel,pid);
		productDescriptionDB fetch_SP_ID = new productDescriptionDB();
		fetch_SP_ID.getSP_ID(prodModel);
		System.out.println(prodModel.getSP_ID()+"Here");
		
		//for fetch review
		
		productDescriptionDB fetch_reveiw = new productDescriptionDB();
		Reviews = fetch_reveiw.get_Review(prodModel);
		return "success";
	}
	
	public String WriteReview() throws ClassNotFoundException, SQLException{
		productDescriptionDB insertReview = new productDescriptionDB();
		
		insertReview.getSP_ID(prodModel);
		insertReview.enterReview(prodModel);
		
		return "success";
		
	}
	
	Map<String, Object> session = ActionContext.getContext().getSession();
	String uid=(String)session.get("email");
	
	public String DeleteCartItem() throws SQLException
	{
		productDescriptionDB deleteCart = new productDescriptionDB();
		 deleteCart.delfromCart(deleteCart,uid);
		return "success";
		
	} 
	
	
	@Override
	public ProductDescriptionModel getModel() {
		//System.out.println("Get hua");
		// TODO Auto-generated method stub
		return prodModel ;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	

}