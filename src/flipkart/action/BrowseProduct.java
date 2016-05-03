package flipkart.action;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

import flipkart.Db.DBhandler;

import com.opensymphony.xwork2.ModelDriven;

import flipkart.Model.*;


public class BrowseProduct implements ModelDriven<ProductInfo>{
	ProductInfo product =new ProductInfo();
	ArrayList<ProductInfo> products=new ArrayList<ProductInfo>();
	//ArrayList<ProductInfo> filter=new ArrayList<ProductInfo>();
	//ArrayList<String> subcategory=new ArrayList<String>();
	ArrayList<String> brandnames=new ArrayList<String>();
//	String[] stringArray;
//	String[] stringArray1;
String categoryname;
String uppercategoryname;
String lastcategoryname;
ArrayList<String> subcategory=new ArrayList<String>();




public String getLastcategoryname() {
	return lastcategoryname;
}

public void setLastcategoryname(String lastcategoryname) {
	this.lastcategoryname = lastcategoryname;
}

public ArrayList<String> getSubcategory() {
	return subcategory;
}

public void setSubcategory(ArrayList<String> subcategory) {
	this.subcategory = subcategory;
}

public ArrayList<ProductInfo> getProducts() {
	return products;
}

public void setProducts(ArrayList<ProductInfo> products) {
	this.products = products;
}
	public String getUppercategoryname() {
	return uppercategoryname;
}
public void setUppercategoryname(String uppercategoryname) {
	this.uppercategoryname = uppercategoryname;
}
	public String getCategoryname() {
	return categoryname;
}
public void setCategoryname(String categoryname) {
	this.categoryname = categoryname;
}
public ArrayList<String> getBrandnames() {
	return brandnames;
}
public void setBrandnames(ArrayList<String> brandnames) {
	this.brandnames = brandnames;
}

/*

	public String[] getStringArray1() {
		return stringArray1;
	}

	public void setStringArray1(String[] stringArray1) {
		this.stringArray1 = stringArray1;
	}
	public String[] getStringArray() {
		return stringArray;
	}

	public void setStringArray(String[] stringArray) {
		this.stringArray = stringArray;
	}

	public ProductInfo getProduct() {
		return product;
	}

	public void setProduct(ProductInfo product) {
		this.product = product;
	}

	public ArrayList<ProductInfo> getFilter() {
		return filter;
	}

	public void setFilter(ArrayList<ProductInfo> filter) {
		this.filter = filter;
	}

	public ArrayList<String> getSubcategory() {
		System.out.println("here");
		return subcategory;
	}
	public void setSubcategory(ArrayList<String> subcategory) {
		this.subcategory = subcategory;
	}



*/
String sorttype;
ArrayList<ProductInfo> productinfo=new ArrayList<ProductInfo>();




public ArrayList<ProductInfo> getProductinfo() {
	return productinfo;
}

public void setProductinfo(ArrayList<ProductInfo> productinfo) {
	this.productinfo = productinfo;
}

public String getSorttype() {
	return sorttype;
}

public void setSorttype(String sorttype) {
	this.sorttype = sorttype;
}

public String sort()
{
	DBhandler db=new DBhandler();
	System.out.println("sort"+sorttype);
	StringTokenizer st=new StringTokenizer(sorttype,",");
	
	String []sort=new String[3];
	int i=0;
	while(st.hasMoreTokens())
	{
		sort[i]=st.nextToken();
		System.out.println("val"+sort[i]);
		i++;
		
	}
	
	//System.out.println(categoryname);
	try
	{
		if(sort[2].equals(" "))
		{
			System.out.println("in category");
products=db.browseProductsort(sort[0],sort[1]);
//System.out.println("product"+productinfo.get(0).getBrand());
//=db.getBrandnames(sort[1]);}
	}
		else
		{
			StringTokenizer st1=new StringTokenizer(sort[2]," ");
		String str=	st1.nextToken();
			System.out.println("in last cat"+str+"string");
			products=db.browseProductsortLast(sort[0],str);		
		}
		}
	catch(Exception ex)
	{
		System.out.println(ex);
		
	}
return "success";
}


public String fetchLast()
{
	DBhandler db=new DBhandler();

	products=db.getProductLast(lastcategoryname);
brandnames=db.getBrandnames(categoryname);
return "success";
}








public String execute()
	{
		DBhandler db=new DBhandler();
	//LinkedList l=new LinkedList();
	System.out.println("cat"+categoryname);
	System.out.println("cat"+uppercategoryname);
	products=	db.browseProduct(categoryname);
	brandnames=db.getBrandnames(categoryname);
	//filter=	db.getlastCategory(categoryname);
	//int count =filter.size();
	//int i=0;
	//System.out.println("count"+count);
	//while (count>0)
	//{
	//ArrayList list=filter.get(0).getLastcategory();
	//ArrayList list1=filter.get(1).getLastcategory();
	//stringArray = (String[]) list.toArray(new String[list.size()]);
 //stringArray1 = (String[]) list1.toArray(new String[list1.size()]);
	
	//count--;
	//i++;
	
	//}
	
	

	//	System.out.println("sub"+subcategory.get(0));
//System.out.println("product"+products.get(0).getBrand());
	//System.out.println("filter last"+filter.get(0).getLastcategory());
	return "success";
	}
public ArrayList<ProductInfo> Gsearch(String categoryname){
	DBhandler db=new DBhandler();
	System.out.println(categoryname);
	products=db.browseProduct(categoryname);
	System.out.println("in disha :"+products.get(0).getImage());
	subcategory=db.getsubCategory(categoryname);
	return products;
	
}

public 	ArrayList<String> Gsubcategory(String categoryname){
	DBhandler db=new DBhandler();
	System.out.println(categoryname);
	//products=db.browseProduct(categoryname);System.out.println("in disha :"+products.get(0).getImage());
	subcategory=db.getsubCategory(categoryname);
	return subcategory;
	
}
	
	@Override
	public ProductInfo getModel() {
		// TODO Auto-generated method stub
		return product;
	}

}