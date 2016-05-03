<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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

</head>
<body class="product">
	<%@include file="AdminHome.jsp"%>


	<!-- main body part where we disply all things -->
	<div id="fk-mainbody-id" class="fk-mainbody fksk-mainbody   ">

		<div class="fk-content fksk-content enable-compare">

			<div class="gd-row">
				<div class="gd-col gu16">
					<div id="oos-reco-module" class="fk-hidden"></div>
				</div>
			</div>
			<div class="gd-row">
				<div class="gd-col gu16"></div>
			</div>


		</div>

	</div>
	<div class="col-sm-4 "></div>
<div class="col-sm-8 ">
	<div id="fk-mainbody-id" class="fk-mainbody fksk-mainbody"
		class="gd-col gu16">
		<div class="fk-content fksk-content enable-compare">
			<div class="gd-row">
				<div class="gd-col gu16">
					<div id="oos-reco-module" class="fk-hidden"></div>
				</div>
			</div>
			<div class="gd-row">
				<div class="gd-col gu16"></div>
			</div>
			<div class="gd-row">
				<div class="gd-col gu16 top-section">
					<form class="form-horizontal" method="post" action="sellersInfo">
								<div class="form-group">
								<label  class="col-sm-2 control-label"> Recent SP
									ID:</label>
									<label  class="col-sm-2"><s:property value="Seller_ID"  /> </label>
								
							
							</div>
						<div class="form-group">
							<label for="Seller_ID" class="col-sm-2 control-label">Seller
								ID:</label>
							<div class="col-sm-5 ">
								<input type="text" class="form-control" name="Seller_ID"
									placeholder="Enter Seller id" id="Seller_ID" />
							</div>
						</div>
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">Seller
								name:</label>
							<div class="col-sm-5 ">
								<input type="text" class="form-control" name="Seller_name"
									placeholder="ENTER your name" id="Seller_name" />
							</div>
						</div>
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">Seller
								Location:</label>
							<div class="col-sm-5 ">
								<input type="text" class="form-control" name="Seller_Location"
									placeholder="ENTER your Location" id="Seller_Location" />
							</div>
						</div>
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">ENTER
								Phone Number</label>
							<div class="col-sm-5 ">
								<input type="text" class="form-control" name="Phone"
									placeholder="ENTER your Phone number" id="Phone" />
							</div>
						</div>
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">ENTER
								PASSWORD</label>
							<div class="col-sm-5 ">
								<input type="text" class="form-control" name="PASSWORD"
									placeholder="ENTER your PASSWORD" id="PASSWORD" />
							</div>
						</div>
						


							<div class="form-group">
							<div class="col-sm-offset-2 col-sm-3">
								<input type="submit" class="btn btn-default" value="ADD" />
							</div>
						</div>

					</form>


					<br>
					<br>
					<br>
					<br>
					<br>
					<br>
					<br>
					<br>
					<br>
					<br>
					<br>
					<br>
					<br>
					<br>
					<br>
							</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>

