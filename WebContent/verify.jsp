<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<style>
/* Elegant Aero */
.elegant-aero {
	margin-left: auto;
	margin-right: auto;
	max-width: 1150px;
	background: #D2E9FF;
	padding: 20px 20px 20px 20px;
	font: 12px Arial, Helvetica, sans-serif;
	color: #666;
}

.elegant-aero h1 {
	font: 24px "Trebuchet MS", Arial, Helvetica, sans-serif;
	padding: 10px 10px 10px 20px;
	display: block;
	background: #C0E1FF;
	border-bottom: 1px solid #B8DDFF;
	margin: -20px -20px 15px;
	font: 18px Arial, Helvetica, sans-serif bold;
	!
	important
}

.elegant-aero h1>span {
	display: block;
	font-size: 15px;
	font: bold;
	!
	important
}
</style>
<script>
function verify() {
    var x = document.forms["verification"]["first"].value;
   // alert("s is"+x);
    var y = document.forms["verification"]["second"].value;
    //alert("z is"+y);
    if (y==0)
    {
        alert("Please enter proper value");
        return false;
    } 
}
</script>
<script>
	function refreshPage() {
		window.location.reload();
	}
</script>
</head>
<body>
	<%
		Random randomGeneratorP = new Random();
		int t = randomGeneratorP.nextInt(95236471);
		;
	%>
	<h1 class="elegant-aero">Please Enter Number Displayed in TextBox</h1>
	<form action="Bill" name="verification"  class="elegant-aero " onsubmit="return verify()" method="get">

		<input type="text" readonly="readonly" value=" <%=t%>" name="first">
		<button type="button" onClick="refreshPage()">Change</button>

		<br> <br> <input type="text" name="second"> <br> <br> <input
			type="submit">
	</form>

</body>
</html>

