/*
 * Author : Gazal Gupta (The TL)
 */



package flipkart.Model;
import flipkart.Db.*;
public class AddToCartModel 
{
	private String SP_ID;
	private String SELLER_NAME;
	private int STOCK;
	private String P_ID;
	private String P_NAME;
	private String P_DESCRIPTION;
	private String P_BRAND;
	private int productQty;
	private int DELIVERY_CHARGES;
	private int TOTAL_PRICE;
	private int PRICE;
	private int AMOUNT_PAYABLE;
	private int DISABLE_BUTTON;
	private int cartCount;
	private String productImage;

	

	public int getDELIVERY_CHARGES() {
		return DELIVERY_CHARGES;
	}

	public void setDELIVERY_CHARGES(int dELIVERY_CHARGES) {
		DELIVERY_CHARGES = dELIVERY_CHARGES;
	}

	public int getTOTAL_PRICE() {
		//TOTAL_PRICE=getPRICE()*getProductQty()+getDELIVERY_CHARGES();
		return TOTAL_PRICE;
	}

	public void setTOTAL_PRICE(int tOTAL_PRICE) {
		productDescriptionDB.Total_Payment = Integer.toString(tOTAL_PRICE);
		TOTAL_PRICE = tOTAL_PRICE;
	}

	public int getPRICE() {
		return PRICE;
	}

	public void setPRICE(int pRICE) {
		PRICE = pRICE;
	}

	public String getP_NAME() {
		return P_NAME;
	}

	public void setP_NAME(String p_NAME) {
		P_NAME = p_NAME;
	}

	public String getP_DESCRIPTION() {
		return P_DESCRIPTION;
	}

	public void setP_DESCRIPTION(String p_DESCRIPTION) {
		P_DESCRIPTION = p_DESCRIPTION;
	}

	public String getP_BRAND() {
		return P_BRAND;
	}

	public void setP_BRAND(String p_BRAND) {
		P_BRAND = p_BRAND;
	}

	public String getP_ID() {
		return P_ID;
	}

	public void setP_ID(String p_ID) {
		P_ID = p_ID;
	}

	public int getAMOUNT_PAYABLE() {
		return AMOUNT_PAYABLE;
	}

	public void setAMOUNT_PAYABLE(int aMOUNT_PAYABLE) {
		AMOUNT_PAYABLE = aMOUNT_PAYABLE;
	}

	public String getSP_ID() {
		return SP_ID;
	}

	public void setSP_ID(String sP_ID) {
		//System.out.println("modelspid");
		SP_ID = sP_ID;
	}

	public int getDISABLE_BUTTON() {
		return DISABLE_BUTTON;
	}

	public void setDISABLE_BUTTON(int dISABLE_BUTTON) {
		DISABLE_BUTTON = dISABLE_BUTTON;
	}



	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		//System.out.println(productImage);
		this.productImage = productImage;
	}

	public int getCartCount() {
		return cartCount;
	}

	public void setCartCount(int cartCount) {
		this.cartCount = cartCount;
	}

	public int getProductQty() {
		return productQty;
	}

	public void setProductQty(int productQty) {
		this.productQty = productQty;
	}

	public String getSELLER_NAME() {
		return SELLER_NAME;
	}

	public void setSELLER_NAME(String sELLER_NAME) {
		SELLER_NAME = sELLER_NAME;
	}

	public int getSTOCK() {
		return STOCK;
	}

	public void setSTOCK(int sTOCK) {
		STOCK = sTOCK;
	}

}
