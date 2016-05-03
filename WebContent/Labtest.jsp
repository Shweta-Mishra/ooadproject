<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>



<link href="css/codebeautify.css" rel="stylesheet" />
<link href="css/codebeautify1.css" rel="stylesheet" />
<link href="css/codebeautify3.css" rel="stylesheet" />
<link rel="stylesheet" href="css/jquery-ui.css"/>
<link rel="stylesheet" href="style.css"/>
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery-ui.js"></script>
<script src="js/jquery-1.9.1.js"></script>
 <script src="autocompleter.js"></script>
<link rel="stylesheet" href="style.css"/>
<script src="JavaScripts/jquery.min.js"></script>
<link href="css/bootstrap.css" rel="stylesheet"/>
<script src="JavaScripts/jquery-2.0.3.js"></script>
<script src="JavaScripts/bootstrap.min.js"></script>
<script src="JavaScripts/notification.js"></script>
<script src="JavaScripts/jquery-2.1.3.min.js"></script>




<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- Display here -->
display
Shweta Mishra    MT2014116
<% int i=1; %>
<div><table>
<tr>

<td class="col-md-3">Sno:</td>

<td class="col-md-3">Prod_Id</td>

<td class="col-md-3">Prod_Name</td>

<td class="col-md-3">Prod_Img</td>

<td class="col-md-3">Prod_Price</td>
</tr>

<s:iterator value="array">
<tr>
<td><%out.print(i++); %>
<td><s:property value="P_ID116"/></td>
<td><s:property value="P_Name"/></td>
<td><img src="<s:property value="destpath"/>" height="200px" width="100px"/></td>
<td><s:property value="P_Price"/></td>
</tr>
</s:iterator>
</table>
</div>
</body>
</html>