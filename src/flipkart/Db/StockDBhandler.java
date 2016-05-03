package flipkart.Db;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;

import flipkart.Model.CategoryModel;
import flipkart.Model.InsertMappingModel;
import flipkart.Model.InsertProductModel;
import flipkart.Model.InsertSellerProductModel;
import flipkart.Model.LastCategoryModel;
import flipkart.Model.SellersInfoModel;
import flipkart.Model.SubCategoryModel;
import flipkart.Model.UppercategoryModel;
import flipkart.Model.Usermodel;

public class StockDBhandler  implements SessionAware {
	Map Session ;
	public Map getSession() {
		return Session;
	}

	public void setSession(Map session) {
		Session = session;
	}
	public void InsertProduct(InsertProductModel insertProductModel)
			throws ClassNotFoundException, SQLException, IOException {
		try {
			DBconnection db = new DBconnection();
			Connection con = db.createConnection();
			System.out.println("InsertProduct filename db stock "
					+ insertProductModel.getPhoto1FileName());

			File destFile = new File(insertProductModel.getDestpath(),
					insertProductModel.getPhoto1FileName());
			System.out.println("after destfile114 ");

			FileUtils.copyFile(insertProductModel.getPhoto1(), destFile);
			System.out.println("Aferter 1 ");

			System.out.println("InsertProduct desp db stock "
					+ insertProductModel.getDestpath());
			File destFile2 = new File(insertProductModel.getDestpath(),
					insertProductModel.getPhoto2FileName());
			FileUtils.copyFile(insertProductModel.getPhoto2(), destFile2);
			System.out.println("Aferter 2 ");

			File destFile3 = new File(insertProductModel.getDestpath(),
					insertProductModel.getPhoto3FileName());
			FileUtils.copyFile(insertProductModel.getPhoto3(), destFile3);
			File destFile4 = new File(insertProductModel.getDestpath(),
					insertProductModel.getPhoto4FileName());
			FileUtils.copyFile(insertProductModel.getPhoto4(), destFile4);
			PreparedStatement preparedStatement = con
					.prepareStatement("insert into PRODUCT_INFO (P_ID,P_NAME,P_DESCRIPTION,P_BRAND,P_IMAGE) values(?,?,?,?,?)");
			preparedStatement.setString(1, insertProductModel.getItem_ID());
			preparedStatement.setString(2, insertProductModel.getItem_name());
			preparedStatement.setString(3,
					insertProductModel.getItem_Description());
			preparedStatement.setString(4, insertProductModel.getBrand());
			preparedStatement.setString(5,
					insertProductModel.getPhoto1FileName());
			preparedStatement.executeUpdate();
			
			
			
			
			PreparedStatement ps = con
					.prepareStatement("insert into PRODUCT (P_ID116,P_NAME116,P_DESCRIPTION,P_BRAND,P_IMAGE116) values(?,?,?,?,?)");
			ps.setString(1, insertProductModel.getItem_ID());
			ps.setString(2, insertProductModel.getItem_name());
			ps.setString(3,
					insertProductModel.getItem_Description());
			ps.setString(4, insertProductModel.getBrand());
			ps.setString(5,
					insertProductModel.getPhoto1FileName());
			ps.executeUpdate();
			
			
			
			
			
			
			
			
			
			
			
			System.out.println("inside try of insert product ");
			PreparedStatement preparedStatementImage1 = con
					.prepareStatement("insert into IMAGE (P_ID,IMAGE) values(?,?)");
			preparedStatementImage1.setString(1,
					insertProductModel.getItem_ID());
			preparedStatementImage1.setString(2,
					insertProductModel.getPhoto1FileName());
			preparedStatementImage1.executeUpdate();
			PreparedStatement preparedStatementImage2 = con
					.prepareStatement("insert into IMAGE (P_ID,IMAGE) values(?,?)");
			preparedStatementImage2.setString(1,
					insertProductModel.getItem_ID());
			preparedStatementImage2.setString(2,
					insertProductModel.getPhoto2FileName());
			preparedStatementImage2.executeUpdate();
			PreparedStatement preparedStatementImage3 = con
					.prepareStatement("insert into IMAGE (P_ID,IMAGE) values(?,?)");
			preparedStatementImage3.setString(1,
					insertProductModel.getItem_ID());
			preparedStatementImage3.setString(2,
					insertProductModel.getPhoto3FileName());
			preparedStatementImage3.executeUpdate();
			PreparedStatement preparedStatementImage4 = con
					.prepareStatement("insert into IMAGE (P_ID,IMAGE) values(?,?)");
			preparedStatementImage4.setString(1,
					insertProductModel.getItem_ID());
			preparedStatementImage4.setString(2,
					insertProductModel.getPhoto4FileName());
			preparedStatementImage4.executeUpdate();
			PreparedStatement preparedStatement5 = con
					.prepareStatement("insert into SEARCH (P_ID,KEYWORD) values(?,?)");
			preparedStatement5.setString(1, insertProductModel.getItem_ID());
			preparedStatement5.setString(2, insertProductModel.getItem_name());
			preparedStatement5.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println("Error.." + e);
		}
	}

	// sellers info
	public void SellersInfo(SellersInfoModel sellersInfoModel)
			throws ClassNotFoundException, SQLException, IOException {
		try {
			DBconnection db = new DBconnection();
			System.out.println("sellersInfoModel.getSeller_ID()"
					+ sellersInfoModel.getSeller_ID());
			Connection con = db.createConnection();
			PreparedStatement preparedStatement = con
					.prepareStatement("insert into SELLER (SELLER_ID,SELLER_NAME,PHONE,LOCATION) values(?,?,?,?)");
			preparedStatement.setString(1, sellersInfoModel.getSeller_ID());
			preparedStatement.setString(2, sellersInfoModel.getSeller_name());
			preparedStatement.setString(3, sellersInfoModel.getPhone());
			preparedStatement.setString(4,
					sellersInfoModel.getSeller_Location());
			// preparedStatement.setString(5,sellersInfoModel.getPhoto6FileName());
			preparedStatement.executeUpdate();
//add into credential	
			PreparedStatement preparedStatement1 = con
					.prepareStatement("insert into CREDENTIAL (U_ID,F_NAME,PASSWORD,ROLE) values(?,?,?,?)");
			preparedStatement1.setString(1, sellersInfoModel.getSeller_ID());
			preparedStatement1.setString(2, sellersInfoModel.getSeller_name());
			preparedStatement1.setString(3, sellersInfoModel.getPASSWORD());
			preparedStatement1.setString(4,"seller");
			// preparedStatement.setString(5,sellersInfoModel.getPhoto6FileName());
			preparedStatement1.executeUpdate();
		
			con.close();
		}

		catch (Exception e) {
			System.out.println("Error.." + e);
		}
	}

	public void InsertUpperCategory(UppercategoryModel upperCategoryModel)
			throws ClassNotFoundException, SQLException, IOException {
		try {
			DBconnection db = new DBconnection();
			Connection con = db.createConnection();
			PreparedStatement preparedStatement = con
					.prepareStatement("insert into UPPER_CATEGORY (UC_ID,UC_NAME) values(?,?)");
			preparedStatement.setString(1, upperCategoryModel.getUP_ID());
			preparedStatement.setString(2, upperCategoryModel.getUP_name());
			preparedStatement.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println("Error.." + e);
		}
	}

	public void InsertCategory(CategoryModel categoryModel)
			throws ClassNotFoundException, SQLException, IOException {
		try {
			DBconnection db = new DBconnection();
			Connection con = db.createConnection();
			PreparedStatement preparedStatement = con
					.prepareStatement("insert into CATEGORY (C_ID,C_NAME) values(?,?)");
			preparedStatement.setString(1, categoryModel.getC_ID());
			preparedStatement.setString(2, categoryModel.getC_name());
			preparedStatement.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println("Error.." + e);
		}
	}

	public void InsertSubCategory(SubCategoryModel subCategoryModel)
			throws ClassNotFoundException, SQLException, IOException {
		try {
			DBconnection db = new DBconnection();
			Connection con = db.createConnection();
			PreparedStatement preparedStatement = con
					.prepareStatement("insert into SUB_CATEGORY (SC_ID,SC_NAME) values(?,?)");
			preparedStatement.setString(1, subCategoryModel.getSC_ID());
			preparedStatement.setString(2, subCategoryModel.getSC_NAME());
			preparedStatement.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println("Error.." + e);
		}
	}

	public void GetSellerInfo(Usermodel usermodel,String uid)
			throws ClassNotFoundException, SQLException, IOException {
		try {
			DBconnection db = new DBconnection();
			Connection con = db.createConnection();
			
			PreparedStatement preparedStatement = con
					.prepareStatement("SELECT F_NAME,PASSWORD FROM Flipkart_db.CREDENTIAL WHERE U_ID=?");
			preparedStatement.setString(1,uid);
			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				usermodel.setUid(uid);
				usermodel.setPassword(rs.getString("PASSWORD"));
				usermodel.setFirstname(rs.getString("F_NAME"));
				}
			con.close();
		} catch (Exception e) {
			System.out.println("Error.." + e);
		}
	}

	public void InsertLastCategory(LastCategoryModel lastCategoryModel)
			throws ClassNotFoundException, SQLException, IOException {
		try {
			DBconnection db = new DBconnection();
			Connection con = db.createConnection();
			PreparedStatement preparedStatement = con
					.prepareStatement("insert into LAST_CATEGORY (LC_ID,LC_NAME) values(?,?)");
			preparedStatement.setString(1, lastCategoryModel.getLC_ID());
			preparedStatement.setString(2, lastCategoryModel.getLC_NAME());
			preparedStatement.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println("Error.." + e);
		}
	}

	public void FetchCategory(
			ArrayList<InsertProductModel> arrInsertProductModel,
			ArrayList<UppercategoryModel> arruppercategoryModel,
			ArrayList<CategoryModel> arrCategoryModel,
			ArrayList<SubCategoryModel> arrSubCategoryModel,
			ArrayList<LastCategoryModel> arrLastCategoryModel) {
		try {
			int i = 0;
			DBconnection db = new DBconnection();
			Connection con = db.createConnection();

			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement("SELECT P_NAME FROM PRODUCT_INFO");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				InsertProductModel ipm = new InsertProductModel();
				ipm.setItem_name(rs.getString(1));

				arrInsertProductModel.add(i, ipm);

				i++;

			}
			i = 0;
			PreparedStatement ps1 = (PreparedStatement) con
					.prepareStatement("SELECT C_NAME FROM CATEGORY");
			ResultSet rs1 = ps1.executeQuery();
			while (rs1.next()) {
				CategoryModel cm = new CategoryModel();
				cm.setC_name(rs1.getString(1));
				arrCategoryModel.add(i, cm);
				i++;
			}
			i = 0;
			PreparedStatement ps2 = (PreparedStatement) con
					.prepareStatement("SELECT UC_NAME FROM UPPER_CATEGORY");
			ResultSet rs2 = ps2.executeQuery();
			while (rs2.next()) {
				UppercategoryModel um = new UppercategoryModel();
				um.setUP_name(rs2.getString(1));
				arruppercategoryModel.add(i, um);
				i++;
			}
			i = 0;
			PreparedStatement ps3 = (PreparedStatement) con
					.prepareStatement("SELECT SC_NAME FROM SUB_CATEGORY");
			ResultSet rs3 = ps3.executeQuery();
			while (rs3.next()) {
				SubCategoryModel cm = new SubCategoryModel();
				cm.setSC_NAME(rs3.getString(1));
				arrSubCategoryModel.add(i, cm);
				i++;
			}
			i = 0;
			PreparedStatement ps4 = (PreparedStatement) con
					.prepareStatement("SELECT LC_NAME FROM LAST_CATEGORY");
			ResultSet rs4 = ps4.executeQuery();
			while (rs4.next()) {
				LastCategoryModel cm = new LastCategoryModel();
				cm.setLC_NAME(rs4.getString(1));
				arrLastCategoryModel.add(i, cm);
				i++;
			}
			con.close();
		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void FetchSellerProductAccount(
			ArrayList<InsertProductModel> arrInsertProductModel,String uid) {
		try {
			int i = 0;
			DBconnection db = new DBconnection();
			Connection con = db.createConnection();
			
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement("SELECT P_NAME FROM Flipkart_db.PRODUCT_INFO where P_ID IN (SELECT P_ID FROM Flipkart_db.SELLER_PRODUCT WHERE SELLER_ID=? )");
			ps.setString(1,uid);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				InsertProductModel ipm = new InsertProductModel();
				ipm.setItem_name(rs.getString(1));

				arrInsertProductModel.add(i, ipm);

				i++;

			}
					con.close();
		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

	//
	public void FetchSellerProduct(
			ArrayList<SellersInfoModel> arrSellersInfoModel,
			ArrayList<InsertProductModel> arrInsertProductModel) {
		try {
			int i = 0, j = 0;
			DBconnection db = new DBconnection();
			Connection con = db.createConnection();

			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement("SELECT P_NAME FROM PRODUCT_INFO");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				InsertProductModel ipm = new InsertProductModel();
				ipm.setItem_name(rs.getString(1));

				arrInsertProductModel.add(i, ipm);

				i++;

			}
			PreparedStatement ps1 = (PreparedStatement) con
					.prepareStatement("SELECT SELLER_NAME FROM SELLER");
			ResultSet rs1 = ps1.executeQuery();
			while (rs1.next()) {
				SellersInfoModel spm = new SellersInfoModel();
				spm.setSeller_name(rs1.getString(1));
				arrSellersInfoModel.add(j, spm);
				j++;
			}

			con.close();
		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void UpdateSellerProduct(
			InsertSellerProductModel insertSellerProductModel,String sellerID)
			throws ClassNotFoundException, SQLException, IOException {
		try {
			DBconnection db = new DBconnection();
			Connection con = db.createConnection();
			 String productID = "abc";
			 int stock=0;
			System.out.println("inside seller id"+sellerID);
			System.out.println("item_name"
					+ insertSellerProductModel.getSeller_name());
			PreparedStatement preparedStatement2 = (PreparedStatement) con
					.prepareStatement("SELECT P_ID FROM PRODUCT_INFO where P_NAME=?");
			preparedStatement2.setString(1,
					insertSellerProductModel.getItem_name());
			ResultSet rs2 = preparedStatement2.executeQuery();
			while (rs2.next()) {
				System.out.println(" productID in rs2" + rs2.getString(1));
				productID = rs2.getString(1);
			}
			PreparedStatement preparedStatement3 = (PreparedStatement) con
					.prepareStatement("SELECT STOCK FROM Flipkart_db.SELLER_PRODUCT where SELLER_ID=? AND P_ID=?");
			preparedStatement3.setString(1,sellerID);
			preparedStatement3.setString(2,productID);
			ResultSet rs3 = preparedStatement3.executeQuery();
			while (rs3.next()) {
				//System.out.println(" productID in rs2" + rs2.getString(1));
				stock = rs3.getInt(1);
				System.out.println("flag stock" + stock);
			}
			stock=stock+insertSellerProductModel.getStock();
			System.out.println(" productID" + productID);
			PreparedStatement preparedStatement = con
					.prepareStatement("update Flipkart_db.SELLER_PRODUCT set PRICE=?,STOCK=?,DELIVERY_CHARGE=?,ORIGINAL_STOCK=? ,PRICE2116=? where SELLER_ID=? AND P_ID=?;");
			
			

			preparedStatement.setString(1, insertSellerProductModel.getPrice());
			preparedStatement.setInt(2, stock);
			preparedStatement.setInt(3, insertSellerProductModel.getDeliverycharge());
			preparedStatement.setInt(4,stock);
			preparedStatement.setInt(5, Integer.parseInt(insertSellerProductModel.getPrice()));

			preparedStatement.setString(6, sellerID);
			preparedStatement.setString(7, productID);
			preparedStatement.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println("Error.." + e);
		}
	}
	// InsertSellerProduct
	public void InsertSellerProduct(
			InsertSellerProductModel insertSellerProductModel)
			throws ClassNotFoundException, SQLException, IOException {
		try {
			int price=0;
			price=Integer.parseInt(insertSellerProductModel.getPrice());
			DBconnection db = new DBconnection();
			Connection con = db.createConnection();
			String sellerID = "abc", productID = "abc";
			System.out.println("item_name"
					+ insertSellerProductModel.getItem_name());
			System.out.println("item_name"
					+ insertSellerProductModel.getSeller_name());
			PreparedStatement preparedStatement1 = (PreparedStatement) con
					.prepareStatement("SELECT SELLER_ID FROM SELLER where SELLER_NAME=?");
			preparedStatement1.setString(1,
					insertSellerProductModel.getSeller_name());
			ResultSet rs = preparedStatement1.executeQuery();
			while (rs.next()) {
				sellerID = rs.getString(1);
			}
			System.out.println(" sellerid " + sellerID);
			PreparedStatement preparedStatement2 = (PreparedStatement) con
					.prepareStatement("SELECT P_ID FROM PRODUCT_INFO where P_NAME=?");
			preparedStatement2.setString(1,
					insertSellerProductModel.getItem_name());
			ResultSet rs2 = preparedStatement2.executeQuery();

			while (rs2.next()) {
				System.out.println(" productID in rs2" + rs2.getString(1));
				productID = rs2.getString(1);
			}
			System.out.println(" productID" + productID);
			PreparedStatement preparedStatement = con
					.prepareStatement("insert into SELLER_PRODUCT (SELLER_ID,P_ID,SP_ID,ORIGINAL_STOCK,PRICE,STOCK,DELIVERY_CHARGE,PRICE2116) values(?,?,?,?,?,?,?,?)");
			preparedStatement.setString(1, sellerID);
			preparedStatement.setString(2, productID);
			preparedStatement.setString(3, insertSellerProductModel.getSP_ID());
			preparedStatement.setInt(4, insertSellerProductModel.getStock());
			preparedStatement.setString(5, insertSellerProductModel.getPrice());
			preparedStatement.setInt(6, insertSellerProductModel.getStock());
			preparedStatement.setInt(7,insertSellerProductModel.getDeliverycharge());
			preparedStatement.setInt(8,price);

			preparedStatement.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println("Error.." + e);
		}
	}

	// insert mapping
	public void InsertMapping(InsertMappingModel insertMappingModel)
			throws ClassNotFoundException, SQLException, IOException {
		try {
			DBconnection db = new DBconnection();
			Connection con = db.createConnection();
			String productID = "abc", UC_ID = "abc", C_ID = "abc", SC_ID = "abc", LC_ID = "abc";
			// System.out.println("item_name" +
			// insertMappingModel.getItem_name());
			// System.out.println("item_name" +
			// insertMappingModel.getSeller_name());
			PreparedStatement preparedStatement1 = (PreparedStatement) con
					.prepareStatement("SELECT UC_ID FROM UPPER_CATEGORY where UC_NAME=?");
			preparedStatement1.setString(1, insertMappingModel.getUP_name());
			ResultSet rs = preparedStatement1.executeQuery();
			while (rs.next()) {
				UC_ID = rs.getString(1);
			}
			// System.out.println(" sellerid " + sellerID);
			PreparedStatement preparedStatement2 = (PreparedStatement) con
					.prepareStatement("SELECT P_ID FROM PRODUCT_INFO where P_NAME=?");
			preparedStatement2.setString(1, insertMappingModel.getItem_name());
			ResultSet rs2 = preparedStatement2.executeQuery();

			while (rs2.next()) {
				// System.out.println(" productID in rs2" + rs2.getString(1));
				productID = rs2.getString(1);
			}
			PreparedStatement preparedStatement3 = (PreparedStatement) con
					.prepareStatement("SELECT C_ID FROM CATEGORY where C_NAME=?");
			preparedStatement3.setString(1, insertMappingModel.getC_name());
			ResultSet rs3 = preparedStatement3.executeQuery();
			while (rs3.next()) {
				C_ID = rs3.getString(1);
			}

			PreparedStatement preparedStatement4 = (PreparedStatement) con
					.prepareStatement("SELECT SC_ID FROM SUB_CATEGORY where SC_NAME=?");
			preparedStatement4.setString(1, insertMappingModel.getSC_NAME());
			ResultSet rs4 = preparedStatement4.executeQuery();
			while (rs4.next()) {
				SC_ID = rs4.getString(1);
			}
			PreparedStatement preparedStatement5 = (PreparedStatement) con
					.prepareStatement("SELECT LC_ID FROM LAST_CATEGORY where LC_NAME=?");
			preparedStatement5.setString(1, insertMappingModel.getLC_NAME());
			ResultSet rs5 = preparedStatement5.executeQuery();
			while (rs5.next()) {
				LC_ID = rs5.getString(1);
			}

			System.out.println("up" + insertMappingModel.getUP_name());
			System.out.println("CID" + insertMappingModel.getC_name());
			System.out.println("SC" + insertMappingModel.getSC_NAME());
			System.out.println("lc" + insertMappingModel.getLC_NAME());
			System.out.println(" productID: " + productID);
			System.out.println(" UCID: " + UC_ID);
			System.out.println(" CID: " + C_ID);
			System.out.println(" SCID: " + SC_ID);
			System.out.println(" LCID: " + LC_ID);

			PreparedStatement preparedStatement = con
					.prepareStatement("insert into CATEGORY_MAPPING (P_ID,UC_ID,C_ID,SC_ID,LC_ID) values(?,?,?,?,?)");
			preparedStatement.setString(1, productID);
			preparedStatement.setString(2, UC_ID);
			preparedStatement.setString(3, C_ID);

			preparedStatement.setString(4, SC_ID);
			preparedStatement.setString(5, LC_ID);

			preparedStatement.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println("Error.." + e);
		}
	}

	// get category
	public String FetchCategory() {
		try {
			String C_ID = "ABC";
			DBconnection db = new DBconnection();
			Connection con = db.createConnection();
			int i=1;
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement("SELECT C_ID FROM Flipkart_db.CATEGORY order by  C_ID desc;");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				if(i==1)
				{C_ID = rs.getString("C_ID");}
				i++;
			}

			con.close();
			return C_ID;

		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
	
	public String FetchsSubCategory() {
		try {
			String SC_ID = "ABC";
			DBconnection db = new DBconnection();
			Connection con = db.createConnection();
			int i=1;
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement("SELECT SC_ID FROM Flipkart_db.SUB_CATEGORY order by  SC_ID desc;");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				if(i==1)
				{SC_ID = rs.getString("SC_ID");}
				i++;
			}

			con.close();
			return SC_ID;

		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
	public String FetchsUpperCategory() {
		try {
			String UP_ID = "ABC";
			DBconnection db = new DBconnection();
			Connection con = db.createConnection();
			int i=1;
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement("SELECT UC_ID FROM Flipkart_db.UPPER_CATEGORY order by  UC_ID desc;");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				if(i==1)
				{UP_ID = rs.getString("UC_ID");}
				i++;
			}

			con.close();
			return UP_ID;

		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
	
	public String FetchsLastCategory() {
		try {
			String LC_ID = "ABC";
			DBconnection db = new DBconnection();
			Connection con = db.createConnection();
			int i=1;
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement("SELECT LC_ID FROM Flipkart_db.LAST_CATEGORY order by  LC_ID desc;");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				if(i==1)
				{LC_ID = rs.getString("LC_ID");}
				i++;
			}

			con.close();
			return LC_ID;

		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
	
	
	public String FetchPid(){
		try {
			String P_ID = "ABC";
			DBconnection db = new DBconnection();
			Connection con = db.createConnection();
			int i=1;
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement("SELECT P_ID FROM Flipkart_db.PRODUCT_INFO order by  P_ID desc");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				if(i==1)
				{P_ID = rs.getString("P_ID");}
				i++;
			}

			con.close();
			return P_ID;

		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
	public String FetchsSPid(){
		try {
			String SP_ID = "ABC";
			DBconnection db = new DBconnection();
			Connection con = db.createConnection();
			int i=1;
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement("SELECT SP_ID FROM Flipkart_db.SELLER_PRODUCT order by  SP_ID desc");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				if(i==1)
				{SP_ID = rs.getString("SP_ID");}
				i++;
			}

			con.close();
			return SP_ID;
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
	public String FetchsSellerid(){
		try {
			String SELLER_ID = "ABC";
			DBconnection db = new DBconnection();
			Connection con = db.createConnection();
			int i=1;
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement("SELECT SELLER_ID FROM Flipkart_db.SELLER order by  SELLER_ID desc;");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				if(i==1)
				{SELLER_ID = rs.getString("SELLER_ID");}
				i++;
			}

			con.close();
			return SELLER_ID;
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
	public void updateSellerInfo(Usermodel usermodel,String uid)
			throws ClassNotFoundException, SQLException, IOException {
		try {
		
		//	String uid="S001";
		//String uid=(String) session.get("mail");
			System.out.println("in side update sellerinfo");
			DBconnection db = new DBconnection();
			Connection con = db.createConnection();
			PreparedStatement preparedStatement = con
					.prepareStatement("UPDATE Flipkart_db.CREDENTIAL SET PASSWORD=? WHERE U_ID=?");
			preparedStatement.setString(1,usermodel.getPassword());
			preparedStatement.setString(2, uid);
			preparedStatement.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println("Error.." + e);
		}
	}

	
	public void statusUpdate(Usermodel usermodel, String uid) throws SQLException {
		// TODO Auto-generated method stub
	ArrayList<Integer> arra1=new ArrayList<Integer>();
		DBconnection db = new DBconnection();
		Connection con = db.createConnection();
		try{
		PreparedStatement ps = (PreparedStatement) con
				.prepareStatement("SELECT ORDER_ID FROM SELLER_ACC  WHERE S_ID=? AND AMOUNT = 0");
		ps.setString(1, uid);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			arra1.add(rs.getInt("ORDER_ID"));
		}
		
		usermodel.setArr( arra1);
		}
		catch (Exception e) {
			System.out.println("Error.." + e);
		}
	}

	public void Insertstatus(Usermodel usermodel)throws ClassNotFoundException, SQLException, IOException {
		try {
			DBconnection db = new DBconnection();
			Connection con = db.createConnection();
			
			PreparedStatement preparedStatement = con
					.prepareStatement("UPDATE Flipkart_db.TRACK_ORDER SET STATUS=? WHERE ORDER_ID=?");
			preparedStatement.setString(1,usermodel.getStatus1());
			preparedStatement.setInt(2,usermodel.getSelectarr());
			preparedStatement.executeUpdate();
			con.close();

		} catch (Exception e) {
			System.out.println("Error.." + e);
		}


	}

	public ArrayList<String> fetchProduct() {
		// TODO Auto-generated method stub
		DBconnection db = new DBconnection();
		Connection con = db.createConnection();
		ArrayList<String> product=new ArrayList<String>();
		try {
			PreparedStatement ps = con
					.prepareStatement("select P_ID from PRODUCT_INFO");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				product.add(rs.getString(1));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return product;
	}

	public void insertOfferProduct() {
		// TODO Auto-generated method stub
		DBconnection db = new DBconnection();
		Connection con = db.createConnection();
		Usermodel um=new Usermodel();
		try {
			PreparedStatement ps = con
					.prepareStatement("insert into B2G1FREE FREE_ID values(?)");
			ps.setString(1,um.getOffer_name());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void insertProduct() {
		// TODO Auto-generated method stub
		DBconnection db = new DBconnection();
		Connection con = db.createConnection();
		Usermodel um=new Usermodel();
		try {
			PreparedStatement ps = con
					.prepareStatement("insert into B2G1FREE P_ID values(?)");
			ps.setString(1,um.getOffer_Product());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
//end
}
