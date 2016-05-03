<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%-- <%@ include file="header.jsp" %> --%>
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<style type="text/css">
	.elegant-aero {
	margin-left: auto;
	margin-right: auto;
	max-width: 550px;
	background: #D2E9FF;
	padding: 20px 20px 20px 20px;
	font: 12px Arial, Helvetica, sans-serif;
	color: #666;
}

th {
	height: 30px;
}

#mainTab {
	width: 100%;
}

tr {
	border: solid, medium, 2px;
}

td {
	border: solid dotted, 2px;
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
	font-size: 11px;
	font: bold;
	!
	important
}

.elegant-aero label>span {
	float: left;
	margin-top: 10px;
	color: #5E5E5E;
}

.elegant-aero label {
	display: block;
	margin: 0px 0px 5px;
}

.elegant-aero label>span {
	float: left;
	width: 20%;
	text-align: right;
	padding-right: 15px;
	margin-top: 10px;
	font-weight: bold;
}

.elegant-aero input[type="text"],.elegant-aero input[type="email"],.elegant-aero textarea,.elegant-aero select
	{
	color: #888;
	width: 70%;
	padding: 0px 0px 0px 5px;
	border: 1px solid #C5E2FF;
	background: #FBFBFB;
	outline: 0;
	-webkit-box-shadow: inset 0px 1px 6px #ECF3F5;
	box-shadow: inset 0px 1px 6px #ECF3F5;
	font: 200 12px/25px Arial, Helvetica, sans-serif;
	height: 30px;
	line-height: 15px;
	margin: 2px 6px 16px 0px;
}

.elegant-aero textarea {
	height: 100px;
	padding: 5px 0px 0px 5px;
	width: 70%;
}

.elegant-aero select {
	background: #fbfbfb url('down-arrow.png') no-repeat right;
	background: #fbfbfb url('down-arrow.png') no-repeat right;
	appearance: none;
	-webkit-appearance: none;
	-moz-appearance: none;
	text-indent: 0.01px;
	text-overflow: '';
	width: 70%;
}

.elegant-aero .button {
	padding: 10px 30px 10px 30px;
	background: #66C1E4;
	border: none;
	color: #FFF;
	box-shadow: 1px 1px 1px #4C6E91;
	-webkit-box-shadow: 1px 1px 1px #4C6E91;
	-moz-box-shadow: 1px 1px 1px #4C6E91;
	text-shadow: 1px 1px 1px #5079A3;
}

.btn1 {
	position: relative;
	left: 6cm;
	top: 0.3cm;
	width: 2.5cm;
	height: .7cm;
}

#maintr {
	border: medium;
	border-bottom: medium, thick, solid;
	border-left: none;
	border-right: none;
	border-top: none;
}

.elegant-aero .button:hover {
	background: #3EB1DD;
}
</style>


</head>

<body>
	
	<div>
	<div id="nav"></div>
	<div id="nav1"></div>
	<div>
	<form action="WriteaReview" class="elegant-aero" >
	<table cellspacing="5" style="height: 6cm;width: 14cm;font-size: .4cm;" align="center">
		<tr>
		<td><h1>Help Others! Write a Flipkart  Review</h1></td>
		</tr>
		<tr><td>
		Name:
		</td>
		</tr>
		<tr>
		<td>
		<input type="text" id = "userName" name = "User"  style="width: 10cm;height: 0.7cm;">
		</td>
		</tr>
		<tr><td> </td></tr>
		<tr>
		<td>Heading:</td>
		</tr>
		<tr>
		<td><input type="text" id = "pincode" name = "Review_Heding" style="width: 10cm;height: 0.7cm;"></td>
		</tr>
		<tr><td> </td></tr>
		<tr>
		
		<tr>
		<td>Review:</td>
		</tr>
		<tr>
		<td> <textarea id = "Review"   name = "Review_Description"  ></textarea></td>
		</tr>
		<tr><td> </td></tr>
		<tr>
		<td>Rating: </td>
		</tr>
		
		<tr>
		<td><input id = "Rate" type="text"  name = "Personal_Rating" style="width: 10cm;height:0.7cm;" ></td>
		</tr>
		<tr><td></td></tr>
		<tr>
		<td>
		<button id = "WritReview" type="submit" class="btn btn-success" 
						style="background-color: orange; height: 1.0cm;" >Write Your Review</button>
		</td>
		</tr>
			</table>
		</form>
		</div>
	</div>
</body>
</html>
