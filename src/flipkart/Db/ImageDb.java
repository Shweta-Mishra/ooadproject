package flipkart.Db;
import java.sql.SQLException;
import java.util.ArrayList;

import flipkart.Model.ProductDescriptionModel;

import com.mysql.jdbc.PreparedStatement;

public class ImageDb {
	public int mainImage(ProductDescriptionModel prodModel, String pid) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		int i = 1;
		
		DBconnection db = new DBconnection();
		java.sql.Connection con = db.createConnection();
		
		String sql = "select P_IMAGE from PRODUCT_INFO WHERE P_ID='"+pid+"'";
		PreparedStatement ps1 = (PreparedStatement) con.prepareStatement(sql);
		java.sql.ResultSet rs = ps1.executeQuery();
		while(rs.next()){
			prodModel.setDestpath(rs.getString("P_IMAGE"));
		}
		return i;
	}

	public ArrayList<ProductDescriptionModel> smallImage(ProductDescriptionModel prodModel,
			String pid) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		int i = 1;
		ArrayList<ProductDescriptionModel> im=new ArrayList<ProductDescriptionModel>();
		DBconnection db = new DBconnection();
		java.sql.Connection con = db.createConnection();
		System.out.println("are load mat le");
		String sql = "select IMAGE from IMAGE WHERE P_ID='"+pid+"'";
		PreparedStatement ps1 = (PreparedStatement) con.prepareStatement(sql);
		java.sql.ResultSet rs = ps1.executeQuery();
		while(rs.next()){
			ProductDescriptionModel fetchImage = new ProductDescriptionModel();
			String str;
			fetchImage.setDestpath("image/"+rs.getString("IMAGE"));
			str = "image/"+rs.getString(1);
			System.out.println(str);
			System.out.println("hello I am Here");
			im.add(fetchImage);
		}
		return im;
	}
}
