package flipkart.Db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import flipkart.Model.ShowcategoryModel;
import flipkart.Model.TrackOrderModel;

public class DBHofTrackorder {
public ArrayList<TrackOrderModel> trackOrder(){
	ArrayList<TrackOrderModel> TL=new ArrayList<TrackOrderModel>();
	
	
	try
	{
		int i=0; 
		System.out.println("m in dbhandler");
		DBconnection db=new DBconnection();
		Connection con= db.createConnection();
		Map<String,Object> session=ActionContext.getContext().getSession();
		String uid=(String)session.get("email");
		PreparedStatement ps= (PreparedStatement) con.prepareStatement("select T.ORDER_ID,T.APPROVE_DATE,T.TOTAL,T.SP_ID,SP.P_ID,SP.PRICE,SP.SELLER_ID, S.SELLER_NAME ,P_NAME,T.STATUS from TRACK_ORDER as T,Flipkart_db.SELLER_PRODUCT as SP, SELLER as S,PRODUCT_INFO where T.U_ID=? and T.SP_ID=SP.SP_ID and SP.SELLER_ID=S.SELLER_ID and SP.P_ID=PRODUCT_INFO.P_ID;");
		ps.setString(1,uid);
		ResultSet rs= ps.executeQuery();
		
		while(rs.next())
		{
			System.out.println("m in rs.next");
			TrackOrderModel tm=new TrackOrderModel();
			System.out.println("in while "+rs.getString(1));
			tm.setOrder_Id(rs.getInt(1));
			tm.setApprove_Date(rs.getDate(2));
			tm.setTotal(rs.getInt(3));
			tm.setSP_ID(rs.getString(4));
			tm.setPrice(rs.getString(6));
			tm.setSeller_name(rs.getString(8));
			tm.setProduct_Name(rs.getString(9));
			tm.setStatus(rs.getString(10));
			
			
			TL.add(i, tm);
			System.out.println(TL.get(i).getOrder_Id());
			i++;
		}
		

	}

	catch(Exception e)
	{
		e.printStackTrace();
	}
		return TL;
	
	}


public ArrayList <TrackOrderModel> orderDetail( int orderid){
	ArrayList<TrackOrderModel> DL=new ArrayList<TrackOrderModel>();
	try
	{
		int i=0;
		
		System.out.println("m in dbhandler orderdetail and orderid="+orderid);
		DBconnection db=new DBconnection();
		Connection con= db.createConnection();
		PreparedStatement ps= (PreparedStatement) con.prepareStatement("SELECT DISTINCT(D_NAME),ADDRESS FROM Flipkart_db.DELIVERY_DETAILS WHERE D_NAME IS NOT NULL AND ADDRESS IS NOT NULL AND U_ID=(SELECT U_ID FROM TRACK_ORDER WHERE ORDER_ID=?)");
	//	PreparedStatement ps1= (PreparedStatement) con.prepareStatement("Insert into SELLER_PRODUCT values('S002','P003','SP003',50000,3,'10')");
		ps.setInt(1,orderid);
	
		PreparedStatement ps1= (PreparedStatement) con.prepareStatement("select T.APPROVE_DATE,T.TOTAL,T.STATUS,P.P_IMAGE,P.P_DESCRIPTION,P.P_NAME from Flipkart_db.TRACK_ORDER as T,Flipkart_db.SELLER_PRODUCT as SP,Flipkart_db.PRODUCT_INFO as P where T.ORDER_ID=? and T.SP_ID=SP.SP_ID and SP.P_ID=P.P_ID");
		ps1.setInt(1,orderid);
		ResultSet rs= ps.executeQuery();
		ResultSet rs1= ps1.executeQuery();
	//	ps1.executeUpdate();
		rs.next();
		rs1.next();
		//	System.out.println("inside while loop");
			TrackOrderModel tm1=new TrackOrderModel();
			tm1.setOI(orderid);
			tm1.setApprove_Date(rs1.getDate(1));
			tm1.setTotal(rs1.getInt(2));
			tm1.setStatus(rs1.getString(3));
			tm1.setDestpath(rs1.getString(4));
			tm1.setDescription(rs1.getString(5));
			tm1.setProduct_Name(rs1.getString(6));
			tm1.setAddress(rs.getString(2));
			tm1.setD_Name(rs.getString(1));
			String p="images/"+tm1.getDestpath();
			tm1.setDestpath(p);
			DL.add(tm1);
		//	System.out.println("m in while of orderdetails"+DL.get(i).getProduct_Name());
			
		
	
		
	
	
}

	catch(Exception e)
	{
		e.printStackTrace();
	}
		return DL;
	

}

public void CancelOrder( String orderid){
	
	
	try
	{
		int stock=0;
		int su=0,qty=0;
		System.out.println("m in dbhandler of cancelorder");
		DBconnection db=new DBconnection();
		Connection con= db.createConnection();
		PreparedStatement ps= (PreparedStatement) con.prepareStatement("update Flipkart_db.TRACK_ORDER set STATUS='cancelled' where ORDER_ID=? ");
		PreparedStatement ps1= (PreparedStatement) con.prepareStatement("select sp.STOCK,t.QTY from Flipkart_db.SELLER_PRODUCT sp,Flipkart_db.TRACK_ORDER as t where t.ORDER_ID=? and t.U_ID='U001' and t.SP_ID=sp.SP_ID");
		
		ps.setString(1,orderid);
		ps1.setString(1, orderid);
		ps.executeUpdate();
		ResultSet rs=ps1.executeQuery();
		while(rs.next()){
		 stock=rs.getInt(1);
		 qty=rs.getInt(2);
		}
		su=stock+qty;
		
		PreparedStatement ps2=(PreparedStatement) con.prepareStatement("update Flipkart_db.SELLER_PRODUCT,Flipkart_db.TRACK_ORDER set Flipkart_db.SELLER_PRODUCT.STOCK='"+su+"' where Flipkart_db.TRACK_ORDER.ORDER_ID=? and U_ID='U001' and Flipkart_db.TRACK_ORDER.SP_ID=Flipkart_db.SELLER_PRODUCT.SP_ID");
		ps2.setString(1, orderid);
		ps2.executeUpdate();
		//ps2.setString(2, x);
	}
	
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
}


public ArrayList<String> Fetchcategory(ShowcategoryModel SM) {
	ArrayList<String>fetchcat=new ArrayList<String>();
	try{
		System.out.println("m in dbhandler of fetchcat="+SM.getSupercatg());
		DBconnection db=new DBconnection();
		Connection con= db.createConnection();
		PreparedStatement ps= (PreparedStatement) con.prepareStatement("select C.C_NAME from Flipkart_db.CATEGORY C where C.C_ID in(select CM.C_ID from Flipkart_db.CATEGORY_MAPPING CM where CM.UC_ID in (select UC.UC_ID from Flipkart_db.UPPER_CATEGORY UC where UC.UC_NAME=?)) ;");
		ps.setString(1,SM.getSupercatg());
		ResultSet rs= ps.executeQuery();
		while(rs.next())
		{
		//SM.setFetchcat(rs.getString(1));
		fetchcat.add(rs.getString(1));		
		System.out.println("m in while of "+rs.getString(1));
		}
	
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
			return fetchcat;
		
}


public void RecievedOrder(String orderid) {
	// TODO Auto-generated method stub
	try
	{
		
		System.out.println("m in dbhandler of cancelorder");
		DBconnection db=new DBconnection();
		Connection con= db.createConnection();
		PreparedStatement ps= (PreparedStatement) con.prepareStatement("update Flipkart_db.TRACK_ORDER set STATUS='Recieved' where ORDER_ID=? ");
		ps.setString(1,orderid);
		ps.executeUpdate();
		PreparedStatement ps2= (PreparedStatement) con.prepareStatement("select TOTAL from Flipkart_db.TRACK_ORDER where ORDER_ID='"+orderid+"' ");
		ResultSet rs= ps2.executeQuery();
		while(rs.next()){
		PreparedStatement ps1= (PreparedStatement) con.prepareStatement("update Flipkart_db.SELLER_ACC set AMOUNT=? where ORDER_ID='"+orderid+"' ");
		ps1.setString(1,rs.getString(1));
	//	ps1.setString(2, orderid);
		ps1.executeUpdate();}
	}
	
		catch(Exception e)
		{
			e.printStackTrace();
		}
}

















}/*package flipkart.Db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import flipkart.Model.ShowcategoryModel;
import flipkart.Model.TrackOrderModel;

public class DBHofTrackorder {
public ArrayList<TrackOrderModel> trackOrder(){
	ArrayList<TrackOrderModel> TL=new ArrayList<TrackOrderModel>();
	
	
	try
	{
		int i=0; 
		System.out.println("m in dbhandler");
		DBconnection db=new DBconnection();
		Connection con= db.createConnection();
		Map<String, Object> session = ActionContext.getContext().getSession();
		String uid=(String)session.get("email");
		System.out.println(uid+"t");
		PreparedStatement ps= (PreparedStatement) con.prepareStatement("select T.ORDER_ID,T.APPROVE_DATE,T.TOTAL,T.SP_ID,SP.P_ID,SP.PRICE,SP.SELLER_ID, S.SELLER_NAME ,P_NAME,T.STATUS from TRACK_ORDER as T,SELLER_PRODUCT as SP, SELLER as S,PRODUCT_INFO where T.U_ID=? and T.SP_ID=SP.SP_ID and SP.SELLER_ID=S.SELLER_ID and SP.P_ID=PRODUCT_INFO.P_ID;");
		ps.setString(1,uid);
		ResultSet rs= ps.executeQuery();
		
		while(rs.next())
		{
			System.out.println("m in rs.next");
			TrackOrderModel tm=new TrackOrderModel();
			System.out.println("in while "+rs.getString(1));
			tm.setOrder_Id(rs.getInt(1));
			tm.setApprove_Date(rs.getDate(2));
			tm.setTotal(rs.getInt(3));
			tm.setSP_ID(rs.getString(4));
			tm.setPrice(rs.getString(6));
			tm.setSeller_name(rs.getString(8));
			tm.setProduct_Name(rs.getString(9));
			tm.setStatus(rs.getString(10));
			TL.add(i, tm);
			System.out.println(TL.get(i).getOrder_Id());
			i++;
		}
		
		con.close();
	}

	catch(Exception e)
	{
		e.printStackTrace();
	}
		return TL;
	
	}


public ArrayList <TrackOrderModel> orderDetail( int orderid){
	ArrayList<TrackOrderModel> DL=new ArrayList<TrackOrderModel>();
	try
	{
		int i=0;
		
		System.out.println("m in dbhandler orderdetail and orderid="+orderid);
		DBconnection db=new DBconnection();
		Connection con= db.createConnection();
		PreparedStatement ps= (PreparedStatement) con.prepareStatement("select T.APPROVE_DATE,T.TOTAL,T.STATUS,P.P_IMAGE,P.P_DESCRIPTION,P.P_NAME,D.ADDRESS from Flipkart_db.DELIVERY_DETAILS D,Flipkart_db.TRACK_ORDER as T,Flipkart_db.SELLER_PRODUCT as SP,Flipkart_db.PRODUCT_INFO as P where T.ORDER_ID=? and T.SP_ID=SP.SP_ID and SP.P_ID=P.P_ID and D.U_ID=T.U_ID;");
		ps.setInt(1,orderid);
		ResultSet rs= ps.executeQuery();
		System.out.println("before while loop");

		while(rs.next())
		{
			System.out.println("inside while loop");
			TrackOrderModel tm1=new TrackOrderModel();
			tm1.setOI(orderid);
			tm1.setApprove_Date(rs.getDate(1));
			tm1.setTotal(rs.getInt(2));
			tm1.setStatus(rs.getString(3));
			tm1.setDestpath(rs.getString(4));
			tm1.setDescription(rs.getString(5));
			tm1.setProduct_Name(rs.getString(6));
			tm1.setAddress(rs.getString(7));
			//tm1.setD_Name(rs.getString(8));
			String p=tm1.getDestpath();
			System.out.println("image in db:"+p);
			tm1.setDestpath(p);
			DL.add(i,tm1);
			System.out.println("m in while of orderdetails"+DL.get(i).getProduct_Name());
			i++;
		}
	
		con.close();
	
	
}

	catch(Exception e)
	{
		e.printStackTrace();
	}
		return DL;
	

}

public void CancelOrder( String orderid){
	
	
	try
	{
		int stock=0;
		int su=0,qty=0;
		System.out.println("m in dbhandler of cancelorder");
		DBconnection db=new DBconnection();
		Connection con= db.createConnection();
		PreparedStatement ps= (PreparedStatement) con.prepareStatement("update TRACK_ORDER set STATUS='cancelled' where ORDER_ID=? ");
		PreparedStatement ps1= (PreparedStatement) con.prepareStatement("select sp.STOCK,t.QTY from SELLER_PRODUCT sp,TRACK_ORDER as t where t.ORDER_ID=? and t.U_ID='U001' and t.SP_ID=sp.SP_ID");
		
		ps.setString(1,orderid);
		ps1.setString(1, orderid);
		ps.executeUpdate();
		ResultSet rs=ps1.executeQuery();
		while(rs.next()){
		 stock=rs.getInt(1);
		 qty=rs.getInt(2);
		}
		su=stock+qty;
		
		PreparedStatement ps2=(PreparedStatement) con.prepareStatement("update SELLER_PRODUCT,TRACK_ORDER set SELLER_PRODUCT.STOCK='"+su+"' where TRACK_ORDER.ORDER_ID=? and U_ID='U001' and TRACK_ORDER.SP_ID=SELLER_PRODUCT.SP_ID");
		ps2.setString(1, orderid);
		ps2.executeUpdate();
		//ps2.setString(2, x);
		con.close();	}
	
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
}


public ArrayList<String> Fetchcategory(ShowcategoryModel SM) {
	ArrayList<String>fetchcat=new ArrayList<String>();
	try{
		System.out.println("m in dbhandler of fetchcat="+SM.getSupercatg());
		DBconnection db=new DBconnection();
		Connection con= db.createConnection();
		PreparedStatement ps= (PreparedStatement) con.prepareStatement("select C.C_NAME from CATEGORY C where C.C_ID in(select CM.C_ID from CATEGORY_MAPPING CM where CM.UC_ID in (select UC.UC_ID from UPPER_CATEGORY UC where UC.UC_NAME=?)) ;");
		ps.setString(1,SM.getSupercatg());
		ResultSet rs= ps.executeQuery();
		while(rs.next())
		{
		//SM.setFetchcat(rs.getString(1));
		fetchcat.add(rs.getString(1));		
		System.out.println("m in while of "+rs.getString(1));
		}
	
		con.close();}
		catch(Exception e)
		{
			e.printStackTrace();
		}
			return fetchcat;
		
}


public void RecievedOrder(String orderid) {
	// TODO Auto-generated method stub
	try
	{
		
		System.out.println("m in dbhandler of cancelorder");
		DBconnection db=new DBconnection();
		Connection con= db.createConnection();
		PreparedStatement ps= (PreparedStatement) con.prepareStatement("update TRACK_ORDER set STATUS='Recieved' where ORDER_ID=? ");
		ps.setString(1,orderid);
		ps.executeUpdate();
		con.close();}
	
		catch(Exception e)
		{
			e.printStackTrace();
		}
}

















}
*/