/*
 * Author : Gazal Gupta (The TL)
 */

package flipkart.Db;

import java.util.*;
import java.sql.*;

import flipkart.Model.*;


public class CartDBhandler {
	
	
	ArrayList<AddToCartModel> addtocart = new ArrayList<AddToCartModel>();
	

	public int GetproductDetailsFromSupply(String uid) {
		try {
			DBconnection db = new DBconnection();
			// System.out.println("connection");
			Connection con = db.createConnection();
			String sql = "SELECT * FROM PRODUCT_INFO where P_ID in(SELECT P_ID FROM SELLER_PRODUCT where SP_ID in (SELECT SP_ID FROM CART where U_ID =? or U_ID=?))";
			PreparedStatement ps2 = (PreparedStatement) con.prepareStatement(sql);

			ps2.setString(1, "none");
			ps2.setString(2, uid);// uid

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public boolean DisableButton(String uid, String P_ID) {
		boolean flag = false;

		try {
			DBconnection db = new DBconnection();
			Connection con = db.createConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT P_ID FROM SELLER_PRODUCT where SP_ID in (SELECT SP_ID FROM CART where U_ID =? or U_ID=?)");
			ps.setString(1, "none");
			ps.setString(2, uid);// uid

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				if (rs.getString(1) == P_ID)
					flag = true;

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;

	}

	public int addtocart(String uid,AddToCartModel cart) {

		try {
			DBconnection db = new DBconnection();
			Connection con = db.createConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("INSERT INTO CART(`SP_ID`,`U_ID`,`FLAG`,`QUANTITY`) VALUES (?,?,?,?)");
			ps.setString(1, cart.getSP_ID());
			if(uid==null)
			ps.setString(2, "none");
			else
				ps.setString(2,uid);
			ps.setInt(3, 1);
			ps.setInt(4, 1);
			ps.executeUpdate();

		}

		catch (Exception e) {
			e.printStackTrace();
			return 0;
		}

		return 1;
	}

	
	
			public ArrayList<AddToCartModel> displaycart(String UID, AddToCartModel am) // uid from session
			{
				try
				{
							int j=0;
							DBconnection db = new DBconnection();
							Connection con = db.createConnection();
							
						PreparedStatement ps1 = (PreparedStatement) con.prepareStatement("SELECT * FROM PRODUCT_INFO where P_ID in (SELECT P_ID from SELLER_PRODUCT where SP_ID in (Select SP_ID from CART where U_ID=? OR U_ID=?))");
						ps1.setString(1, UID);
						ps1.setString(2, "none");
						PreparedStatement ps2 = (PreparedStatement) con.prepareStatement("SELECT * FROM SELLER_PRODUCT where SP_ID in (Select SP_ID from CART where U_ID=? OR U_ID=?)");
						ps2.setString(1, UID);
						ps2.setString(2, "none");
						PreparedStatement ps3 = (PreparedStatement) con.prepareStatement("SELECT P_IMAGE from PRODUCT_INFO where P_ID in (SELECT P_ID FROM SELLER_PRODUCT where SP_ID in (SELECT SP_ID FROM CART where U_ID =? or U_ID=?))");
						ps3.setString(1, UID);
						ps3.setString(2, "none");
						PreparedStatement ps = (PreparedStatement) con.prepareStatement("Select QUANTITY from CART where U_ID=? OR U_ID=?");
						ps.setString(1, UID);
						ps.setString(2, "none");
					/*	PreparedStatement ps4 = (PreparedStatement) con.prepareStatement("Select SELLER_NAME from SELLER,SELLER_PRODUCT,CART where U_ID=? or U_ID=? and SELLER_PRODUCT.SP_ID = CART.SP_ID and SELLER.SELLER_ID= SELLER_PRODUCT.SELLER_ID");
						ps4.setString(1, UID);
						ps4.setString(2, "none");
						*/
						
						

						ResultSet rs1 = ps1.executeQuery();
						ResultSet rs2 = ps2.executeQuery();
						ResultSet rs3= ps3.executeQuery();
						ResultSet rs = ps.executeQuery();
						//ResultSet rs4= ps4.executeQuery();

						
						int cartCount=0;
						int payableprice=0;
						int c=0;
						int payprice=0;


						while (rs1.next()&&rs2.next()&&rs3.next()&&rs.next()) 
						{
							c=++cartCount;
							AddToCartModel nm = new AddToCartModel();

			
							nm.setP_ID(rs1.getString(1));
							//nm.setSELLER_NAME(rs4.getString(1));
							nm.setSTOCK(rs2.getInt(5));
							nm.setSP_ID(rs2.getString(3));
							nm.setP_NAME(rs1.getString(2));
							nm.setP_DESCRIPTION(rs1.getString(3));
							nm.setP_BRAND(rs1.getString(4));
							nm.setPRICE(rs2.getInt(4));
							nm.setDELIVERY_CHARGES(rs2.getInt(6));
							nm.setProductImage("images/"+rs3.getString(1));
							nm.setProductQty(rs.getInt(1));
							 payprice=(rs2.getInt(4)*rs.getInt(1))+rs2.getInt(6);
							nm.setTOTAL_PRICE(rs2.getInt(4)*rs.getInt(1)+rs2.getInt(6));
							payableprice=payableprice+(payprice);
							//nm.setSELLER_NAME(rs4.getString(1));
			
							addtocart.add(j, nm);

							j++;
						}
						am.setCartCount(c);
						am.setAMOUNT_PAYABLE(payableprice);

				}
				
							catch(Exception e)
							{
								e.printStackTrace();
							}
						return addtocart;
			}


	public void ChangeQuantity(String uid, String SP_ID ,int qty) {
		try 
		{

			DBconnection db = new DBconnection();
			Connection con = db.createConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("UPDATE CART SET QUANTITY=? WHERE SP_ID=? and U_ID=? or U_ID='none'");
			ps.setInt(1, qty);
			ps.setString(2, SP_ID);
			ps.setString(3, uid);
			ps.executeUpdate();

		}

		catch (Exception e) {
			e.printStackTrace();
		}

		
	}
	
	public void RemoveFromCart(String SP_ID , String uid)
	{
		try
		{
		DBconnection db = new DBconnection();
		Connection con = db.createConnection();
		PreparedStatement ps = (PreparedStatement) con.prepareStatement("Delete from CART where SP_ID=? and (U_ID=? OR U_ID='none')");
		ps.setString(1, SP_ID);
		ps.setString(2, uid);
		
		ps.executeUpdate();

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		
	}


	public void RemoveAllFromCart(String uid)
	{
		try
		{
		DBconnection db = new DBconnection();
		Connection con = db.createConnection();
		PreparedStatement ps = (PreparedStatement) con.prepareStatement("Delete from CART where U_ID=? OR U_ID='none'");
		//ps.setString(1, SP_ID);
		ps.setString(1, uid);
		
		ps.executeUpdate();

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}


		public void ChangeUserAfterLogin(String uid)
		{
			try
			{
			DBconnection db = new DBconnection();
			Connection con = db.createConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("UPDATE CART SET U_ID=? where U_ID='none'");
			ps.setString(1, uid);
			
			ps.executeUpdate();

			}
			catch(Exception e)
			{
				e.printStackTrace();
			}

		
	}

}