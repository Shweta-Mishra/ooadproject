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
	Its sellerProduct.jsp
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
					<form class="form-horizontal" method="post"
							action="InsertSellerProduct" enctype="multipart/form-data">
								<div class="form-group">
								<label  class="col-sm-2 control-label"> Recent SP
									ID:</label>
								<label  class="col-sm-2"><s:property value="SP_id"  /> </label>
								
								
							</div>
							
							<div class="row">

								<div class="form-group">

									<label for="SP_ID" class="col-sm-2 control-label">
										SP_ID </label>
									<div class="col-sm-3">
										<input type="text" class="form-control" name="SP_ID"
											placeholder="Enter SP_ID" size="50" />
									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="row">
									<div class="col-md-12">
										<label for="selectproduct" class="col-sm-2 control-label">Select
											product</label>

										<!-- <div style="height: 8cm; overflow: scroll;"> -->
										<select name="Item_name">
											<s:iterator value="arrInsertProductModel"> -
									
									<option value="<s:property value="Item_name"/>"><s:property
														value="Item_name" />
												</option>
											</s:iterator>
										</select>
										<!-- </div> -->
									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="row">
									<div class="col-md-12">
										<label for="Seller_name" class="col-sm-2 control-label">Select
											seller</label>

										<!-- <div style="height: 8cm; overflow: scroll;"> -->
										<select name="Seller_name">
											<s:iterator value="arrSellersInfoModel"> -
									
									<option value="<s:property value="Seller_name"/>"><s:property
														value="Seller_name" />
												</option>
											</s:iterator>
										</select>
										<!-- </div> -->
									</div>
								</div>
							</div>
							<div class="row">

								<div class="form-group">

									<label for="Price" class="col-sm-2 control-label">
										Price </label>
									<div class="col-sm-3">
										<input type="text" class="form-control" name="Price"
											placeholder="Enter Price" size="50" />
									</div>
								</div>
							</div>
							<div class="row">

								<div class="form-group">

									<label for="Stock" class="col-sm-2 control-label">
										Stock </label>
									<div class="col-sm-3">
										<input type="text" class="form-control" name="Stock"
											placeholder="Enter Stock" size="50" />
									</div>
								</div>
							</div>
							<div class="row">

								<div class="form-group">

									<label for="Deliverycharge" class="col-sm-2 control-label">
										Delivery charge </label>
									<div class="col-sm-3">
										<input type="text" class="form-control" name="Deliverycharge"
											placeholder="Enter Delivery charge" size="50" />
									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-offset-2 col-sm-3">
									<button type="submit" class="btn btn-default">OK</button>
								</div>
							</div>

						</form>
<a href="CallOfferZone">OfferZone</a>
<p>above is the link</p>

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


