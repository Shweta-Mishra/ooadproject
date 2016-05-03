<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en-IN">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.sql.*"%>
<%ResultSet resultset =null;%>
<%ResultSet resultset1 =null;%>
<%ResultSet resultset3 =null;%>
<head>
<meta http-equiv="Content-Type"
	content="application/xhtml+xml; charset=utf-8" />
<title>Flipkart</title>
<!--
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
    -->

<meta name="robots" content="noodp" />
<link rel='shortcut icon' href='images/shortcut icon.ico' />

<!-- ye stylesheet1,2,3 h  -->

<link href="css/codebeautify.css" rel="stylesheet" />
<link href="css/codebeautify1.css" rel="stylesheet" />
<link href="css/codebeautify3.css" rel="stylesheet" />
<link rel="stylesheet" href="css/jquery-ui.css"/>
<link rel="stylesheet" href="style.css"/>
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery-ui.js"></script>
<script src="js/jquery-1.9.1.js"></script>

<script src="JavaScripts/jquery.min.js"></script>
	<!-- <script src="ajaxscripts/HomeAjax.js"></script> -->
	
	


	</head>			<!--  -->
	<body>		
	
	<!--  -->
				<div class="menu-header-content">
					<div class="menubar newMenu slowMenu">
						<div class="top-menu unit">
							<ul class="menu-links required-tracking">

								<!-- for menu bar -->
								
								<%
    try{
    	
//Class.forName("com.mysql.jdbc.Driver").newInstance();
Class.forName("com.mysql.jdbc.Driver");
Connection connection = 
         DriverManager.getConnection
            ("jdbc:mysql://localhost/Flipkart_db","root","mishra");

       Statement statement = connection.createStatement() ;
       Statement statement1 = connection.createStatement() ;
       Statement statement3 = connection.createStatement() ;
       resultset =statement.executeQuery("select UC_NAME from UPPER_CATEGORY") ;		
%>
	

				<%  while(resultset.next()){ %>
				
				
												<li class="menu-l0" id="Electronics" >
								<a  class="menu-text fk-inline-block"> <span><%= resultset.getString(1)%> </span>
								</a>	<span class="menu-arrow fk-inline-block"></span><div id="myid" class="submenu" >
				
					<% String temp=resultset.getString(1);
       String query2="SELECT UC_ID from UPPER_CATEGORY where UC_NAME='"+temp+"'";
    
		//temp=temp.toUpperCase();
		//PreparedStatement ps = connection.prepareStatement(query2);
		Statement stmt = connection.createStatement();
	   // ps.setString(1, "%" + temp + "%");
		ResultSet rs = stmt.executeQuery(query2);
		String category=""; 
		while(rs.next()){
			
	          category  = rs.getString(1);
		}
		resultset1 =statement1.executeQuery("select DISTINCT C.C_ID,CAT.C_NAME from CATEGORY_MAPPING C,CATEGORY CAT where UC_ID='"+category+"'  AND C.C_ID =CAT.C_ID") ;
		%>
				

					<%  while(resultset1.next()){ 
        int i=0;
        if(i%2==0){%>

				
						<%}  %>


						
												<h4>			
							<a
								href="BrowseProduct?uppercategoryname=<%= resultset.getString(1) %>&categoryname=<%= resultset1.getString(2)%>"> <%= resultset1.getString(2)%> </a>
						</h4>

						<%i++; 
    		 String temp3=resultset1.getString(1);
    		String temp4="SC13";
       String query3="SELECT DISTINCT C.LC_ID,LC_NAME from CATEGORY_MAPPING C ,LAST_CATEGORY LC where C_ID='"+temp3+"' and SC_ID= '"+temp4+"' and C.LC_ID=LC.LC_ID";
		//temp3=temp3.toUpperCase();
		//PreparedStatement ps3 = connection.prepareStatement(query3);
	    //ps3.setString(1, "%" + temp3 + "%");
	    Statement stmt1 = connection.createStatement();
		ResultSet rs3 = stmt1.executeQuery(query3);
	//	String 
	//	while(rs3.next()){
	   //       id3  = rs3.getInt("2");      
		//}
		//resultset3 =statement3.executeQuery("select cat_name from category where cat_parent="+id3) ;
		%>
						<ul>
							<%  while(rs3.next()){%>
							<li>
							<a 
								href="BrowseProductLast?uppercategoryname=<%= resultset.getString(1) %>&categoryname=<%= resultset1.getString(2)%>&lastcategoryname=<%= rs3.getString(2)%>"><br/>&nbsp;&nbsp;&nbsp;&nbsp;<%= rs3.getString(2)%></a></li>
							<% } %>
								
						</ul>
			<hr></hr>
					<% } %>
			
			
				<% } %>
		
	
			<%
//**Should I input the codes here?**
        }
        catch(Exception e)
        {
             out.println("wrong entry"+e);
        }
%>
		
		
		</div>
		
					</li>
					
					
					
					
					</ul>
					<div></div>

								</div>
							
									
													
						</div>
					</div>
	
	<div></div>
	<div></div>
	<div>			
<li><a href="ProductsInfoLab"><input type="button" value="Question"></input></a></li>
</div>
 </body>
</html>

 
