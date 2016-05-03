<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%--  <%@ include file="sellerBody.jsp" %>  --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Product</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- jQuery -->
<script src="js/jquery.js"></script>
<link rel='shortcut icon' href='shortcut icon.ico' />
<!-- ye stylesheet1,2,3 h  -->
<link href="css/codebeautify.css" rel="stylesheet" />
<link href="css/codebeautify1.css" rel="stylesheet" />
<link href="css/codebeautify3.css" rel="stylesheet" />

<!-- Bootstrap Core JavaScript -->
<script src="js/bootstrap.min.js"></script>

<script type="text/javascript">
function showList(product) {
    alert("hi ni hu");
    var xmlhttp;
	if (window.XMLHttpRequest)
	  {// code for IE7+, Firefox, Chrome, Opera, Safari
	  xmlhttp=new XMLHttpRequest();
	  }
	else
	  {// code for IE6, IE5
	  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	  }
	xmlhttp.onreadystatechange=function()
	  {
	  if (xmlhttp.readyState==4 && xmlhttp.status==200)
	    {
			 console.log(xmlhttp.responseText);
		    document.getElementById("name").innerHTML=xmlhttp.responseText;
		    //event.preventDefault();
		   
	    }
	  }
	
xmlhttp.open("GET","sellerBalance1?product="+product,true);
	xmlhttp.send();
	return true;
    //many other code, for a test, I moved them. and replace a alert call.
}
</script>
<%-- <script>
	function showList() {
		alert("hiii");
		document.getElementById("formStream").action = "sellerBalance1";
		document.getElementById("formStream").submit();
	}
</script> --%>
</head>
<body>
	<%-- <%@include file="SellerHome.jsp"%> --%>
	<%@include file="SellerHome.jsp"%>
	
	<table align="center">
	<thead>
	<tr>
		<th>Product Name</th>
		<th>Quantity Sold</th>
		 
		<th>Current Account Balance</th>
		</tr>
		</thead>
		<!-- </table> -->
		<tbody>
			<!-- <div class="form-group">
			<div class="row">
			<div class="col-md-3"> -->
			<tr>
			<td ><select class="form-control" name="product" id="product"
				onchange="showList(this.value);">
					<option value="select product" selected="selected">select
						Product</option>
					<s:iterator value="NameOfProduct">
						<option value="<s:property/>"><s:property />
						</option>
					</s:iterator>
			</select></td>
			<!-- <td><div class="col-md-3"></div></td> -->
			
			<td ><div id=name></div></td>
			</tr>
			
		</tbody>
		</table>
</body>
</html>