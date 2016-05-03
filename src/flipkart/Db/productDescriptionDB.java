package flipkart.Db;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Map;
import java.util.StringTokenizer;

import flipkart.Model.*;
import flipkart.Db.DBconnection;
import flipkart.Model.PayMentModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.opensymphony.xwork2.ActionContext;

import java.lang.*;

public class productDescriptionDB {

	private static final String U001 = null;

	public static String User_Id, Product_Id, Total_Payment, Quentity, Detail,
			Seller_Product, quantity, Stock, itemName,deliverycharge,Seller_id;

	int success = 0;

	public int mainImage(ProductDescriptionModel prodModel, String pid)
			throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		int i = 1;

		DBconnection db = new DBconnection();
		java.sql.Connection con = db.createConnection();

		String sql = "select P_IMAGE from PRODUCT_INFO WHERE P_ID='"
				+ Product_Id + "'";

		
		PreparedStatement ps1 = (PreparedStatement) con.prepareStatement(sql);
		java.sql.ResultSet rs = ps1.executeQuery();
		while (rs.next()) {
			prodModel.setDestpath("images/"+rs.getString("P_IMAGE"));
			
		}
		return i;
	}
	
	public int mainImage1(ProductInfo sm, String pid)
			throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		int i = 1;

		DBconnection db = new DBconnection();
		java.sql.Connection con = db.createConnection();

		String sql = "select P_IMAGE from PRODUCT_INFO WHERE P_ID='"
				+ Product_Id + "'";

		
		PreparedStatement ps1 = (PreparedStatement) con.prepareStatement(sql);
		java.sql.ResultSet rs = ps1.executeQuery();
		while (rs.next()) {
			sm.setDestpath("images/"+rs.getString("P_IMAGE"));
			
		}
		return i;
	}

	public ArrayList<ProductDescriptionModel> smallImage(
			ProductDescriptionModel prodModel, String pid)
			throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		int i = 1;
		ArrayList<ProductDescriptionModel> im = new ArrayList<ProductDescriptionModel>();
		DBconnection db = new DBconnection();
		java.sql.Connection con = db.createConnection();
		System.out.println("are load mat le");
		String sql = "select IMAGE from IMAGE WHERE P_ID='" + Product_Id + "'";
		PreparedStatement ps1 = (PreparedStatement) con.prepareStatement(sql);
		java.sql.ResultSet rs = ps1.executeQuery();
		while (rs.next()) {
			ProductDescriptionModel fetchImage = new ProductDescriptionModel();
			String str;
			fetchImage.setDestpath("images/" + rs.getString("IMAGE"));
			str = "images/" + rs.getString(1);
			System.out.println(str);
			System.out.println("hello I am Here");
			im.add(fetchImage);
		}
		return im;
	}

	// private String pidcription(productDescriptionDB.java:136);
	public ArrayList<ProductDescriptionModel> fetchDB(
			ProductDescriptionModel PM, String pid)
			throws ClassNotFoundException, SQLException {
		DBconnection dbc = new DBconnection();
		java.sql.Connection c = dbc.createConnection();

		ArrayList<ProductDescriptionModel> productInfo = new ArrayList<ProductDescriptionModel>();
		System.out.println("pid" + pid);

		ProductDescriptionModel productModel;

		c = (Connection) dbc.createConnection();

		String sql = "SELECT P_NAME,P_DESCRIPTION,P_BRAND,DELIVERY_CHARGE,SELLER_NAME,PRICE FROM PRODUCT_INFO AS PIN ,SELLER AS S ,SELLER_PRODUCT AS SP WHERE PIN.P_ID=SP.P_ID AND SP.SELLER_ID=S.SELLER_ID AND PIN.P_ID='"
				+ Product_Id + "'";

		PreparedStatement ps = (PreparedStatement) c.prepareStatement(sql);
		java.sql.ResultSet rs = ps.executeQuery();
		if (rs != null) {
			while (rs.next()) {
				productModel = new ProductDescriptionModel();

				productModel.setSeller(rs.getString("SELLER_NAME"));
				productModel.setPrice(rs.getString("PRICE"));
				productModel.setProductName(rs.getString("P_NAME"));
				productModel.setBrand(rs.getString("P_BRAND"));
				productModel.setDeliverycharge(rs.getString("DELIVERY_CHARGE"));

				productInfo.add(productModel);

				System.out.println("Name" + rs.getString("P_NAME"));
				System.out.println("price" + rs.getString("PRICE"));
				System.out.println("SName" + rs.getString("SELLER_NAME"));
				System.out.println("SName" + rs.getString("P_BRAND"));

			}
			java.sql.PreparedStatement ps1 = null;
			ps1 = c.prepareStatement("select RATING from REVIEW where SP_ID = (select SP_ID from SELLER_PRODUCT where P_ID = '"
					+ Product_Id + "')");
			ResultSet rs1 = ps1.executeQuery();
			int i = 0, sum = 0;
			while (rs1.next()) {
				System.out.println(rs1.getInt(1));
				sum = sum + rs1.getInt(1);
				i++;
			}
			if (i != 0) {
				System.out.println("Average rating is"
						+ Integer.toString(sum / i));
				PM.setAvg_Rating(Integer.toString(sum / i));
			} else {
				PM.setAvg_Rating("Not Rate Yet");
			}
			success = 1;

		}

		/*
		 * String sql1 =
		 * "select SELLER_NAME from SELLER where SELLER_ID=(select SELLER_ID from SELLER_PRODUCT where P_ID ='"
		 * + pid + "')"; System.out.println(sql1); PreparedStatement ps1 =
		 * (PreparedStatement) c.prepareStatement(sql1); ResultSet rs1 =
		 * (ResultSet) ps1.executeQuery(); if (rs1 != null) { while (rs1.next())
		 * { productModel.setSeller(rs1.getString("SELLER_NAME"));
		 * System.out.println("SName" + rs1.getString("SELLER_NAME"));
		 * 
		 * } } String sql2 = "select PRICE from SELLER_PRODUCT where P_ID ='" +
		 * pid + "'"; System.out.println(sql2); PreparedStatement ps2 =
		 * (PreparedStatement) c.prepareStatement(sql2); ResultSet rs2 =
		 * (ResultSet) ps2.executeQuery(); if (rs2 != null) { while (rs2.next())
		 * {
		 * 
		 * productModel.setPrice(rs2.getString("PRICE"));
		 * System.out.println("price" + rs2.getString("PRICE")); } }
		 */
		c.close();
		return productInfo;
	}
	
	public void fetchRating(ProductInfo sm) throws SQLException {
		// TODO Auto-generated method stub
		DBconnection dbc = new DBconnection();
		java.sql.Connection c = dbc.createConnection();

		java.sql.PreparedStatement ps1 = null;
		ps1 = c.prepareStatement("select RATING from REVIEW where SP_ID = (select SP_ID from SELLER_PRODUCT where P_ID = '"
				+ Product_Id + "')");
		ResultSet rs1 = ps1.executeQuery();
		int i = 0, sum = 0;
		while (rs1.next()) {
			System.out.println(rs1.getInt(1));
			sum = sum + rs1.getInt(1);
			i++;
		}
		if (i != 0) {
			System.out.println("Average rating is"
					+ Integer.toString(sum / i));
			sm.setAvg_Rating(Integer.toString(sum / i));
		} else {
			sm.setAvg_Rating("Not Rate Yet");
		}

		
	}


	public void getSP_ID(ProductDescriptionModel prodModel)
			throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		DBconnection dbc = new DBconnection();
		java.sql.Connection c = dbc.createConnection();

		System.out.println("In the sp_Id");
		c = (Connection) dbc.createConnection();
		String sql1 = "SELECT SP_ID from SELLER_PRODUCT where P_ID='"
				+ Product_Id + "'";
		java.sql.PreparedStatement ps1 = c.prepareCall(sql1);
		java.sql.ResultSet rs1 = ps1.executeQuery();
		while (rs1.next()) {
			prodModel.setSP_ID(rs1.getString(1));
			Seller_Product = rs1.getString(1);
			System.out.println("Seller Product Id is" + rs1.getString(1));

		}

	}

	public void store(deliveryProductModel dM) throws ClassNotFoundException {

		DBconnection dbc = new DBconnection();
		java.sql.Connection c = dbc.createConnection();
		c = (Connection) dbc.createConnection();

		try {
			c = (Connection) dbc.createConnection();

			String sql = "insert into DELIVERY_DETAILS(U_ID,D_NAME,ADDRESS,CITY,PINCODE,PHONE_NO) values(?,?,?,?,?,?); ";
			java.sql.PreparedStatement ps = c.prepareStatement(sql);
			System.out.println(dM.getUserName());
			System.out.println(dM.getAddress());
			System.out.println(dM.getCity());
			System.out.println(dM.getPhone());
			System.out.println(dM.getUserName());
			System.out.println(dM.getU_ID());
			ps.setString(1, User_Id);
			ps.setString(2, dM.getUserName());
			ps.setString(3, dM.getAddress());
			ps.setString(4, dM.getCity());
			ps.setString(5, dM.getPincode());
			ps.setString(6, dM.getPhone());
			ps.executeUpdate();

		} catch (Exception e) {
			// e.printStackTrace();

		}
	}

	public ArrayList<ProductDescriptionModel> productDescription(
			ProductDescriptionModel prodModel, String pid)
			throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		int j = 0;

		DBconnection dbc = new DBconnection();
		java.sql.Connection c = dbc.createConnection();
		c = (Connection) dbc.createConnection();

		String sql1 = "SELECT P_DESCRIPTION FROM PRODUCT_INFO AS PIN WHERE PIN.P_ID='"
				+ Product_Id + "'";
		PreparedStatement ps1 = (PreparedStatement) c.prepareStatement(sql1);
		java.sql.ResultSet rs1 = ps1.executeQuery();
		ArrayList<ProductDescriptionModel> productdes = new ArrayList<ProductDescriptionModel>();
		while (rs1.next()) {
			String des = rs1.getString(1);
			StringTokenizer st = new StringTokenizer(des);
			String[] tok = new String[10];
			while (st.hasMoreTokens()) {
				ProductDescriptionModel prodes = new ProductDescriptionModel();
				tok[j] = st.nextToken(",");
				prodes.setDescription(tok[j]);
				System.out.println("token:" + tok[j]);
				productdes.add(prodes);
				j++;
			}
		}
		return productdes;
	}

	public ArrayList<deliveryProductModel> retriveDetail(
			deliveryProductModel deliveryModel1, String pid) {
		// pid="P001";
		Date date1 = new Date(System.currentTimeMillis());
		Date date = addDays(date1, 4);
		DateFormat currentDate = DateFormat.getDateInstance();
		currentDate.format(date);

		ArrayList<deliveryProductModel> orderdetail = new ArrayList<deliveryProductModel>();
		try {
			DBconnection dbc = new DBconnection();
			java.sql.Connection c = dbc.createConnection();

			c = (Connection) dbc.createConnection();
			System.out.println("vijaya P_ID = " + Product_Id);
			/*
			 * String sql=
			 * "SELECT P_NAME,IMAGE,P_BRAND,SELLER_NAME,PRICE FROM IMAGE AS I,PRODUCT_INFO AS PIN ,SELLER AS S ,SELLER_PRODUCT AS SP WHERE I.P_ID=PIN.P_ID AND PIN.P_ID=SP.P_ID AND SP.SELLER_ID=S.SELLER_ID AND PIN.P_ID='"
			 * +Product_Id+"'";
			 */
			String sql = "SELECT P_NAME,P_IMAGE,P_BRAND,DELIVERY_CHARGE,SELLER_NAME,PRICE FROM PRODUCT_INFO AS PIN ,SELLER AS S ,SELLER_PRODUCT AS SP WHERE  PIN.P_ID=SP.P_ID AND SP.SELLER_ID=S.SELLER_ID AND PIN.P_ID='"
					+ Product_Id + "'";
			java.sql.PreparedStatement ps = c.prepareStatement(sql);

			ResultSet rs = (ResultSet) ps.executeQuery();
			String str1 = null;
			String str2 = null;
			String str3 = null;
			if (rs != null) {
				while (rs.next()) {

					deliveryModel1.setPrice(rs.getString("PRICE"));
					str1 = rs.getString("P_BRAND");
					str2 = rs.getString("SELLER_NAME");
					str3 = rs.getString("P_NAME");
					deliveryModel1.setItemName(str3);
					deliveryModel1.setDestpath("images/"+rs.getString("P_IMAGE"));
					deliveryModel1.setSubtotal(rs.getString("PRICE"));
					deliveryModel1.setTotal(rs.getString("PRICE"));
					deliveryModel1.setSP_ID(Seller_Product);
					deliveryModel1.setDeliverycharge(rs.getString("DELIVERY_CHARGE"));
				}
				deliveryModel1.setDetail(currentDate.format(date));
				String i = str3 + "," + str1 + "," + str2;
				deliveryModel1.setItem(i);
				deliveryModel1.setTotal(Total_Payment);
				deliveryModel1.setQty(quantity);
				orderdetail.add(deliveryModel1);

			}
			java.sql.PreparedStatement ps1 = c
					.prepareStatement("select STOCK from SELLER_PRODUCT where P_ID='"
							+ Product_Id + "'");
			ResultSet rs1 = (ResultSet) ps1.executeQuery();
			while (rs1.next()) {
				System.out.println(Product_Id);
				System.out.println(rs1.getString(1));
				deliveryModel1.setSTOCK(rs1.getString(1));
				Stock = rs1.getString(1);

				System.out.println("In rs stock is" + Stock);
			}
			
			
			
			//System.out.println("Stock is" + deliveryModel1.getSTOCK());
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
		}

		return orderdetail;

		// TODO Auto-generated method stub

	}

	public static Date addDays(Date d, int days) {
		d.setTime(d.getTime() + days * 1000 * 60 * 60 * 24);
		return d;
	}

	public ArrayList<ProductDescriptionModel> FetchAttribute(
			ProductDescriptionModel prodModel, String pid)
			throws ClassNotFoundException, SQLException {
		DBconnection db = new DBconnection();
		java.sql.Connection con = db.createConnection();

		String sql = "SELECT SC_NAME , LC_NAME from LAST_CATEGORY,SUB_CATEGORY,CATEGORY_MAPPING where LAST_CATEGORY.LC_ID = CATEGORY_MAPPING.LC_ID and SUB_CATEGORY.SC_ID = CATEGORY_MAPPING.SC_ID and CATEGORY_MAPPING.P_ID = '"
				+ Product_Id + "'";

		PreparedStatement ps1 = (PreparedStatement) con.prepareStatement(sql);
		java.sql.ResultSet rs = ps1.executeQuery();
		ArrayList<ProductDescriptionModel> attr = new ArrayList<ProductDescriptionModel>();
		while (rs.next()) {
			ProductDescriptionModel prodModel1 = new ProductDescriptionModel();
			prodModel1.setFeature(rs.getString(1));
			prodModel1.setF_Value(rs.getString(2));
			System.out.println(rs.getString(1));
			System.out.println(rs.getString(2));
			System.out.println(prodModel1.getFeature());
			System.out.println(prodModel1.getF_Value());
			attr.add(prodModel1);
		}

		return attr;

	}
	public int conform_Credit_Pay(PayMentModel payMentModel, String CardNumber) {
		// TODO Auto-generated method stub
		java.sql.Connection con = null;
		java.sql.PreparedStatement pstmt = null;
		java.sql.PreparedStatement ps2 = null;
		java.sql.PreparedStatement ps3 = null;
		java.sql.PreparedStatement ps4 = null;
		java.sql.PreparedStatement ps1 = null;
		ResultSet rs = null;
		DBconnection dbc = new DBconnection();
		System.out.println("payment is" + Total_Payment);
		String balance;
		String Ret_Balance = null;
		String Temp_Stock = null;
		try {
			con = dbc.createConnection();
			System.out.println("cvv string is " + payMentModel.getCvv1());
			int cvv = Integer.parseInt(payMentModel.getCvv1());
			int new_Balance = 0;
			System.out.println(CardNumber);
			pstmt = con
					.prepareStatement("select BAlANCE,CVV,MONTH,YEAR from User_Bank where CARD_NUMBER = '"
							+ CardNumber + "'");

			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString(1));
				new_Balance = Integer.parseInt(rs.getString(1));
				System.out.println(Total_Payment);
				int num1 = Integer.parseInt(Total_Payment);
				System.out.println("Toatal amount is" + num1);
				Ret_Balance = rs.getString(1);
				int num2 = Integer.parseInt(rs.getString(1));
				System.out.println("Balance is" + num2);

				if (num1 <= num2) {
					int cvvcheck = Integer.parseInt(rs.getString(2));
					System.out.println("cvvcheck is" + cvvcheck);
					// System.out.println("CVV is"+cvv);

					if (cvvcheck != cvv) {
						System.out.println("I am in rs.next cvv");
						return 0;
					}

					else {

						new_Balance = new_Balance
								- Integer.parseInt(Total_Payment);
						balance = Integer.toString(new_Balance);
					}
				}

				else {
					System.out.println("this is else part");
					return 2;
				}

				ps1 = con.prepareStatement("update User_Bank set BALANCE = '"
						+ balance + "' where CARD_NUMBER = '" + CardNumber
						+ "'");
				System.out.println("Balance is updated here");
				ps1.executeUpdate();
/*
				ps2 = con
						.prepareStatement("insert into PAYMENT(PAYMENT_METHOD,AMOUNT,U_ID,SP_ID) values(?,?,?,?)  ");
				ps2.setString(1, "Credit");
				ps2.setString(2, Total_Payment);
				ps2.setString(3, User_Id);
				ps2.setString(4, Seller_Product);
				System.out.println("insert summary here");
				ps2.executeUpdate();
				*/
				
/*				java.sql.PreparedStatement ps13 = null;
				ps13 = con
						.prepareStatement("select ORDER_ID from PAYMENT where SP_ID='"
								+ Seller_Product + "'");
				ResultSet rs09 = ps13.executeQuery();
				int payOrderId = 0 ;
				while (rs09.next()) {
					payOrderId = rs09.getInt(1);
				}
				System.out.println("hiii this is payOrderId" + payOrderId
						+ "only");
				int t=Integer.parseInt(Total_Payment);System.out.println("chekcehrkr"+t+Seller_Product+User_Id);
				java.sql.PreparedStatement ps101 = null;
				  ps101 = con .prepareStatement(
				  "insert into TRACK_ORDER(U_ID,ORDER_ID,TOTAL,SP_ID)values('" + User_Id + "',"+payOrderId+","+t + ",'" + Seller_Product +"')");
				ps101 = con .prepareStatement(
						  "insert into TRACK_ORDER(U_ID,ORDER_ID,TOTAL,SP_ID) values(?,?,?,?)");
				 ps101.executeUpdate();
				 
				 java.sql.PreparedStatement ps14 = null;
				 ps14 = con
							.prepareStatement("select SELLER_ID from SELLER_PRODUCT where SP_ID='"+ Seller_Product + "'");
				 ResultSet rs10 = ps14.executeQuery();
				 while (rs10.next()) {
					 Seller_id = rs10.getString(1);
				}
				 System.out.println("hiii this is SellerID" + Seller_id
							+ "only");
				 
				 java.sql.PreparedStatement ps15 = null;
					ps15 = con
							.prepareStatement("insert into SELLER_ACC(S_ID,ORDER_ID) values('"+Seller_id +"','"+payOrderId+"')");
					//ResultSet rs12 = ps15.executeQuery();
					ps15.executeUpdate();*/
				 
				 

				if ((quantity != null) && (Stock != null)) {
					int temp = Integer.parseInt(Stock)
							- Integer.parseInt(quantity);
					Stock = Integer.toString(temp);

					ps3 = con
							.prepareStatement("update SELLER_PRODUCT set STOCK = '"
									+ Stock
									+ "' where SP_ID = '"
									+ Seller_Product + "'");
					ps3.executeUpdate();
					System.out
							.println("I am in data base method of credit Card");
					ps2 = con
							.prepareStatement("insert into PAYMENT(PAYMENT_METHOD,AMOUNT,U_ID,SP_ID) values(?,?,?,?)  ");
					ps2.setString(1, "Credit");
					ps2.setString(2, Total_Payment);
					ps2.setString(3, User_Id);
					ps2.setString(4, Seller_Product);
					System.out.println("insert summary here");
					ps2.executeUpdate();
					
					
					//for single method
					
					java.sql.PreparedStatement ps13 = null;
					ps13 = con
							.prepareStatement("select ORDER_ID from PAYMENT where SP_ID='"
									+ Seller_Product + "'");
					ResultSet rs09 = ps13.executeQuery();
					int payOrderId = 0 ;
					while (rs09.next()) {
						payOrderId = rs09.getInt(1);
					}
					/*System.out.println("hiii this is payOrderId" + payOrderId
							+ "only");*/
					int t=Integer.parseInt(Total_Payment);System.out.println("chekcehrkr"+t+Seller_Product+User_Id);
					java.sql.PreparedStatement ps101 = null;
					  ps101 = con .prepareStatement(
					  "insert into TRACK_ORDER(U_ID,ORDER_ID,TOTAL,SP_ID)values('" + User_Id + "',"+payOrderId+","+t + ",'" + Seller_Product +"')");
					/*ps101 = con .prepareStatement(
							  "insert into TRACK_ORDER(U_ID,ORDER_ID,TOTAL,SP_ID) values(?,?,?,?)");*/
					 ps101.executeUpdate();
					 
					 java.sql.PreparedStatement ps14 = null;
					 ps14 = con
								.prepareStatement("select SELLER_ID from SELLER_PRODUCT where SP_ID='"+ Seller_Product + "'");
					 ResultSet rs10 = ps14.executeQuery();
					 while (rs10.next()) {
						 Seller_id = rs10.getString(1);
					}
					 System.out.println("hiii this is SellerID" + Seller_id
								+ "only");
					 
					 java.sql.PreparedStatement ps15 = null;
						ps15 = con
								.prepareStatement("insert into SELLER_ACC(S_ID,ORDER_ID) values('"+Seller_id +"','"+payOrderId+"')");
						//ResultSet rs12 = ps15.executeQuery();
						ps15.executeUpdate();
					
					return 1;

				}

				else{
					ps4 = con
							.prepareStatement("select SP_ID ,QUANTITY from CART where U_ID = '"
									+ User_Id + "'");
					ResultSet rs4 = ps4.executeQuery();
					System.out.println("Get SP_ID here");
					while (rs4.next()) {
						String Temp_SP = rs4.getString(1);
						System.out.println("Temp_SP is " + Temp_SP);
						String Temp_Qty = rs4.getString(2);
						System.out.println("Temp_qty is234 " + Temp_Qty);
						java.sql.PreparedStatement ps6 = null;
						ps6 = con
								.prepareStatement("select STOCK from SELLER_PRODUCT where SP_ID = '"
										+ Temp_SP + "'");
						ResultSet rs6 = ps6.executeQuery();
						System.out.println("Get the Stock");
						while (rs6.next()) {
							Temp_Stock = rs6.getString(1);
							System.out.println("Temp_Stock is " + Temp_Stock);
							if ((Temp_Qty != null) && (Temp_Stock != null)) {
								if (Integer.parseInt(Temp_Stock) < Integer
										.parseInt(Temp_Qty)) {
									/*
									 * int t_Stock =
									 * Integer.parseInt(Temp_Stock) -
									 * Integer.parseInt(Temp_Qty); Temp_Stock =
									 * Integer.toString(t_Stock);
									 * java.sql.PreparedStatement ps7 = null;
									 * ps7 = con.prepareStatement(
									 * "update SELLER_PRODUCT set STOCK = '"
									 * +Stock+"' where SP_ID = '"+Temp_SP+"'");
									 * ps7.executeQuery();
									 */

									System.out.println("Insufficient stock");
									java.sql.PreparedStatement ps9 = null;
									ps9 = con
											.prepareStatement("update User_Bank set BALANCE = '"
													+ Ret_Balance
													+ "' where CARD_NUMBER = '"
													+ CardNumber + "'");
									ps9.executeUpdate();
									return 4;

								}

							}

						}
					}

					System.out.println("Get SP_ID again");
					java.sql.PreparedStatement ps7 = null;
					ps7 = con
							.prepareStatement("select SP_ID ,QUANTITY from CART where U_ID = '"
									+ User_Id + "'");
					ResultSet rs7 = ps7.executeQuery();

					// System.out.println(rs7.first());
					while (rs7.next()) {

						String Temp_SP = rs7.getString(1);
						String Temp_Qty = rs7.getString(2);
						
						java.sql.PreparedStatement ps11 = null;
						ps11 = con
								.prepareStatement("select STOCK, PRICE ,DELIVERY_CHARGE from SELLER_PRODUCT where SP_ID = '"
										+ Temp_SP + "'");
						System.out.println("In the rs7.next");
						ResultSet rs11 = ps11.executeQuery();
						String Temp_Stock1 = null;
						String Temp_Price = null;
						String Temp_DCharge = null;
						if (rs11.next()) {
							Temp_Stock1 = rs11.getString(1);
							Temp_Price = rs11.getString(2);
							Temp_DCharge = rs11.getString(3);
							
							int TPrice = Integer.parseInt(Temp_Price) + Integer.parseInt(Temp_DCharge);
							Temp_Price = Integer.toString(TPrice);
							java.sql.PreparedStatement ps33 = null;
							ps33 = con.prepareStatement("insert into PAYMENT(PAYMENT_METHOD,AMOUNT,U_ID,SP_ID) values(?,?,?,?)");
						
								ps33.setString(1, "Credit");
								ps33.setString(2, Temp_Price);
								ps33.setString(3, User_Id);
								ps33.setString(4, Temp_SP);
								System.out.println("insert summary here");
								ps33.executeUpdate();
								
								
								//for multiple method try here
								
								java.sql.PreparedStatement ps34 = null;
								ps34 = con
										.prepareStatement("select ORDER_ID from PAYMENT where SP_ID='"
												+ Temp_SP + "'");
								ResultSet rs44 = ps34.executeQuery();
								int payOrderId = 0 ;
								while (rs44.next()) {
									payOrderId = rs44.getInt(1);
								}
								/*System.out.println("hiii this is payOrderId" + payOrderId
										+ "only");*/
								int t=Integer.parseInt(Temp_Price) * Integer.parseInt(Temp_Qty) ;System.out.println("chekcehrkr"+t+Seller_Product+User_Id);
								java.sql.PreparedStatement ps35 = null;
								  ps35 = con .prepareStatement(
								  "insert into TRACK_ORDER(U_ID,ORDER_ID,TOTAL,SP_ID)values('" + User_Id + "',"+payOrderId+","+t + ",'" + Temp_SP +"')");
								/*ps101 = con .prepareStatement(
										  "insert into TRACK_ORDER(U_ID,ORDER_ID,TOTAL,SP_ID) values(?,?,?,?)");*/
								 ps35.executeUpdate();
								 
								 java.sql.PreparedStatement ps36 = null;
								 ps36 = con
											.prepareStatement("select SELLER_ID from SELLER_PRODUCT where SP_ID='"+ Temp_SP + "'");
								 ResultSet rs46 = ps36.executeQuery();
								 while (rs46.next()) {
									 Seller_id = rs46.getString(1);
								}
								 System.out.println("hiii this is SellerID" + Seller_id
											+ "only");
								 
								 java.sql.PreparedStatement ps37 = null;
									ps37 = con
											.prepareStatement("insert into SELLER_ACC(S_ID,ORDER_ID) values('"+Seller_id +"','"+payOrderId+"')");
									//ResultSet rs12 = ps15.executeQuery();
									ps37.executeUpdate();

								
						}
						// String Temp_Stock = rs7.getString(1);
						System.out.println("Temp_qty is again " + Temp_Qty);
						System.out.println("Temp_SP is " + Temp_SP);
						System.out.println("Temp_Stock is" + Temp_Stock);
						if ((Temp_Qty != null) && (Temp_Stock1 != null)) {
							if (Integer.parseInt(Temp_Stock1) >= Integer
									.parseInt(Temp_Qty)) {
								int t_Stock = Integer.parseInt(Temp_Stock1)
										- Integer.parseInt(Temp_Qty);
								Temp_Stock = Integer.toString(t_Stock);
								java.sql.PreparedStatement ps8 = null;
								ps8 = con
										.prepareStatement("update SELLER_PRODUCT set STOCK = '"
												+ Temp_Stock
												+ "' where SP_ID = '"
												+ Temp_SP
												+ "'");
								ps8.executeUpdate();
							
								System.out.println("update stock here");

							}
						}

					}
					

					/*java.sql.PreparedStatement ps10 = null;
					ps10 = con
							.prepareStatement("delete from CART where U_ID = '"
									+ User_Id + "'");
					ps10.executeUpdate();*/
					return 1;
				}

			}
		} catch (Exception e) {
			e.getLocalizedMessage();
			e.printStackTrace();
		}
		System.out.println("Nothing happen");
		return 0;
	}

	public int conform_Debit_Pay(PayMentModel payMentModel, String CardNumber) {
		// TODO Auto-generated method stub
		java.sql.Connection con = null;
		java.sql.PreparedStatement pstmt = null;
		java.sql.PreparedStatement ps2 = null;
		java.sql.PreparedStatement ps3 = null;
		java.sql.PreparedStatement ps4 = null;
		java.sql.PreparedStatement ps1 = null;
		ResultSet rs = null;
		DBconnection dbc = new DBconnection();
		System.out.println("payment is" + Total_Payment);
		String balance;
		String Ret_Balance = null;
		String Temp_Stock = null;
		try {
			con = dbc.createConnection();
			System.out.println("cvv string is " + payMentModel.getCvv1());
			int cvv = Integer.parseInt(payMentModel.getCvv1());
			int new_Balance = 0;
			System.out.println(CardNumber);
			pstmt = con
					.prepareStatement("select BAlANCE,CVV,MONTH,YEAR from User_Bank where CARD_NUMBER = '"
							+ CardNumber + "'");

			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString(1));
				new_Balance = Integer.parseInt(rs.getString(1));
				System.out.println(Total_Payment);
				int num1 = Integer.parseInt(Total_Payment);
				System.out.println("Toatal amount is" + num1);
				Ret_Balance = rs.getString(1);
				int num2 = Integer.parseInt(rs.getString(1));
				System.out.println("Balance is" + num2);

				if (num1 <= num2) {
					int cvvcheck = Integer.parseInt(rs.getString(2));
					System.out.println("cvvcheck is" + cvvcheck);
					// System.out.println("CVV is"+cvv);

					if (cvvcheck != cvv) {
						System.out.println("I am in rs.next cvv");
						return 0;
					}

					else {

						new_Balance = new_Balance
								- Integer.parseInt(Total_Payment);
						balance = Integer.toString(new_Balance);
					}
				}

				else {
					System.out.println("this is else part");
					return 2;
				}

				ps1 = con.prepareStatement("update User_Bank set BALANCE = '"
						+ balance + "' where CARD_NUMBER = '" + CardNumber
						+ "'");
				System.out.println("Balance is updated here");
				ps1.executeUpdate();

				ps2 = con
						.prepareStatement("insert into PAYMENT(PAYMENT_METHOD,AMOUNT,U_ID,SP_ID) values(?,?,?,?)  ");
				ps2.setString(1, "Debit");
				ps2.setString(2, Total_Payment);
				ps2.setString(3, User_Id);
				ps2.setString(4, Seller_Product);
				System.out.println("insert summary here");
				ps2.executeUpdate();
				
				java.sql.PreparedStatement ps13 = null;
				ps13 = con
						.prepareStatement("select ORDER_ID from PAYMENT where SP_ID='"
								+ Seller_Product + "'");
				ResultSet rs09 = ps13.executeQuery();
				int payOrderId = 0 ;
				while (rs09.next()) {
					payOrderId = rs09.getInt(1);
				}
				System.out.println("hiii this is payOrderId" + payOrderId
						+ "only");
				int t=Integer.parseInt(Total_Payment);System.out.println("chekcehrkr"+t+Seller_Product+User_Id);
				java.sql.PreparedStatement ps101 = null;
				  ps101 = con .prepareStatement(
				  "insert into TRACK_ORDER(U_ID,ORDER_ID,TOTAL,SP_ID)values('" + User_Id + "',"+payOrderId+","+t + ",'" + Seller_Product +"')");
				/*ps101 = con .prepareStatement(
						  "insert into TRACK_ORDER(U_ID,ORDER_ID,TOTAL,SP_ID) values(?,?,?,?)");*/
				 ps101.executeUpdate();


				if ((quantity != null) && (Stock != null)) {
					int temp = Integer.parseInt(Stock)
							- Integer.parseInt(quantity);
					Stock = Integer.toString(temp);

					ps3 = con
							.prepareStatement("update SELLER_PRODUCT set STOCK = '"
									+ Stock
									+ "' where SP_ID = '"
									+ Seller_Product + "'");
					ps3.executeUpdate();
					System.out
							.println("I am in data base method of credit Card");
					return 1;

				}

				else {
					ps4 = con
							.prepareStatement("select SP_ID ,QUANTITY from CART where U_ID = '"
									+ User_Id + "'");
					ResultSet rs4 = ps4.executeQuery();
					System.out.println("Get SP_ID here");
					while (rs4.next()) {
						String Temp_SP = rs4.getString(1);
						System.out.println("Temp_SP is " + Temp_SP);
						String Temp_Qty = rs4.getString(2);
						System.out.println("Temp_qty is " + Temp_Qty);
						java.sql.PreparedStatement ps6 = null;
						ps6 = con
								.prepareStatement("select STOCK from SELLER_PRODUCT where SP_ID = '"
										+ Temp_SP + "'");
						ResultSet rs6 = ps6.executeQuery();
						System.out.println("Get the Stock");
						while (rs6.next()) {
							Temp_Stock = rs6.getString(1);
							System.out.println("Temp_Stock is " + Temp_Stock);
							if ((Temp_Qty != null) && (Temp_Stock != null)) {
								if (Integer.parseInt(Temp_Stock) < Integer
										.parseInt(Temp_Qty)) {
									/*
									 * int t_Stock =
									 * Integer.parseInt(Temp_Stock) -
									 * Integer.parseInt(Temp_Qty); Temp_Stock =
									 * Integer.toString(t_Stock);
									 * java.sql.PreparedStatement ps7 = null;
									 * ps7 = con.prepareStatement(
									 * "update SELLER_PRODUCT set STOCK = '"
									 * +Stock+"' where SP_ID = '"+Temp_SP+"'");
									 * ps7.executeQuery();
									 */

									System.out.println("Insufficient stock");
									java.sql.PreparedStatement ps9 = null;
									ps9 = con
											.prepareStatement("update User_Bank set BALANCE = '"
													+ Ret_Balance
													+ "' where CARD_NUMBER = '"
													+ CardNumber + "'");
									ps9.executeUpdate();
									return 4;

								}

							}

						}
					}

					System.out.println("Get SP_ID again");
					java.sql.PreparedStatement ps7 = null;
					ps7 = con
							.prepareStatement("select SP_ID ,QUANTITY from CART where U_ID = '"
									+ User_Id + "'");
					ResultSet rs7 = ps7.executeQuery();

					// System.out.println(rs7.first());
					while (rs7.next()) {

						String Temp_SP = rs7.getString(1);
						String Temp_Qty = rs7.getString(2);
						java.sql.PreparedStatement ps11 = null;
						ps11 = con
								.prepareStatement("select STOCK from SELLER_PRODUCT where SP_ID = '"
										+ Temp_SP + "'");
						System.out.println("In the rs7.next");
						ResultSet rs11 = ps11.executeQuery();
						String Temp_Stock1 = null;
						if (rs11.next()) {
							Temp_Stock1 = rs11.getString(1);
						}
						// String Temp_Stock = rs7.getString(1);
						System.out.println("Temp_qty is again " + Temp_Qty);
						System.out.println("Temp_SP is " + Temp_SP);
						System.out.println("Temp_Stock is" + Temp_Stock);
						if ((Temp_Qty != null) && (Temp_Stock1 != null)) {
							if (Integer.parseInt(Temp_Stock1) >= Integer
									.parseInt(Temp_Qty)) {
								int t_Stock = Integer.parseInt(Temp_Stock1)
										- Integer.parseInt(Temp_Qty);
								Temp_Stock = Integer.toString(t_Stock);
								java.sql.PreparedStatement ps8 = null;
								ps8 = con
										.prepareStatement("update SELLER_PRODUCT set STOCK = '"
												+ Temp_Stock
												+ "' where SP_ID = '"
												+ Temp_SP
												+ "'");
								ps8.executeUpdate();
								System.out.println("update stock here");

							}
						}

					}

					/*java.sql.PreparedStatement ps10 = null;
					ps10 = con
							.prepareStatement("delete from CART where U_ID = '"
									+ User_Id + "'");
					ps10.executeUpdate();*/
					return 1;
				}

			}
		} catch (Exception e) {
			e.getLocalizedMessage();
			e.printStackTrace();
		}
		System.out.println("Nothing happen");
		return 0;
	}

	public int conform_NetBanking_Pay(PayMentModel payMentModel,
			String AccountNumber) {
		// TODO Auto-generated method stub
		java.sql.Connection con = null;
		java.sql.PreparedStatement pstmt = null;
		java.sql.PreparedStatement ps2 = null;
		java.sql.PreparedStatement ps4 = null;
		java.sql.PreparedStatement ps1 = null;
		java.sql.PreparedStatement ps3 = null;
		ResultSet rs = null;
		DBconnection dbc = new DBconnection();
		System.out.println("payment is" + Total_Payment);
		String balance;

		String Ret_Balance = null;
		String Temp_Stock = null;

		try {
			con = dbc.createConnection();
			System.out.println(" Bank_Id is " + payMentModel.getBank_ID());

			int new_Balance = 0;

			pstmt = con
					.prepareStatement("select BAlANCE,PASSWORD from User_Bank where  ACC_ID= '"
							+ AccountNumber + "'");

			rs = pstmt.executeQuery();
			if (rs != null) {
				System.out.println("In the rs.next if loop");
				while (rs.next()) {
					System.out.println(rs.getString(1));
					new_Balance = Integer.parseInt(rs.getString(1));
					System.out.println(Total_Payment);
					int num1 = Integer.parseInt(Total_Payment);
					System.out.println("Toatal amount is" + num1);

					int num2 = Integer.parseInt(rs.getString(1));
					System.out.println("Balance is" + num2);
					if (num1 <= num2) {
						String pass = payMentModel.getBank_Password();
						String pass1 = rs.getString(2);

						if (pass.equals(pass1)) {
							System.out.println("I am in rs.next Net Banking");
							System.out.println(Seller_Product);
							new_Balance = new_Balance
									- Integer.parseInt(Total_Payment);
							balance = Integer.toString(new_Balance);
						}

						else {
							return 0;

						}
					}

					else {
						System.out.println("this is else part");
						return 2;
					}

					ps1 = con
							.prepareStatement("update User_Bank set BALANCE = '"
									+ balance
									+ "' where ACC_ID= '"
									+ AccountNumber + "'");
					ps1.executeUpdate();
					ps2 = con
							.prepareStatement("insert into PAYMENT(PAYMENT_METHOD,AMOUNT,U_ID,SP_ID) values(?,?,?,?)  ");
					ps2.setString(1, "NetBanking");
					ps2.setString(2, Total_Payment);
					ps2.setString(3, User_Id);
					ps2.setString(4, Seller_Product);
					ps2.executeUpdate();
					
					java.sql.PreparedStatement ps13 = null;
					ps13 = con
							.prepareStatement("select ORDER_ID from PAYMENT where SP_ID='"
									+ Seller_Product + "'");
					ResultSet rs09 = ps13.executeQuery();
					int payOrderId = 0 ;
					while (rs09.next()) {
						payOrderId = rs09.getInt(1);
					}
					System.out.println("hiii this is payOrderId" + payOrderId
							+ "only");
					int t=Integer.parseInt(Total_Payment);System.out.println("chekcehrkr"+t+Seller_Product+User_Id);
					java.sql.PreparedStatement ps101 = null;
					  ps101 = con .prepareStatement(
					  "insert into TRACK_ORDER(U_ID,ORDER_ID,TOTAL,SP_ID)values('" + User_Id + "',"+payOrderId+","+t + ",'" + Seller_Product +"')");
					/*ps101 = con .prepareStatement(
							  "insert into TRACK_ORDER(U_ID,ORDER_ID,TOTAL,SP_ID) values(?,?,?,?)");*/
					 ps101.executeUpdate();

					
					if ((quantity != null) && (Stock != null)) {
						int temp = Integer.parseInt(Stock)
								- Integer.parseInt(quantity);
						Stock = Integer.toString(temp);

						ps3 = con
								.prepareStatement("update SELLER_PRODUCT set STOCK = '"
										+ Stock
										+ "' where SP_ID = '"
										+ Seller_Product + "'");
						ps3.executeUpdate();
						System.out
								.println("I am in data base method of credit Card");
						return 1;

					}

					else {
						ps4 = con
								.prepareStatement("select SP_ID ,QUANTITY from CART where U_ID = '"
										+ User_Id + "'");
						ResultSet rs4 = ps4.executeQuery();
						System.out.println("Get SP_ID here");
						while (rs4.next()) {
							String Temp_SP = rs4.getString(1);
							System.out.println("Temp_SP is " + Temp_SP);
							String Temp_Qty = rs4.getString(2);
							System.out.println("Temp_qty is " + Temp_Qty);
							java.sql.PreparedStatement ps6 = null;
							ps6 = con
									.prepareStatement("select STOCK from SELLER_PRODUCT where SP_ID = '"
											+ Temp_SP + "'");
							ResultSet rs6 = ps6.executeQuery();
							System.out.println("Get the Stock");
							while (rs6.next()) {
								Temp_Stock = rs6.getString(1);
								System.out.println("Temp_Stock is "
										+ Temp_Stock);
								if ((Temp_Qty != null) && (Temp_Stock != null)) {
									if (Integer.parseInt(Temp_Stock) < Integer
											.parseInt(Temp_Qty)) {
										/*
										 * int t_Stock =
										 * Integer.parseInt(Temp_Stock) -
										 * Integer.parseInt(Temp_Qty);
										 * Temp_Stock =
										 * Integer.toString(t_Stock);
										 * java.sql.PreparedStatement ps7 =
										 * null; ps7 = con.prepareStatement(
										 * "update SELLER_PRODUCT set STOCK = '"
										 * +
										 * Stock+"' where SP_ID = '"+Temp_SP+"'"
										 * ); ps7.executeQuery();
										 */

										System.out
												.println("Insufficient stock");
										java.sql.PreparedStatement ps9 = null;
										ps9 = con
												.prepareStatement("update User_Bank set BALANCE = '"
														+ Ret_Balance
														+ "' where CARD_NUMBER = '"
														+ AccountNumber + "'");
										ps9.executeUpdate();
										return 4;

									}

								}

							}
						}

						System.out.println("Get SP_ID again");
						java.sql.PreparedStatement ps7 = null;
						ps7 = con
								.prepareStatement("select SP_ID ,QUANTITY from CART where U_ID = '"
										+ User_Id + "'");
						ResultSet rs7 = ps7.executeQuery();

						// System.out.println(rs7.first());
						while (rs7.next()) {

							String Temp_SP = rs7.getString(1);
							String Temp_Qty = rs7.getString(2);
							java.sql.PreparedStatement ps11 = null;
							ps11 = con
									.prepareStatement("select STOCK from SELLER_PRODUCT where SP_ID = '"
											+ Temp_SP + "'");
							System.out.println("In the rs7.next");
							ResultSet rs11 = ps11.executeQuery();
							String Temp_Stock1 = null;
							if (rs11.next()) {
								Temp_Stock1 = rs11.getString(1);
							}
							// String Temp_Stock = rs7.getString(1);
							System.out.println("Temp_qty is again " + Temp_Qty);
							System.out.println("Temp_SP is " + Temp_SP);
							System.out.println("Temp_Stock is" + Temp_Stock);
							if ((Temp_Qty != null) && (Temp_Stock1 != null)) {
								if (Integer.parseInt(Temp_Stock1) >= Integer
										.parseInt(Temp_Qty)) {
									int t_Stock = Integer.parseInt(Temp_Stock1)
											- Integer.parseInt(Temp_Qty);
									Temp_Stock = Integer.toString(t_Stock);
									java.sql.PreparedStatement ps8 = null;
									ps8 = con
											.prepareStatement("update SELLER_PRODUCT set STOCK = '"
													+ Temp_Stock
													+ "' where SP_ID = '"
													+ Temp_SP + "'");
									ps8.executeUpdate();
									System.out.println("update stock here");

								}
							}

						}

						/*java.sql.PreparedStatement ps10 = null;
						ps10 = con
								.prepareStatement("delete from CART where U_ID = '"
										+ User_Id + "'");
						ps10.executeUpdate();*/
						return 1;
					}

				}
			}
		} catch (Exception e) {
			e.getLocalizedMessage();
			e.printStackTrace();
		}
		System.out.println("Nothing happen");
		return 0;
	}

	public ArrayList<ProductDescriptionModel> get_Review(
			ProductDescriptionModel prodModel) throws ClassNotFoundException,
			SQLException {
		// TODO Auto-generated method stub
		java.sql.Connection con = null;
		java.sql.PreparedStatement ps1 = null;
		ResultSet rs = null;
		DBconnection dbc = new DBconnection();
		con = dbc.createConnection();
		ps1 = con
				.prepareStatement("select U_ID , REVIEW_DESCRIPTION , HEADING ,RATING from REVIEW where SP_ID = '"
						+ Seller_Product + "'");
		ArrayList<ProductDescriptionModel> Reviews = new ArrayList<ProductDescriptionModel>();
		rs = ps1.executeQuery();
		while (rs.next()) {
			ProductDescriptionModel prodModel1 = new ProductDescriptionModel();
			prodModel1.setReview_Description(rs.getString(2));
			prodModel1.setUser(rs.getString(1));
			prodModel1.setReview_Heding(rs.getString(3));
			prodModel1.setPersonal_Rating(rs.getString(4));
			Reviews.add(prodModel1);
		}

		return Reviews;
	}

	public void enterReview(ProductDescriptionModel prodModel)
			throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		java.sql.Connection con = null;
		java.sql.PreparedStatement ps1 = null;

		DBconnection dbc = new DBconnection();
		con = dbc.createConnection();
		ps1 = con
				.prepareStatement("insert into REVIEW (SP_ID,U_ID,REVIEW_DESCRIPTION , HEADING ,RATING) values(?,?,?,?,?)");
		ps1.setString(1, prodModel.getSP_ID());
		ps1.setString(2, prodModel.getUser());
		ps1.setString(3, prodModel.getReview_Description());
		ps1.setString(4, prodModel.getReview_Heding());
		ps1.setInt(5, Integer.parseInt(prodModel.getPersonal_Rating()));
		ps1.executeUpdate();

	}


public ArrayList<String> updateSeller(String sellerId) throws SQLException {
		
		java.sql.Connection con = null;
		java.sql.PreparedStatement ps1 = null;
		ResultSet rs = null;
		DBconnection dbc = new DBconnection();
		con = dbc.createConnection();
		
		String query="select P_NAME from PRODUCT_INFO where P_ID in(select P_ID from SELLER_PRODUCT where SELLER_ID='"+sellerId+"')";
		ps1 = con.prepareStatement(query);
		ArrayList<String> productName =new ArrayList<String> ();
		rs=ps1.executeQuery();
		if(rs!=null)
		{
			while(rs.next())
			{System.out.println("product:::::"+rs.getString("P_NAME"));
				productName.add(rs.getString("P_NAME"));
			}
		}
		
		return productName;
		
	}

	public ArrayList<PayMentModel> updateSeller1(PayMentModel payMentModel, String name) throws SQLException 
	{
		java.sql.Connection con = null;
		
		java.sql.PreparedStatement ps1 = null;
		ResultSet rs = null;
		DBconnection dbc = new DBconnection();
		con = dbc.createConnection();
		System.out.println(name);
		String query="SELECT STOCK,PRICE,ORIGINAL_STOCK FROM Flipkart_db.SELLER_PRODUCT where P_ID in (select P_ID from PRODUCT_INFO where P_NAME='"+name+"')";
		ps1 = con.prepareStatement(query);
		ArrayList<PayMentModel> productName =new ArrayList<PayMentModel> ();
		rs=ps1.executeQuery();
		System.out.println("hellloo from produvt list");
		
		//System.out.println(rs.next());
			while(rs.next())
			{	System.out.println("in wghihfd");
				int temp = 0,p=0;
				
				PayMentModel pm=new PayMentModel();
				
				String temp1=rs.getString("ORIGINAL_STOCK");   System.out.println("original stock is"+temp1);
				
				String temp2=rs.getString("STOCK");    System.out.println("current stock is"+temp1);
				 
				int prise=rs.getInt("PRICE");      //pm.setS_stock(rs.getString("STOCK"));
				
				//System.out.println("price is::::::::::: "+prise);
				
				temp = Integer.parseInt(temp1)
						- Integer.parseInt(temp2);
				
				if(temp==0)
				{
					temp=Integer.parseInt(temp1);
				}
				System.out.println("temp is:::::::::::::: "+temp);
				
				prise=prise*temp;
				
				//System.out.println("5"+prise);
				
				pm.setS_stock(Integer.toString(temp));
				pm.setS_price(Integer.toString(prise));System.out.println(pm.getS_price());
				
				System.out.println("lasyt");
				
				productName.add(pm);System.out.println(productName);
				//pm.setS_price(rs.getString("PRICE"));
				/*if (payMentModel.getS_originalStock() != null
						&& payMentModel.getS_stock() != null) {
					temp = Integer.parseInt(payMentModel.getS_originalStock())
							- Integer.parseInt(payMentModel.getS_stock());
					System.out.println(temp + " tempis;;;;");
					System.out.println("Temp is"+temp);
					p = temp * Integer.parseInt(payMentModel.getS_price());
					System.out.println(p + " p is;;;;");
					System.out.println("P is" + p);
					payMentModel.setS_price(Integer.toString(p));
					payMentModel.setS_stock(Integer.toString(temp));*/
				
				}
				
				//System.out.println("product:::::"+rs.getString("P_NAME"));
				
		
	
		//System.out.println("i m in model"+name);
		return productName;
	}

	public void get_count(ProductInfo sm, String pid) throws SQLException
	{
		DBconnection dbc = new DBconnection();
		java.sql.Connection c = dbc.createConnection();

		System.out.println("In the sp_Id");
		c = (Connection) dbc.createConnection();
		String sql1 = "SELECT SP_ID from SELLER_PRODUCT where P_ID='"
				+ pid + "'";
		java.sql.PreparedStatement ps1 = c.prepareCall(sql1);
		java.sql.ResultSet rs1 = ps1.executeQuery();
		while (rs1.next()) {
			sm.setSP_ID(rs1.getString(1));
			Seller_Product = rs1.getString(1);
			System.out.println("Seller Product Id is" + rs1.getString(1));

		}

		
	}
	
	public void delfromCart(productDescriptionDB deleteCart, String uid) throws SQLException 
	{
		DBconnection dbc = new DBconnection();
		java.sql.Connection c = dbc.createConnection();
		c=(Connection) dbc.createConnection();
		String sql="delete  from CART where U_ID='"+uid+"'";
		java.sql.PreparedStatement ps=  c.prepareStatement(sql);
		ps.executeUpdate();
		// TODO Auto-generated method stub
		
	}

	
}