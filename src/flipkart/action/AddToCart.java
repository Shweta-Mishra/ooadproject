/*
 * Author : Gazal Gupta (The TL)
*/

package flipkart.action;

import java.util.ArrayList;
import java.util.Map;

import javax.mail.Session;

import flipkart.Model.*;
import flipkart.Db.*;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AddToCart extends ActionSupport implements ModelDriven<AddToCartModel> 
{

	private static final long serialVersionUID = 1L;
	AddToCartModel cart=new AddToCartModel() ;
	ArrayList<AddToCartModel> CartProducts=new  ArrayList<AddToCartModel>();
	ArrayList<AddToCartModel> BillProducts=new  ArrayList<AddToCartModel>();
	public ArrayList<AddToCartModel> getBillProducts() {
		return BillProducts;
	}


	public void setBillProducts(ArrayList<AddToCartModel> billProducts) {
		BillProducts = billProducts;
	}
	Map<String, Object> session = ActionContext.getContext().getSession();

	CartDBhandler dbhandler;
	String uid=(String)session.get("email");
	public String insertToCart()
    {  
		dbhandler = new CartDBhandler();
		int i=dbhandler.addtocart(uid,cart);  
   	 if(i>0)
   	 {  
 		String s=DisplayCart();
   		return(s);
   		 
   	 }  
   	 return "error";  
    } 
	
	
	public String DisplayCart()
    {  

	dbhandler = new CartDBhandler();
	CartProducts=dbhandler.displaycart(uid,cart);
	//if(cart.getCartCount()==0)
	System.out.println(cart.getCartCount()+"cartcnt");
	session.put("cartCount", cart.getCartCount());
	return "success";  
    }
	
	public String DisplayBill() {
   //  System.out.println("heloo i m hrere in cart");
		dbhandler = new CartDBhandler();
		BillProducts = dbhandler.displaycart(uid, cart);
		return "success";
	}	


	public String RemoveFromCart()
    {  
		System.out.println(cart.getSP_ID()+"spid");
	
	dbhandler = new CartDBhandler();
	dbhandler.RemoveFromCart(cart.getSP_ID(),uid);
	String s=DisplayCart();
	//CartProducts=dbhandler.displaycart("U001",cart);
	return "success";  
    }
	
	
	
	public boolean Buttondisable()
    {  
	
	dbhandler = new CartDBhandler();
	boolean DISABLE_BUTTON=dbhandler.DisableButton("U001","P001");  
   		 return DISABLE_BUTTON ;  
    }
	
	
	public String saveQty()
    {  
		cart.getProductQty();
		cart.getSP_ID();
		System.out.println(cart.getProductQty());
		System.out.println(cart.getSP_ID());
	
	dbhandler = new CartDBhandler();
	dbhandler.ChangeQuantity(uid,cart.getSP_ID(),cart.getProductQty());
	CartProducts=dbhandler.displaycart(uid,cart);

   		 return "success";  
    }
	
	public AddToCartModel getCart() {
		return cart;
	}


	public void setCart(AddToCartModel cart) {
		this.cart = cart;
	}


	public ArrayList<AddToCartModel> getCartProducts() {
		return CartProducts;
	}


	public void setCartProducts(ArrayList<AddToCartModel> cartProducts) {
		CartProducts = cartProducts;
	}
	@Override
	public AddToCartModel getModel() 
	{
		// TODO Auto-generated method stub
		return cart;
	}
	

}