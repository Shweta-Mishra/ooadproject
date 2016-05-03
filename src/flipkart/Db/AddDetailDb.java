package flipkart.Db;

import java.sql.SQLException;
import java.util.ArrayList;

import flipkart.Model.ProductDescriptionModel;

import com.mysql.jdbc.PreparedStatement;

import flipkart.Model.AddDetailModel;

public class AddDetailDb {
	
	
	public int LoginDetail(AddDetailModel addDetailModel) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		DBconnection db = new DBconnection();
		java.sql.Connection con = db.createConnection();
		System.out.println("succsess is checked");
		String mail = addDetailModel.getEmail();
		System.out.println("mail for authentiacation"+mail);
		String Password  = addDetailModel.getPassword();
		System.out.println("password for authentiacation"+addDetailModel.getPassword());
		String sql = "Select U_ID , PASSWORD from CREDENTIAL where U_ID = '"+mail+"'";
		PreparedStatement ps1 = (PreparedStatement) con.prepareStatement(sql);
		java.sql.ResultSet rs = ps1.executeQuery();
		if(rs.next()){
			System.out.println("succsess is checked");
			if(Password.equals(rs.getString(2))){
				System.out.println("succsess is checked");
				return 1;
			}
		}

		return 0;
	}

}
