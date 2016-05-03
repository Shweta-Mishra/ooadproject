package flipkart.Db;

import java.sql.*;

import flipkart.Model.SignupModel;

//import flipkart.DB.*;
//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.Statement;
//import java.sql.Connection;


public class DBHandlerLogin {

	DBconnection dbc = new DBconnection();
	Connection con = dbc.createConnection();
	
	
	
	// Add user on signup
	public String AddUser(SignupModel sm) throws Exception
	{
		String query = "INSERT INTO CREDENTIAL(U_ID,F_NAME,PASSWORD,ROLE,L_NAME,MOBILE,LANDLINE,GENDER) VALUES(?,?,?,?,?,?,?,?)";
		//String query2 = "INSERT INTO DELIVERY_DETAILS(U_ID,D_NAME,ADDRESS,CITY,STATE,PINCODE,PHONE_NO) VALUES(?,?,?,?,?,?,?)" ;
		PreparedStatement prep1 =con.prepareStatement(query);
		//PreparedStatement prep2 =con.prepareStatement(query2);
		
		prep1.setString(1, sm.getEmail());
		prep1.setString(2,sm.getFname());
		prep1.setString(3,sm.getPassword());
		prep1.setString(4,sm.getRole());
		prep1.setString(5,sm.getLname());
		prep1.setString(6,sm.getMobile());
		prep1.setString(7,sm.getLandline());
		prep1.setString(8,sm.getGender());
		
		//Insertion into delivery details
		/*
		prep2.setString(1, sm.getEmail());
		prep2.setString(2,sm.getFname());
		prep2.setString(3,sm.getAddress());
		prep2.setString(4,sm.getCity());
		prep2.setString(5,sm.getState());
		prep2.setString(6,sm.getPincode());
		prep2.executeUpdate();
		*/
		int k=prep1.executeUpdate();
		
		if(k==1)
		{
			
			return "user";
		}
	else
		return "error";
	}

	
	// Check email as U_ID and password, if matches then return role else wrong email or pass  
	public String getFname(String email, String password) throws Exception{
		String fname = null;
		Statement st =null ;
		String str1 = "wrong";
		int flag=0;
		//Statement stmt = (Statement) dbc;
			st =  con.createStatement();
		
		String sql = "SELECT U_ID,F_NAME,PASSWORD FROM CREDENTIAL";
		
	
		ResultSet rs = null;
			rs = st.executeQuery(sql);
			
		while(rs.next())
		{
			if(rs.getString("U_ID").equals(email) && rs.getString("PASSWORD").equals(password))
			{
				fname=rs.getString("F_NAME");
				flag = 1;
				
				
			}
		}
		if(flag==1)
			return fname;
		else
		
			return str1;
	}

	
	
	// Check for email already exist and return invalid else return valid  
	
	public String  CheckForU_IDAlreadyExist(String email) throws Exception
	{
		String Exist = "valid";

		String query="SELECT U_ID FROM CREDENTIAL";
		Statement stmt = null;
		stmt =  con.createStatement();
		ResultSet rs=stmt.executeQuery(query);
		while(rs.next())
		{
			if(rs.getString("U_ID").equals(email))
				Exist="invalid";
		}
		
		return Exist;	
	}
	
	public String CheckU_ID(String email)
	{
		String User_ID = null;
		
		
		return User_ID;
	}
	public String getRole(String email) throws SQLException 
	{
		
		String role=null;
		String query="SELECT U_ID,ROLE FROM CREDENTIAL";
		Statement stmt = con.createStatement();
		ResultSet rs=stmt.executeQuery(query);
		while(rs.next())
		{
			if(rs.getString("U_ID").equals(email))
				role=rs.getString("ROLE");
		}
		if (role==null)
		{
			return "invalid";
		}
		return role;
			
	}
	
	public String checkUser_ID(String email) throws SQLException
	{
		// TODO Auto-generated method stub
		Statement stmt = (Statement) dbc;
		String query="SELECT U_ID, FROM CREDENTIAL";
		ResultSet rs = stmt.executeQuery(query);
		String userId=null;
		while(rs.next())
		{
			if(rs.getString("U_ID").equals(email))
			{
				userId=rs.getString("U_ID");
		
			}
		}
		return userId;
	}	

	
	
}
