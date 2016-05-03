package flipkart.Db;
import java.sql.*;
import java.util.ArrayList;

import flipkart.Model.LabTestModel;
import flipkart.Model.ProductInfo;
import flipkart.Model.ShowcategoryModel;
import flipkart.Model.SignupModel;
import flipkart.Db.DBconnection;
import flipkart.Model.SearchModel;

public class DBhandler {
	ArrayList<String> item = new ArrayList<String>();
//	ArrayList<SearchModel> itemDetail = new ArrayList<SearchModel>();

	//ArrayList<String> item = new ArrayList<String>();
	ArrayList<SearchModel> itemDetail = new ArrayList<SearchModel>();

	 public static String categ;
	ArrayList<String> subcategory=new ArrayList<String>();

	ArrayList<ProductInfo> products=new ArrayList<ProductInfo>();
	ArrayList<ProductInfo> filter=new ArrayList<ProductInfo>();
	///geeta------------------------------------------------------------------------------------------------------------
		
	//search
	
	String catname;
		public String getCategoryname(String pname){
				
				DBconnection db=new DBconnection ();	
				Connection con=(Connection) db.createConnection();
				String query="select distinct C_NAME from Flipkart_db.CATEGORY_MAPPING c,Flipkart_db.PRODUCT_INFO p ,CATEGORY cm where p.P_ID=c.P_ID and cm.C_ID=c.C_ID and p.P_NAME =?";
				try {
			
					PreparedStatement ps=con.prepareStatement(query);
					ps.setString(1, pname);
					System.out.println("in rs of else of search db");
					ResultSet rs=	ps.executeQuery();System.out.println("category up");//System.out.println(rs.next());
					rs.next();
					 catname=rs.getString(1);

				}

				catch (SQLException e) {
					e.printStackTrace();
				}

				return catname;
			}
	
	public ArrayList<String> getFrameWork(String frameWork) {
			ArrayList<String> list = new ArrayList<String>();
			PreparedStatement ps = null;
		//	JSONArray  jsonA=new JSONArray ();
			String data;//Select distinct p.P_NAME from SEARCH where KEYWORD like ?"
			try {
				DBconnection db=new DBconnection ();	
				Connection con= db.createConnection();
				ps = con.prepareStatement("Select distinct( KEYWORD) from SEARCH where KEYWORD like ?");
				ps.setString(1, frameWork + "%");
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					data = rs.getString("KEYWORD");
					System.out.println("hey");
					System.out.println(rs.getString("KEYWORD"));
					System.out.println(list);
					list.add(data);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			return list;
		}

	//ArrayList<SearchModel> itemDetail = new ArrayList<SearchModel>();
		public ArrayList<SearchModel> getKeywordList(String key) 
		{
			PreparedStatement ps = null;
			DBconnection db = new DBconnection();
			Connection con = db.createConnection();
			//JSONArray  jsonA=new JSONArray ();
			try {
				int i = 0;
				String sql;
				sql = ("select distinct(KEYWORD) from SEARCH  where  KEYWORD like ? ");
				System.out.println("key:" + key);
				ps = con.prepareStatement(sql);
				ps.setString(1, key+"%");
				// ps.setString(1, retrive.getSem());
				System.out.println(" query" + key);
				ResultSet rs = ps.executeQuery();
				//JSONObject json=new JSONObject();
				while (rs.next()) {
					//json.put("name", rs.getString("KEYWORD"));
					//json.put("value", )
					SearchModel sm = new SearchModel();
					//sm.setProductId(rs.getString("P_ID"));
					sm.setProductName(rs.getString("KEYWORD"));
					//jsonA.add(json);
					itemDetail.add(i, sm);
					System.out.println(itemDetail.get(i).getProductName());
	i++;
				}
	//System.out.println("json array: "+jsonA);
				System.out.println("item list:" + itemDetail);

			} catch (Exception e) {
				System.out.println("Error.." + e);
			}
			return itemDetail;
	}
		//=================================================
		public ArrayList<SearchModel> getserachresult(String key) {

			PreparedStatement ps = null;
			DBconnection db = new DBconnection();
			Connection con = db.createConnection();
			try {
				int i = 0;
				String sql;
				sql = "SELECT * FROM SEARCH s,PRODUCT_INFO p where s.P_ID=p.P_ID and KEYWORD= ?";
				System.out.println("key:" + key);
				ps = con.prepareStatement(sql);
				ps.setString(1, key);
				// ps.setString(1, retrive.getSem());
				System.out.println(" query" + sql);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					SearchModel sm = new SearchModel();
					sm.setProductId(rs.getString("P_ID"));
					sm.setProductName(rs.getString("P_NAME"));

					itemDetail.add(i, sm);
					// System.out.println(item);

				}

				System.out.println("item list:" + itemDetail);

			} catch (Exception e) {
				System.out.println("Error.." + e);
			}
			return itemDetail;
		}

		public boolean checkCategory(String key) {

			PreparedStatement ps = null;
			DBconnection db = new DBconnection();
			Connection con = db.createConnection();
			ArrayList<String> cname = new ArrayList<String>();
			int n = 0;
			try {
				int i = 0;
				String sql;
				sql = "SELECT C_NAME FROM CATEGORY ";
				System.out.println("key:" + key);
				ps = con.prepareStatement(sql);

				System.out.println(" query" + key);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {

					cname.add(rs.getString(1));

					System.out.println("cname:" + cname.get(i));
					i++;
				}

				// System.out.println("item list:"+itemDetail);

			} catch (Exception e) {
				System.out.println("Error.." + e);

			}

			n = cname.size();
			System.out.println(n);
			if (cname.contains(key)){
				System.out.println("match with category"+key);
				categ=key;
				return true;
				}
			else{System.out.println("false return from category");
				return false;}

		}
		ArrayList<ProductInfo> itemlist=new ArrayList<ProductInfo>();

		public ArrayList<ProductInfo> checkProduct(String key) {
			PreparedStatement ps = null;
			DBconnection db = new DBconnection();
			Connection con = db.createConnection();
			ArrayList<String> pname = new ArrayList<String>();ProductInfo sm= new ProductInfo();
			int count = 0;
			try {
				int i = 0;
				String sql;
				sql = "SELECT P_ID,P_NAME FROM PRODUCT_INFO p where  p.P_NAME=? ";
				System.out.println("key:" + key);
				ps = con.prepareStatement(sql);
				ps.setString(1,key);
				// ps.setString(1, retrive.getSem());
				System.out.println(" query" + sql);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					ProductInfo pm = new ProductInfo();
					count++;
					pm.setProduct_id(rs.getString("P_ID"));
					pm.setProduct_name(rs.getString("P_NAME"));

					pm.setCount(count);
					System.out.println("in db count:" + count + " model count "	+ pm.getCount());
					itemlist.add(i, pm);
					//pname.add(rs.getString(2));
					i++;
					// System.out.println(item);
					
				}
				sm.setCount(count);
				itemlist.add(count,sm );
				System.out.println("item list:" + itemlist.get(0).getProduct_id());

			} catch (Exception e) {
				System.out.println("Error.." + e);

			}
				if(count==1)
					sm.setT(true);
				else if(count>1)
					sm.setF(true);
				
			
					//System.out.println("resutlt:"+result);
		
			
				return itemlist;
		}
		
		public ArrayList<String> getsubCategory(String cname)
		{

			// getting  product info according to category selected
			DBconnection db=new DBconnection ();	
			Connection con=(Connection) db.createConnection();

			//FILTERS getting subcategory name
			String query1="select SC_NAME from SUB_CATEGORY where SC_ID in(select SC_ID from CATEGORY_MAPPING c,PRODUCT_INFO p where p.P_ID=c.P_ID and C_ID =(select C_ID from CATEGORY where C_NAME='" + cname +"'))";
			try{

				PreparedStatement ps1=con.prepareStatement(query1);
				//	ps1.setString(1, cname);
				System.out.println("here");
				ResultSet rs1=	ps1.executeQuery();
				while(rs1.next())
				{

					subcategory.add(rs1.getString(1));
				}

				System.out.println("sub"+subcategory);
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return subcategory;	
		}
		
String Pid=new String();
		public String getPid(String pname){
			DBconnection db=new DBconnection ();	
			Connection con=(Connection) db.createConnection();
			String query="select P_ID from Flipkart_db.PRODUCT_INFO where P_NAME=?";
			try {
				int i=0;
				PreparedStatement ps=con.prepareStatement(query);
				ps.setString(1, pname);
				System.out.println("in rs of else of search db");
				ResultSet rs=	ps.executeQuery();System.out.println("category up");//System.out.println(rs.next());
				while(rs.next())
				{	System.out.println("category in");
					Pid=rs.getString(1);
System.out.println(Pid);
					
					System.out.println("in while of search");
					//product.set
				//	products.add(product);
				//	System.out.println(products.get(i).getProduct_name());
	//i++;
				}

			}

			catch (SQLException e) {
				e.printStackTrace();
			}

			

			return Pid;
		}
		
		public ArrayList<ProductInfo> getProduct(String pname)

		{
	System.out.println("category in dbhand"+pname);
			// getting  product info according to category selected
			DBconnection db=new DBconnection ();	
			Connection con=(Connection) db.createConnection();
			String query="select DISTINCT P_NAME,P_DESCRIPTION,P_BRAND,PRICE,STOCK,P_IMAGE,p.P_ID  from Flipkart_db.CATEGORY_MAPPING c,Flipkart_db.PRODUCT_INFO p ,Flipkart_db.SELLER_PRODUCT s where p.P_ID=c.P_ID and p.P_ID =any(select P_ID from Flipkart_db.PRODUCT_INFO where P_NAME=?) AND p.P_ID=s.P_ID";
			try {
				int i=0;
				PreparedStatement ps=con.prepareStatement(query);
				ps.setString(1, pname);
				System.out.println("in rs of else of search db");
				ResultSet rs=	ps.executeQuery();System.out.println("category up");//System.out.println(rs.next());
				while(rs.next())
				{	System.out.println("category in");
					ProductInfo product=new ProductInfo();

					product.setProduct_name(rs.getString(1));
					product.setProduct_description(rs.getString(2));
					product.setBrand(rs.getString(3));
					product.setPrice(rs.getInt(4));
					product.setStock(rs.getInt(5));
					product.setImage("images/"+rs.getString(6));
					product.setProduct_id(rs.getString(7));
					System.out.println("in while of search");
					//product.set
					products.add(product);
					System.out.println(products.get(i).getProduct_name());
	i++;
				}

			}

			catch (SQLException e) {
				e.printStackTrace();
			}

			return products;

		}



		public ArrayList<String> getsubCategoryInfo(String pname)
		{

			// getting  product info according to category selected
			DBconnection db=new DBconnection ();	
			Connection con=(Connection) db.createConnection();

			//FILTERS getting subcategory name
			String query1="select SC_NAME from SUB_CATEGORY where SC_ID in(select SC_ID from CATEGORY_MAPPING c,PRODUCT_INFO p where p.P_ID=c.P_ID and p.P_ID =(select P_ID from PRODUCT_INFO where P_NAME='" + pname +"'))";
			try{

				PreparedStatement ps1=con.prepareStatement(query1);
				//	ps1.setString(1, cname);
				System.out.println("here");
				ResultSet rs1=	ps1.executeQuery();
				while(rs1.next())
				{

					subcategory.add(rs1.getString(1));
				}

				System.out.println("sub"+subcategory);
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return subcategory;	
		}
		
		
	


 //public static String categ;
//	ArrayList<String> subcategory=new ArrayList<String>();
		ArrayList<String> brandnames=new ArrayList<String>();
		//ArrayList<ProductInfo> products=new ArrayList<ProductInfo>();
//		ArrayList<ProductInfo> filter=new ArrayList<ProductInfo>();

		public ArrayList<ProductInfo> browseProduct(String cname)
		{

			// getting  product info according to category selected
			DBconnection db=new DBconnection ();	
			Connection con=(Connection) db.createConnection();
			String query="select DISTINCT P_NAME,P_DESCRIPTION,P_BRAND,PRICE,STOCK,P_IMAGE,p.P_ID from CATEGORY_MAPPING c,PRODUCT_INFO p ,SELLER_PRODUCT s where p.P_ID=c.P_ID and C_ID =(select C_ID from CATEGORY where C_NAME=?) AND p.P_ID=s.P_ID";
			try {

				PreparedStatement ps=con.prepareStatement(query);
				ps.setString(1, cname);
				ResultSet rs=	ps.executeQuery();
				while(rs.next())
				{	
					ProductInfo product=new ProductInfo();

					product.setProduct_name(rs.getString(1));
					product.setProduct_description(rs.getString(2));
					product.setBrand(rs.getString(3));
					product.setPrice(rs.getInt(4));
					product.setStock(rs.getInt(5));
					product.setImage("images/"+rs.getString(6));
					product.setProduct_id(rs.getString(7));
	
					products.add(product);
					System.out.println(products.get(0).getProduct_name());

				}

			}

			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return products;

		}


		public ArrayList<String> getBrandnames(String cname)
		{

			// getting  product info according to category selected
			DBconnection db=new DBconnection ();	
			Connection con=(Connection) db.createConnection();
			String query="select DISTINCT P_BRAND from CATEGORY_MAPPING c,PRODUCT_INFO p ,SELLER_PRODUCT s where p.P_ID=c.P_ID and C_ID =(select C_ID from CATEGORY where C_NAME=?) AND p.P_ID=s.P_ID";
			try {

				PreparedStatement ps=con.prepareStatement(query);
				ps.setString(1, cname);
				ResultSet rs=	ps.executeQuery();
				while(rs.next())
				{	
					

				
					brandnames.add(rs.getString(1));
			//		System.out.println(products.get(0).getProduct_name());

				}

			}

			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return brandnames;

		}
		
		
		
		
		public ArrayList<ProductInfo> browseProductsort(String sorttype,
				String categoryname) {
			// TODO Auto-generated method stub


			DBconnection db=new DBconnection ();	
			Connection con=(Connection) db.createConnection();
			try 
			{
			if(sorttype.equals("DESC"))
			{
				String query="select DISTINCT P_NAME,P_DESCRIPTION,P_BRAND,PRICE,STOCK,P_IMAGE,p.P_ID from CATEGORY_MAPPING c,PRODUCT_INFO p ,SELLER_PRODUCT s where p.P_ID=c.P_ID and C_ID =(select C_ID from CATEGORY where C_NAME=?) AND p.P_ID=s.P_ID ORDER BY s.PRICE2116 DESC";
			
				PreparedStatement ps=con.prepareStatement(query);
				ps.setString(1, categoryname);

				ResultSet rs=	ps.executeQuery();
				int i=0;
				while(rs.next())
				{	
					ProductInfo product=new ProductInfo();

					product.setProduct_name(rs.getString(1));
					product.setProduct_description(rs.getString(2));
					product.setBrand(rs.getString(3));
					product.setPrice(rs.getInt(4));
					product.setStock(rs.getInt(5));
					product.setImage("images/"+rs.getString(6));
					product.setProduct_id(rs.getString(7));
					products.add(product);
					System.out.println(products.get(i).getPrice());
					i++;
				}

			}

			
			else
			{

				String query="select DISTINCT P_NAME,P_DESCRIPTION,P_BRAND,PRICE,STOCK,P_IMAGE,p.P_ID from CATEGORY_MAPPING c,PRODUCT_INFO p ,SELLER_PRODUCT s where p.P_ID=c.P_ID and C_ID =(select C_ID from CATEGORY where C_NAME=?) AND p.P_ID=s.P_ID ORDER BY s.PRICE2116 ASC";


			
					PreparedStatement ps=con.prepareStatement(query);
					ps.setString(1, categoryname);

					ResultSet rs=	ps.executeQuery();
					int i=0;
					while(rs.next())
					{	
						ProductInfo product=new ProductInfo();

						product.setProduct_name(rs.getString(1));
						product.setProduct_description(rs.getString(2));
						product.setBrand(rs.getString(3));
						product.setPrice(rs.getInt(4));
						product.setStock(rs.getInt(5));
						product.setImage("images/"+rs.getString(6));
						product.setProduct_id(rs.getString(7));
						products.add(product);
						System.out.println(products.get(i).getPrice());
						i++;
					}


				}

			}

				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				return products;



			}

	
	

	/*public ArrayList<String> getsubCategory(String cname)
	{

		// getting  product info according to category selected
		DBconnection db=new DBconnection ();	
		Connection con=(Connection) db.createConnection();

		//FILTERS getting subcategory name
		String query1="select SC_NAME from SUB_CATEGORY where SC_ID in(select SC_ID from CATEGORY_MAPPING c,PRODUCT_INFO p where p.P_ID=c.P_ID and C_ID =(select C_ID from CATEGORY where C_NAME='" + cname +"'))";
		try{

			PreparedStatement ps1=con.prepareStatement(query1);
			//	ps1.setString(1, cname);
			System.out.println("here");
			ResultSet rs1=	ps1.executeQuery();
			while(rs1.next())
			{

				subcategory.add(rs1.getString(1));
			}

			System.out.println("sub"+subcategory);
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return subcategory;	
	}
*/
/*
	public ArrayList<ProductInfo> getlastCategory(String cname)
	{

		// getting  product info according to category selected
		DBconnection db=new DBconnection ();	
		Connection con=(Connection) db.createConnection();

		String query2="select SC_ID,COUNT(SC_ID) from CATEGORY_MAPPING c,PRODUCT_INFO p where p.P_ID=c.P_ID and C_ID =(select C_ID from CATEGORY where C_NAME='" + cname +"') GROUP BY SC_ID";
		String query3="select LC_ID,LC_NAME from LAST_CATEGORY where LC_ID in (select LC_ID from CATEGORY_MAPPING c,PRODUCT_INFO p where p.P_ID=c.P_ID and C_ID =(select C_ID from CATEGORY where C_NAME='" + cname +"'))";
		try {
			PreparedStatement ps2=con.prepareStatement(query2);
			PreparedStatement ps3=con.prepareStatement(query3);
			//	ps2.setString(1, cname);
			//	ps3.setString(1, cname);
			ResultSet rs2=	ps2.executeQuery();
			ResultSet rs3=	ps3.executeQuery();
			int i=0;

			while(rs2.next())
			{
				ArrayList<String> lastcategory=new ArrayList<String>();
				ProductInfo product1=new ProductInfo();
				int count =rs2.getInt(2);
				System.out.println("count"+count);



				while(count>0)
				{
					rs3.next();
					System.out.println("row"+rs3.getRow());
					lastcategory.add(rs3.getString(2));
					count--;	
				}



				product1.setLastcategory(lastcategory);
				filter.add(product1);
				System.out.println("last category"+filter.get(i).getLastcategory());

				i++;
				//System.out.println(products.get(i).getBrand());
			}

		}


		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	//	System.out.println("filter in db"+filter.get(0).getLastcategory());
	//	System.out.println("filter in db"+filter.get(1).getLastcategory());
		return filter;
	}


*/

	public ArrayList<ProductInfo> getproductlistoncategoryfilter(String[] brand, String[] price, String categoryname, int count, int countprice) throws SQLException
	{
		DBconnection db=new DBconnection ();
		Connection con = db.createConnection();
		ArrayList<ProductInfo> ProductInfo = new ArrayList<ProductInfo>();	
		String temp="", query="";
		ResultSet rs;


		try{

	
			//	ps1.setString(1, cname);
			System.out.println("here");

			if(count > 0 && countprice >0)
			{
				for(int i=0; i<count; i++)
				{
					for(int k=0; k<countprice; k++)
					{
						query += "select DISTINCT P_NAME,P_DESCRIPTION,P_BRAND,PRICE,STOCK,P_IMAGE,p.P_ID from CATEGORY_MAPPING c,PRODUCT_INFO p ,SELLER_PRODUCT s where p.P_ID=c.P_ID and C_ID =(select C_ID from CATEGORY where C_NAME='" + categoryname + "') AND p.P_ID=s.P_ID and P_BRAND = '" + brand[i] + "' ";

						if(price[k].equalsIgnoreCase("1"))
						{
							query +=" and (PRICE) between 0 and 2000"; 
						}
						else if(price[k].equalsIgnoreCase("2"))
						{
							query += " and (PRICE) between 2001 and 5000";       
						}
						else if(price[k].equalsIgnoreCase("3"))
						{
							query += " and (PRICE) between 5001 and 10000";     
						}
						else if(price[k].equalsIgnoreCase("4"))
						{
							query += " and (PRICE) between 10001 and 18000";      
						}
						else if(price[k].equalsIgnoreCase("5"))
						{
							query += " and (PRICE) between 18001 and 25000";      
						}
						else if(price[k].equalsIgnoreCase("6"))
						{
							query += " and (PRICE) between 25001 and 35000";       
						}
						else if(price[k].equalsIgnoreCase("7"))
						{
							query += " and (PRICE) > 35001";      
						}
						if(i == (count-1) &&  k == (countprice-1))
						{
						}
						else
						{
							query +=" UNION ";
						}
					}
				}
			}
		
		else if(count > 0)
		{
			for(int i=0; i<count; i++)
			{
		
				
					query += "select DISTINCT P_NAME,P_DESCRIPTION,P_BRAND,PRICE,STOCK,P_IMAGE,p.P_ID from CATEGORY_MAPPING c,PRODUCT_INFO p ,SELLER_PRODUCT s where p.P_ID=c.P_ID and C_ID =(select C_ID from CATEGORY where C_NAME='" + categoryname + "') AND p.P_ID=s.P_ID and P_BRAND ='" + brand[i] + "'"; 
			
					if(i == (count-1))
					{
					}
					else
					{
						query +=" UNION ";
					}
				}
			
		}
		else if(countprice > 0)
		{
			for(int i=0; i<countprice; i++)
			{
				
					query += "select DISTINCT P_NAME,P_DESCRIPTION,P_BRAND,PRICE,STOCK,P_IMAGE,p.P_ID from CATEGORY_MAPPING c,PRODUCT_INFO p ,SELLER_PRODUCT s where p.P_ID=c.P_ID and C_ID =(select C_ID from CATEGORY where C_NAME='" + categoryname + "') AND p.P_ID=s.P_ID";
					if(price[i].equalsIgnoreCase("1"))
					{
						query += " and (PRICE) BETWEEN 0 AND 2000";
					}
					else if(price[i].equalsIgnoreCase("2"))
					{
						query += " and (PRICE) BETWEEN 2001 AND 5000";
					}
					else if(price[i].equalsIgnoreCase("3"))
					{
						query += " and (PRICE) BETWEEN 5001 AND 10000";
					}
					else if(price[i].equalsIgnoreCase("4"))
					{
						query += " and (PRICE) BETWEEN 10001 AND 18000";
					}
					else if(price[i].equalsIgnoreCase("5"))
					{
						query += " and (PRICE) BETWEEN 18000 AND 25000";
					}
					else if(price[i].equalsIgnoreCase("6"))
					{
						query += " and (PRICE) BETWEEN 25001 AND 35000";       
					}
					else if(price[i].equalsIgnoreCase("7"))
					{
						query += " and (PRICE) > 35000";
					}

					if(i == (countprice-1))
					{
					}
					else
					{
						query +=" UNION ";
					}
				}
			
		}
			PreparedStatement ps=con.prepareStatement(query);

			rs=ps.executeQuery();
		while(rs.next())
		{
			ProductInfo obj = new ProductInfo();
	
obj.setBrand(rs.getString(3));
			obj.setPrice(rs.getInt(4));
			obj.setProduct_name(rs.getString(1));
			obj.setProduct_description(rs.getString(2));
			obj.setStock(rs.getInt(5));
			obj.setImage("images/"+rs.getString(6));
			obj.setProduct_id(rs.getString(7));
			ProductInfo.add(obj);
		}


	}

	catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	return ProductInfo;	


}
		// abhishek 
	
	
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
			con.close();
		}
			catch(Exception e)
			{
				e.printStackTrace();
			}
				return fetchcat;
			
	}

	
	
	
	// Add user on signup
	public String AddUser(SignupModel sm) throws Exception
	{

			DBconnection dbc = new DBconnection();
			Connection con = dbc.createConnection();
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
		con.close();
		int k=prep1.executeUpdate();
		
		if(k==1)
		{
			
			return "user";
		}
	else
		return "error";
	}

	
	// Check email as U_ID and password, if matches then return role else wrong email or pass  

	public String getFname (String email, String password) throws Exception {
		String fname = null;
		// String str1 = "wrong";
		String role = null;
		//int flag = 0;
		DBconnection dbc = new DBconnection();
		Connection con = dbc.createConnection();
		String sql = "SELECT U_ID,F_NAME,PASSWORD,ROLE FROM CREDENTIAL where U_ID=? and PASSWORD=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, email);
		ps.setString(2, password);
		ResultSet rs = null;
		rs = ps.executeQuery();
		while(rs.next())
		{
		fname = rs.getString("F_NAME");
		role = rs.getString("ROLE");
		if (role.equalsIgnoreCase("admin"))
			return "admin";
		if (role.equalsIgnoreCase("seller"))
			return "seller";
		if (role.equalsIgnoreCase("user"))
			return fname;
		else
			return "error";
		}
		/*
		 * while(rs.next()) { if(rs.getString("U_ID").equals(email) &&
		 * rs.getString("PASSWORD").equals(password)) {
		 * fname=rs.getString("F_NAME"); flag = 1; } }
		 */
		/* if(flag==1) return fname; else return str1; */
		return "error";
	}	
	
	// Check for email already exist and return invalid else return valid  
	
	public String  CheckForU_IDAlreadyExist(String email) throws Exception
	{
		DBconnection dbc = new DBconnection();
		Connection con = dbc.createConnection();
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
		con.close();
		return Exist;	
	}
	public String CheckForEmail(String email) throws SQLException 
	{
		DBconnection dbc = new DBconnection();
		Connection con = dbc.createConnection();
		String role=null;
		String query="SELECT U_ID,ROLE FROM CREDENTIAL";
		Statement stmt = (Statement) dbc;
		ResultSet rs=stmt.executeQuery(query);
		while(rs.next())
		{
			if(rs.getString("U_ID").equals(email))
				role=rs.getString("ROLE");
		}
		con.close();
		if (role==null)
		{
			return "invalid";
		}
		return role;
			
	}

	public ArrayList<ProductInfo> getProductLast(String lastcategoryname) {
		// TODO Auto-generated method stub
		// getting  product info according to category selected
		DBconnection db=new DBconnection ();	
		Connection con=(Connection) db.createConnection();
		String query="select DISTINCT P_NAME,P_DESCRIPTION,P_BRAND,PRICE,STOCK,P_IMAGE,p.P_ID from CATEGORY_MAPPING c,PRODUCT_INFO p ,SELLER_PRODUCT s where p.P_ID=c.P_ID and LC_ID =(select LC_ID from LAST_CATEGORY where LC_NAME=?) AND p.P_ID=s.P_ID";
		try {

			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, lastcategoryname);
			ResultSet rs=	ps.executeQuery();
			while(rs.next())
			{	
				ProductInfo product=new ProductInfo();

				product.setProduct_name(rs.getString(1));
				product.setProduct_description(rs.getString(2));
				product.setBrand(rs.getString(3));
				product.setPrice(rs.getInt(4));
				product.setStock(rs.getInt(5));
				product.setImage("images/"+rs.getString(6));
				product.setProduct_id(rs.getString(7));
				products.add(product);
				System.out.println(products.get(0).getProduct_name());

			}

		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return products;


		
		
		
	}
	
	

	public ArrayList<ProductInfo> browseProductsortLast(String sorttype,
			String lastcategoryname) {
		// TODO Auto-generated method stub


		DBconnection db=new DBconnection ();	
		Connection con=(Connection) db.createConnection();
		try 
		{
		if(sorttype.equals("DESC"))
		{
			String query="select DISTINCT P_NAME,P_DESCRIPTION,P_BRAND,PRICE,STOCK,P_IMAGE,p.P_ID from CATEGORY_MAPPING c,PRODUCT_INFO p ,SELLER_PRODUCT s where p.P_ID=c.P_ID and LC_ID =(select LC_ID from LAST_CATEGORY where LC_NAME=?) AND p.P_ID=s.P_ID ORDER BY s.PRICE2116 DESC";
		
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, lastcategoryname);

			ResultSet rs=	ps.executeQuery();
			int i=0;
			while(rs.next())
			{	
				System.out.println("in db");
				ProductInfo product=new ProductInfo();

				product.setProduct_name(rs.getString(1));
				product.setProduct_description(rs.getString(2));
				product.setBrand(rs.getString(3));
				product.setPrice(rs.getInt(4));
				product.setStock(rs.getInt(5));
				product.setImage("images/"+rs.getString(6));
				product.setProduct_id(rs.getString(7));
				products.add(product);
				System.out.println(products.get(i).getPrice());
				i++;
			}

		}

		
		else
		{

			String query="select DISTINCT P_NAME,P_DESCRIPTION,P_BRAND,PRICE,STOCK,P_IMAGE,p.P_ID from CATEGORY_MAPPING c,PRODUCT_INFO p ,SELLER_PRODUCT s where p.P_ID=c.P_ID and LC_ID =(select LC_ID from LAST_CATEGORY where LC_NAME=?) AND p.P_ID=s.P_ID ORDER BY s.PRICE2 ASC";


		
				PreparedStatement ps=con.prepareStatement(query);
				ps.setString(1, lastcategoryname);

				ResultSet rs=	ps.executeQuery();
				int i=0;
				while(rs.next())
				{	
					ProductInfo product=new ProductInfo();

					product.setProduct_name(rs.getString(1));
					product.setProduct_description(rs.getString(2));
					product.setBrand(rs.getString(3));
					product.setPrice(rs.getInt(4));
					product.setStock(rs.getInt(5));
					product.setImage("images/"+rs.getString(6));
					product.setProduct_id(rs.getString(7));
					products.add(product);
					System.out.println(products.get(i).getPrice());
					i++;
				}


			}

		}

			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return products;



		}

	
	
	
	
	
	
	public ArrayList<LabTestModel> fetchProduct() {
		ArrayList<LabTestModel> productinfo=new ArrayList<LabTestModel>();
		try{
			System.out.println("inside fetchProduct");
		DBconnection db=new DBconnection();
		Connection con= db.createConnection();
		PreparedStatement ps= (PreparedStatement) con.prepareStatement("select p.P_ID116, p.P_NAME116,p.P_IMAGE116,sp.PRICE2116 from Flipkart_db.PRODUCT as p,Flipkart_db.SELLER_PRODUCT as sp where sp.P_ID=p.P_ID116 order by sp.PRICE2116 ASC");
		ResultSet rs=ps.executeQuery();
		int i=0;
		while(rs.next()){
			LabTestModel ltm=new LabTestModel();
			ltm.setP_ID116(rs.getString(1));
			ltm.setP_Name(rs.getString(2));
			//ltm.setP_Brand(rs.getString(3));
			String path="images/"+rs.getString(3);
			ltm.setDestpath(path);
			ltm.setP_Price(rs.getInt(4));
			productinfo.add(ltm);
			System.out.println("value of array list"+productinfo.get(i).getP_Name());
			i++;
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return productinfo;
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
	
	
	
	
	


}
