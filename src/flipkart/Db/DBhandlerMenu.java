package flipkart.Db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import flipkart.Model.MenuModel;


public class DBhandlerMenu {
	ArrayList<MenuModel>fetchUppercategory =new ArrayList<MenuModel>();
	ArrayList<String>category =new ArrayList<String>();
	public ArrayList<MenuModel> fetchUpperCategory(){
	try
	{
		//private Map<String,List<String>>col =new HashMap<String,List<String>>(1);
		DBconnection db=new DBconnection();
		Connection con= db.createConnection();
		PreparedStatement ps= con.prepareStatement("select UC_ID,UC_NAME from UPPER_CATEGORY ;");
		ResultSet rs= ps.executeQuery();
		int j=0;int i=0;
		while(rs.next())
		{
		MenuModel mm=new MenuModel();
		mm.setId(rs.getString(1));
		mm.setName(rs.getString(2));
		/*mm.setPmane(rs.getString(2));*/
		PreparedStatement ps1= con.prepareStatement("select distinct cm.UC_ID,c.C_NAME from CATEGORY c,CATEGORY_MAPPING cm where c.C_ID=cm.C_ID and UC_ID=?;");
		ps1.setString(1, rs.getString(1));
		ResultSet rs1= ps1.executeQuery();
		System.out.println("after rs1");
		String cname;
		
		while(rs1.next()){
			MenuModel mm1=new MenuModel();
			cname=(rs1.getString(2));
		mm.setCid((rs.getString(1)));
		category.add(i,cname);
		System.out.println(category.get(i));	
		//mm1.setCategory(category);
		i++;//
		
		}
		mm.setCategory(category);
		//System.out.println(category);	
		fetchUppercategory.add(j,mm);
		//System.out.println(fetchUppercategory.get(j).getCategory().get(0));
		j++;
		}
		

	}

	catch(Exception e)
	{
		e.printStackTrace();
	}
		return fetchUppercategory;
	
	}

	ArrayList<MenuModel>fetchcategory =new ArrayList<MenuModel>();
	public ArrayList<MenuModel> fetchCategory(String uid){
	try
	{
		int i=0;
		DBconnection db=new DBconnection();
		Connection con= db.createConnection();
		PreparedStatement ps= con.prepareStatement("select distinct cm.UC_ID,c.C_ID,c.C_NAME from CATEGORY c,CATEGORY_MAPPING cm where c.C_ID=cm.C_ID and UC_ID=?;");
		ps.setString(1,uid);
		ResultSet rs= ps.executeQuery();
		
		while(rs.next())
		{
		MenuModel mm=new MenuModel();
		mm.setCid(rs.getString(2));
		mm.setName(rs.getString(3));System.out.println("cnmae"+mm.getCname());
		mm.setUid(rs.getString(1));
		fetchcategory.add(i,mm);
		i++;
		}
		

	}

	catch(Exception e)
	{
		e.printStackTrace();
	}
		return fetchcategory;
	
	}
	
	
}
