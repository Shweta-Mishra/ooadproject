package flipkart.Db;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


import com.mysql.jdbc.Statement;

import flipkart.Model.Usermodel;

import com.mysql.jdbc.Statement;







public class DBhandlerForAccount_Setting {
	
		
	public void fetchdetails(Usermodel usr) throws FileNotFoundException
	{
			try {
				DBconnection db=new DBconnection ();	
				Connection con=db.createConnection();	
			String sql;
			sql = "select F_NAME,L_NAME,MOBILE,LANDLINE,GENDER from Flipkart_db.CREDENTIAL where U_ID=?";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setString(1, usr.getUid());
			ResultSet rs = stmt.executeQuery();
			rs.next();
		    usr.setFirstname(rs.getString(1));
		    usr.setLastname(rs.getString(2));
		    usr.setMobno(rs.getString(3));
			usr.setLandlineno(rs.getString(4));
			usr.setGender(rs.getString(5));		
			con.close();
				}catch (Exception e) 
				  { 
			    System.out.println("Error.."+e);
			      }
   }


		
			
	public void updatedetails(Usermodel usr) throws FileNotFoundException
	   {
			     DBconnection db=new DBconnection();	
			     Connection con=db.createConnection();
	String query2 = "UPDATE Flipkart_db.CREDENTIAL SET F_NAME =?,L_NAME =?,MOBILE =?,LANDLINE =?,GENDER=? WHERE U_ID=?";
			
			try 
			{
			   PreparedStatement stmt = (PreparedStatement)con.prepareStatement(query2);
			   stmt.setString(6,usr.getUid());
				stmt.setString(1,usr.getFirstname());
				stmt.setString(2,usr.getLastname());
				stmt.setString(3,usr.getMobno());
				stmt.setString(4,usr.getLandlineno());
				stmt.setString(5,usr.getGender());
			    stmt.executeUpdate();
				con.close();		}catch(Exception ex)
				{
					System.out.println(""+ex);
					
				}
	   }
	public boolean chkForEmailIDAlreadyExists(Usermodel usr) throws SQLException
	{
		
		
		DBconnection db=new DBconnection();
		Connection con = db.createConnection();
		String query="select U_ID from Flipkart_db.CREDENTIAL";
		PreparedStatement stmt=con.prepareStatement(query);
		stmt.setString(1, usr.getUid());
		ResultSet rs = stmt.executeQuery();
		//ResultSet rs=db.executeQuery(query);
		while(rs.next())
		{
			if(rs.getString("uid").equals(usr.getUid()))
			{
				con.close();
				return true;
			}
		}	con.close();
		return false;
	}
	
	public String chkForEmailID_PasswordAlreadyExists(Usermodel usr) throws SQLException 
	{
		DBconnection db= new DBconnection();
		Connection con = db.createConnection();
		String role=null;
		String query="select U_ID,PASSWORD,ROLE from  Flipkart_db.CREDENTIAL";
		PreparedStatement stmt=con.prepareStatement(query);
		stmt.setString(1, usr.getUid());
		ResultSet rs = stmt.executeQuery();
		while(rs.next())
		{
			if(rs.getString("uid").equals(usr.getUid())&&rs.getString("password").equals(usr.getPassword()))
				role=rs.getString("role");
		}
		if (role==null)
		{
			return "invalid";
		}
		con.close();
		return role;
			
	}
				
		/*public void getpass(Loginmodel user) throws  FileNotFoundException, SQLException
		
		{
			try
			{
			// TODO Auto-generated method stub
			DBconnection db=new DBconnection();	
			Connection con = db.createConnection();
			
			String query="select PASSWORD from FlipKart.CREDENTIAL where U_ID=?";
			PreparedStatement stmt=con.prepareStatement(query);
			stmt.setString(1, user.getUid());
			ResultSet rs=stmt.executeQuery();
			
			rs.next();
			user.setPassword(rs.getString(1));
			System.out.println(rs.getString(1));
			
			
		}	
		catch(Exception e) { 
		    System.out.println("Error.."+e);
		}
		
	}*/

		public void changepassword(Usermodel usr) throws FileNotFoundException
		{
			DBconnection db=new DBconnection();	
			Connection con=db.createConnection();	
	       String query2 = "UPDATE Flipkart_db.CREDENTIAL SET PASSWORD =? WHERE U_ID=?";
	       try {
			     PreparedStatement stmt = (PreparedStatement)con.prepareStatement(query2);
			     stmt.setString(2,usr.getUid());
				 stmt.setString(1,usr.getPassword());
			     stmt.executeUpdate();
			 	con.close();  }catch(Exception ex)
				{
					System.out.println(""+ex);
			    }
		}
		
		
		
      public void changemail(Usermodel usr) throws FileNotFoundException
      {
			DBconnection db=new DBconnection();	
			Connection con=db.createConnection();
			String query2 = "UPDATE Flipkart_db.CREDENTIAL SET U_ID =? WHERE U_ID=?";
		try {
	           PreparedStatement stmt = (PreparedStatement)con.prepareStatement(query2);
			   stmt.setString(1,usr.getNewemail());
			   stmt.setString(2,usr.getUid());
			   stmt.executeUpdate();
			   
				con.close(); }catch(Exception ex)
				{
					System.out.println(""+ex);
	            }
	  }
		
      
      public void deactivateAccount(Usermodel user) throws SQLException 
      {
    	    DBconnection db = new DBconnection();
			Connection con = db.createConnection();
			try{
			String sql = "DELETE FROM Flipkart_db.CREDENTIAL WHERE U_ID =?";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setString(1, user.getUid());
			stmt.executeUpdate();
			}catch(Exception ex)
			{
				System.out.println(""+ex);
				
			}
			con.close();
      }
			
			
			
			
			
public void fetchaddress(Usermodel usr) throws FileNotFoundException
		{
			try {
				DBconnection db=new DBconnection ();	
				Connection con=db.createConnection();	
		        String sql;
			    sql = "select F_NAME,ADDRESS,CITY,PINCODE,PHONE_NO from Flipkart_db.DELIVERY_DETAILS,Flipkart_db.CREDENTIAL where CREDENTIAL.U_ID= DELIVERY_DETAILS.U_ID AND Flipkart_db.CREDENTIAL.U_ID=?";
			    PreparedStatement stmt=con.prepareStatement(sql);
				stmt.setString(1, usr.getUid());
			    ResultSet rs = stmt.executeQuery();
				rs.next();
				usr.setFirstname(rs.getString(1));
				usr.setAddress(rs.getString(2));
				System.out.println(rs.getString(2));
				usr.setCity(rs.getString(3));	
				usr.setPincode(rs.getString(4));
				System.out.println(rs.getString(4));
				usr.setPhoneno(rs.getString(5));
				System.out.println(rs.getString(5));
				con.close();   
				}catch (Exception e) { 
			    System.out.println("Error.."+e);
			                         }
		
		}
		
	
	public void updateaddress(Usermodel user) throws SQLException
		{
		try
		{
			DBconnection db=new DBconnection();
			Connection con=db.createConnection();

			String query1="UPDATE Flipkart_db.DELIVERY_DETAILS,Flipkart_db.CREDENTIAL SET F_NAME =?,PHONE_NO =?,ADDRESS =?,PINCODE =?,CITY =? WHERE Flipkart_db.CREDENTIAL.U_ID=?";
			PreparedStatement prep =con.prepareStatement(query1);
			
		    prep.setString(6,user.getUid());
			prep.setString(1, user.getFirstname());
			prep.setString(2, user.getPhoneno());
			prep.setString(3, user.getAddress());
			prep.setString(4, user.getPincode());
			prep.setString(5,user.getCity());
			prep.executeUpdate();
			con.close();	}catch (Exception e) { 
		    System.out.println("Error.."+e);
		                     }
		
		}

	
public ArrayList<Usermodel> getNotificationData(Usermodel usr)throws SQLException 
	
	{
		
		Usermodel user;

			DBconnection db=new DBconnection();
			Connection con=db.createConnection();
			ArrayList<Usermodel> notification = new ArrayList<Usermodel>();
			String sql = "Select ORDER_ID,STATUS,APPROVE_DATE,DELIVERY_DATE From Flipkart_db.TRACK_ORDER Where U_ID = ? Order By DELIVERY_DATE,APPROVE_DATE desc";
			System.out.println(sql);
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setString(1, usr.getUid());
			System.out.println(usr.getUid());
		    ResultSet rs = stmt.executeQuery();
		   
		    Date date1 = new Date();
			
			Calendar cal1 = Calendar.getInstance();
			Calendar cal2 = Calendar.getInstance();
			Calendar cal3 = Calendar.getInstance();
               cal1.setTime(date1);
			while(rs.next())
			{
			
			user=new Usermodel();
			Date date2 = rs.getDate("APPROVE_DATE");
			Date date3 = rs.getDate("DELIVERY_DATE");
			
			
			cal2.setTime(date2);
			cal3.setTime(date3);
			long diff_in_days1 = ( (cal1.getTimeInMillis() - cal2.getTimeInMillis() ) / (24 * 60 * 60 * 1000) );
			long diff_in_days2 = ( (cal1.getTimeInMillis() - cal3.getTimeInMillis() ) / (24 * 60 * 60 * 1000) );
			user.setOrderid(rs.getInt("ORDER_ID"));
		
			System.out.println(rs.getInt("ORDER_ID"));
		    user.setStatus(rs.getString("STATUS"));
			System.out.println(rs.getString("STATUS"));
			 //user.setOrder_date(rs.getDate("APPROVE_DATE"));
			 //user.setDelievry_date(rs.getDate("DELIVERY_DATE"));
			
			//usr.setMessage("available");
		   if(rs.getString("STATUS").equals("PLACED") || rs.getString("STATUS").equals("DISPATCHED") )
		    {
		    	user.setDays_ago(diff_in_days1);
		    }
		    
		    else
		    {
		    	user.setDays_ago(diff_in_days2);
		    }
			

			notification.add(user);
			
			
			}
			System.out.println("helloNotification");
			//int van=notification.size();
			//usr.setVan(notification.size());
			
			System.out.println(notification.size());
			if(notification.isEmpty())
			    {
				
				usr.setMessage("true");
				}
			else usr.setMessage("false");
			return notification;
			
	}

	}

		

