<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Notification</title>
<link rel="icon" type="/favicon.png" href="images/flipkartlogo.png">
<!-- Custom styles for this template -->
<link href="css/Index.css" rel="stylesheet">
<link rel="stylesheet" href="css/jquery-ui.css">
<link href="css/starter-template.css" rel="stylesheet">
<!-- 	<link rel="stylesheet" href="asset/CSS/login.css"> -->
<link rel="stylesheet" href="css/reveal.css">
<link rel="stylesheet" href="css/notification.css">

<!-- Bootstrap core CSS -->
<link href="css/bootstrap.css" rel="stylesheet">
<!-- Bootstrap theme -->
<link href="css/bootstrap-theme.min.css" rel="stylesheet">
<script src="JavaScripts/jquery-2.0.3.js"></script>
<script src="JavaScripts/bootstrap.min.js"></script>
<script src="JavaScripts/drophover.js"></script>
<script src="JavaScripts/jquery-ui.js"></script>
<script src="JavaScripts/jquery.reveal.js"></script>
<style type="text/css">
li.padding {
	color: #848484;
	padding: 1cm 0 2px 4px;
	font-size: 15px;
	font-weight: bold;
}

li.padding2:hover {
	color: #2271B2;
	text-decoration: none;
	background-color: #F4F4F4;
}

a.padding3 {
	padding: 4px 0 4px 6px;
	display: block;
	cursor: pointer;
	color: #666666;
}

.notification-read {
	background-color: #F6F6F6;
}

.line,.lastUnit {
	overflow: hidden;
}

.rpadding10 {
	padding-right: 10px;
}

.bpadding10 {
	padding-bottom: 10px;
}

.lpadding15 {
	padding-left: 15px;
}

.tpadding10 {
	padding-top: 10px;
}

.lastUnit {
	float: none;
	width: auto;
}

.notification-text {
	color: #000000;
	float: left;
}

.tpadding5 {
	padding-top: 5px;
}

.notification-timestamp {
	color: #808080;
	float: right;
	font: 13px arial;
}
</style>



</head>

<body>

	<%@include file="/header.jsp"%>
<div id="fk-mainbody-id" class="fk-mainbody fksk-mainbody   ">

			<div class="fk-content fksk-content enable-compare">

				<div class="gd-row">
					<div class="gd-col gu16">
						<div id="oos-reco-module" class="fk-hidden"></div>
					</div>
				</div>
				<div class="gd-row">
					<div class="gd-col gu16">
	
		
				</div>
				</div>
				<!-- i think ki yha se disply hongi sarijjjjjjjjjjjjj chije -->
				<!-- sb log apne code ko iske andr likho jisse gui sahi ho ske ..
				jise do part me chahiye h vo ye wala use kre for left -->
				<div class="gd-row">
					<div class="gd-col gu16 top-section">
						<div id="fk-compare-cart-holder" class="hide">
							<div id="fk-compare-cart" class="static "></div>
							<div class="clear"></div>
						</div>
						<div class="left-col-wrap unit">
							<div class="left-col">
	<div class="col-md-10" style="background-color: #FFFFFF">


		

			<ul style="list-style-type: none">
				<li
					style="background-color: #014A72; color: #FFFFFF; font-size: 16px; font-weight: bold; padding: 1px 5px 1px 9px;"><h4>My
						Account</h4></li>
				<li class="padding"><h4>ORDERS</h4></li>
				<li class="padding2"><a class="padding3" href="MyOrders">My
						Orders</a></li>
				<li class="padding"><h4>SETTINGS</h4></li>
				<li class="padding2"
					style="font-weight: bold; padding: 4px 0 4px 6px"><s:url
						id="url" action="get"></s:url> <s:a href="%{url}" class="padding3">Personal Information</s:a>
				</li>

				<li class="padding2"style="padding: 4px 0 4px 6px"><a class="padding3"
					href="Change_Password.jsp">Change Password</a></li>
				<li class="padding2" ><s:url id="url" action="fetchaddress"></s:url>
					<s:a href="%{url}" class="padding3">Addresses</s:a></li>

				<li class="padding2"><a class="padding3"
					href="Update_email.jsp">Update Email</a></li>
				<li class="padding2"><a class="padding3"
					href="Deactive_Account.jsp">Deactivate Account</a></li>
				<li style="font-weight: bold; padding: 4px 0 4px 6px"
					class="padding2">Notifications</li>

			</ul>
			
			</div></div>
						</div>
						<div class="right-col-wrap lastUnit">
							<div class="right-col lpadding20 line">
								<div class="product-details line">
			<h3>Notifications</h3>
			<br>
		 <strong> No notifications are available as of now.
				Kindly check again later.</strong>
				
				
				
			
		</div>
		</div></div>
							</div>
						</div>
					</div>
				</div>

 <%@include file="/footer.jsp"%>
</body>
</html>
				
</body>
</html>