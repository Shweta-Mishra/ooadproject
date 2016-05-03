package flipkart.action;

import java.sql.SQLException;
import java.util.ArrayList;
//import productDescription;





//import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;

import flipkart.Db.*;
import flipkart.Model.*;
public class Search2Action implements ModelDriven<ProductInfo>{
	//ArrayList<ProductInfo> products =new ArrayList<ProductInfo>();
	ArrayList<ProductInfo> itemDetail = new ArrayList<ProductInfo>();
	String p;
	

	public String getP() {
		return p;
	}

	public void setP(String p) {
		this.p = p;
	}
	ProductDescriptionModel prodModel=new ProductDescriptionModel();
	productDescriptionDB prodDB;
	private String pid;
	ArrayList<ProductDescriptionModel> im=new ArrayList<ProductDescriptionModel>();
	ArrayList<ProductDescriptionModel> productInfo=new ArrayList<ProductDescriptionModel>();
	ArrayList<ProductDescriptionModel> description1=new ArrayList<ProductDescriptionModel>();
	ArrayList<ProductDescriptionModel> Attri_List = new ArrayList<ProductDescriptionModel>();
	ArrayList<ProductDescriptionModel> Reviews = new ArrayList<ProductDescriptionModel>();
	public ArrayList<ProductDescriptionModel> getIm() {
		return im;
	}

	public void setIm(ArrayList<ProductDescriptionModel> im) {
		this.im = im;
	}

	public ArrayList<ProductDescriptionModel> getDescription1() {
		return description1;
	}

	public void setDescription1(ArrayList<ProductDescriptionModel> description1) {
		this.description1 = description1;
	}

	public ArrayList<ProductDescriptionModel> getAttri_List() {
		return Attri_List;
	}

	public void setAttri_List(ArrayList<ProductDescriptionModel> attri_List) {
		Attri_List = attri_List;
	}
	//private String term;
	//private boolean cflag, pflag;
	//private int count;
	ArrayList<ProductInfo> products=new ArrayList<ProductInfo>();
	ArrayList<ProductInfo> itemlist=new ArrayList<ProductInfo>();
	ArrayList<String> brandnames=new ArrayList<String>();
	String uppercategoryname;

	public String getUppercategoryname() {
		return uppercategoryname;
	}

	public void setUppercategoryname(String uppercategoryname) {
		this.uppercategoryname = uppercategoryname;
	}

	public ArrayList<String> getBrandnames() {
		return brandnames;
	}

	public void setBrandnames(ArrayList<String> brandnames) {
		this.brandnames = brandnames;
	}

	public ArrayList<ProductInfo> getItemlist() {
		return itemlist;
	}

	public void setItemlist(ArrayList<ProductInfo> itemlist) {
		this.itemlist = itemlist;
	}

	public ArrayList<ProductInfo> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<ProductInfo> products) {
		this.products = products;
	}

	ProductInfo sm=new ProductInfo();
	String categoryname;
	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	String Pid;
	public String getPid() {
		return Pid;
	}

	public void setPid(String pid) {
		Pid = pid;
	}

	public String execute() throws ClassNotFoundException, SQLException {
		System.out.println("hi in search action"+p);
		//System.out.println(term);
		DBhandler db = new DBhandler();
		//itemDetail = db.getserachresult(term);
		//System.out.println(itemDetail);
		//cflag = db.checkCategory(term);
		//pflag = db.checkProduct(term);
		//System.out.println("count:"+sm.getCount());
		System.out.println("in search action: "+sm.getProduct_name());
		if (db.checkCategory(sm.getProduct_name())) {
			System.out.println("in if");
			BrowseProduct bp=new BrowseProduct ();
			products=db.browseProduct(sm.getProduct_name());
			categoryname=sm.getProduct_name();
			System.out.println("in disha :"+products.get(0).getImage());System.out.println(categoryname);
			brandnames=db.getBrandnames(sm.getProduct_name());//(sm.getProduct_name());
		//subcategory=bp.Gsubcategory(sm.getProduct_name());
			System.out.println(brandnames);
			System.out.println("priduct:"+sm.getProduct_name()+ "image"+products.get(0).getImage());
			return "disha";
		}
		
		else {
			productDescription des = new productDescription();
			System.out.println("in else of search");
			itemlist=db.checkProduct(sm.getProduct_name());
			System.out.println("prudocuth:"+itemlist);
		    System.out.println("count in search mo"+itemlist.get(0).getCount());
		    int last=itemlist.size();System.out.println(last);
			if (itemlist.get(last-1).getCount()==1){
				
				System.out.println("vijya"+sm.getCount());
				products=db.getProduct(sm.getProduct_name());
				 Pid=db.getPid(sm.getProduct_name());
				System.out.println("pid n search"+Pid);
				productDescriptionDB.Product_Id = Pid;	//for product Description
				productDescriptionDB prodDes = new productDescriptionDB();
				description1 = prodDes.productDescription(prodModel,pid);
				//In order to fetch main Image
				int i;
				for(i=0;i<description1.size();i++){
					System.out.println("Dhruv"+description1.get(i));
				}
				productDescriptionDB fetchMainImage = new productDescriptionDB();
				i = fetchMainImage.mainImage1(sm,pid);
				String p = prodModel.getDestpath();
				System.out.println("Geeta Dest path is" + prodModel.getDestpath());
				
				
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
				fetch_SP_ID.get_count(sm,pid);
				System.out.println(prodModel.getSP_ID()+"Here");
				
				//for fetch review
				
				productDescriptionDB fetch_reveiw = new productDescriptionDB();
				Reviews = fetch_reveiw.get_Review(prodModel);
				//String Description = des.execute();
				
				
				//fatch rating
				productDescriptionDB prodDB1=new productDescriptionDB();
				prodDB1.fetchRating(sm);
				
				return "vijiya";
			}
			
			else if (itemlist.get(last-1).getCount()>1) {
				System.out.println(" me"+itemlist.get(last-1).getCount());
				products=db.getProduct(sm.getProduct_name());
				categoryname=db.getCategoryname(sm.getProduct_name());
			setCategoryname(categoryname);
			System.out.println(getCategoryname());
					brandnames=db.getBrandnames(categoryname);
				
				System.out.println("search return");
				//subcategory=db.getsubCategoryInfo(sm.getProduct_name());
				return "success";
			}
			
			else
				return "noproduct";
		}
		
		

	}

	
	public ArrayList<ProductDescriptionModel> getReviews() {
		return Reviews;
	}

	public void setReviews(ArrayList<ProductDescriptionModel> reviews) {
		Reviews = reviews;
	}

	public ArrayList<ProductDescriptionModel> getProductInfo() {
		return productInfo;
	}

	public void setProductInfo(ArrayList<ProductDescriptionModel> productInfo) {
		this.productInfo = productInfo;
	}

	@Override
	public ProductInfo getModel() {
		// TODO Auto-generated method stub
		return sm;
	}

}