<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Personal information</title>
<link rel="icon" type="/favicon.png" href="images/flipkartlogo.png">
<!-- Custom styles for this template -->
<link href="css/Index.css" rel="stylesheet">
<link rel="stylesheet" href="css/jquery-ui.css">
<link href="css/starter-template.css" rel="stylesheet">
<!-- 	<link rel="stylesheet" href="asset/CSS/login.css"> -->
<link rel="stylesheet" href="css/reveal.css">

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

td {
	text-align: center;
	padding: 10px;
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
				<li class="padding2"><a class="padding3" href="TrackOrder">My
						Orders</a></li>
				<li class="padding"><h4>SETTINGS</h4></li>
				<li style="font-weight: bold; padding: 4px 0 4px 6px"
					class="padding2">Personal Information</li>
				<li class="padding2"><a class="padding3"
					href="Change_Password.jsp">Change Password</a></li>
				<li class="padding2" style="padding: 4px 0 4px 6px"><s:url
						id="url" action="fetchaddress"></s:url> <s:a href="%{url}"
						class="padding3">Addresses</s:a></li>

				<li class="padding2"><a class="padding3"
					href="Update_email.jsp">Update Email</a></li>
				<li class="padding2"><a class="padding3"
					href="Deactive_Account.jsp">Deactivate Account</a></li>
				<li class="padding2" style="padding: 4px 0 4px 6px"><s:url
						id="url" action="notification"></s:url> <s:a href="%{url}"
						class="padding3">Notifications</s:a></li>

			</ul>
		</div></div>
						</div>
						<div class="right-col-wrap lastUnit">
							<div class="right-col lpadding20 line">
								<div class="product-details line">
			<h3>Personal Information</h3>
			<br>


			<script type="text/javascript">
        			var specialKeys = new Array();
        			specialKeys.push(10); //Backspace
        			function IsNumber(e) 
				{
        		    	var keyCode = e.which ? e.which : e.keyCode
            			var ret = ((keyCode >= 48 && keyCode <= 57) || specialKeys.indexOf(keyCode) != -1);
            			document.getElementById("error_phone").style.display = ret ? "none" : "inline";
            			document.getElementById("error_phone1").style.display = ret ? "none" : "inline";
            			
            			
            			return ret;
        			}
			    </script>
			<form action="update">


				<div class="form-group">
					<div class="row">
  						<div class="col-md-4"> <label for="Name" >Frist Name</label>
 						 </div>
 						 <div class="col-md-2"> <input type="text"
							class="textbox" name="firstname"
							value="<s:property value="us.firstname"/>">
 						 </div>
 						 </div></div>
 						 
 						 <div class="form-group">
					<div class="row">
  						<div class="col-md-4"> <label for="Name" >Last Name</label>
 						 </div>
 						 <div class="col-md-2"> <input type="text"
							class="textbox" name="lastname"
							value="<s:property value="us.lastname"/>">
 						 </div>
 						 </div></div>
 						 
 						 <div class="form-group">
					<div class="row">
  						<div class="col-md-4"> <label for="Name" >Mobile Number</label>
 						 </div>
 						 <div class="col-md-2"> <input type="text" id="phone"
							class="textbox" name="mobno"
							value="<s:property value="us.mobno"/>"
							onkeypress="return IsNumber(event);" ondrop="return false;"
							onpaste="return false;"><br> <span id="error_phone"
							style="color: Red; display: none">*Input digits(0-9)</span>
 						 </div>
 						 </div></div>
 						 
 						 <div class="form-group">
					<div class="row">
  						<div class="col-md-4"> <label for="Name" >Landline Number</label>
 						 </div>
 						 <div class="col-md-2"><input type="text" id="phone1"
							class="textbox" name="landlineno"
							value="<s:property value="us.landlineno"/>"
							onkeypress="return IsNumber(event);" ondrop="return false;"
							onpaste="return false;"><br> <span id="error_phone1"
							style="color: Red; display: none">*Input digits(0-9)</span>
 						 </div>
 						 </div></div>
 						 
 						 
 						 <div class="form-group">
					<div class="row">
  						<div class="col-md-4"> <label for="Name" >Gender</label>
 						 </div>
 						 <div class="col-md-2"> <select id="gender"class="form-control" style="color: Red;"		name="gender">
								<option><s:property value="us.gender" /></option>
								<option value="Female">Female</option>
								<option value="Male">Male</option>

						</select>
 						 </div>
 						 </div></div>
 						  <div class="form-group">
					<div class="row"><div class="col-md-4"> 
  						<div class="col-md-2"> 
 						 <input type="submit"
							class="btn btn-primary" value="SAVE CHANGES"></div></div></div>
				
						
			</form>
		</div>
		</div></div>
							</div>
						</div>
					</div>
				</div>

 <%@include file="/footer.jsp"%>
</body>
</html>
