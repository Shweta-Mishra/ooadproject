<%@page import= "java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
    <%@page import="flipkart.Model.Usermodel"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%System.out.println("in body!"); %>
 		       <% ArrayList<Usermodel> orders = (ArrayList<Usermodel>)request.getAttribute("Orders");
 		      int i=0;
 		       System.out.println("arraylist created!!");
 		       %>
 					
 		     
 		     <% for(i=0;i!=1;i++){
 		    System.out.println("value of i="+i);
 		     %>
<div class='displayData'>Your Flipkart order# <strong> <%=orders.get(i).getOrderid() %></strong> has been <strong><%=orders.get(i).getStatus() %></strong></div>
<div class='displayData' align="right"> <%=orders.get(i).getDays_ago() %>days ago</div>
<br>
<br>
<% System.out.println("hii!!");
 		     }
 %>
 
 <div align="center"><a href="notification" style="color:blue;">See All</a></div>
		
</body>
</html>