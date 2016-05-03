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
	<%@include file="/SellerHome.jsp"%>


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
						<form class="form-horizontal" method="post"
							action="Shipped" >
							<div class="form-group">


								<div class="row">
									<div class="col-md-12">
										<label for="selectproduct" class="col-sm-2 control-label">Select
											product</label>

										<!-- <div style="height: 8cm; overflow: scroll;"> -->
										<select name="Selectarr">
											<s:iterator value="arr"> -
									
									<option value="<s:property />"><s:property />
												</option>
											</s:iterator>
										</select>
										<!-- </div> -->
									</div>
								</div>
							</div>
							<div class="row">

								<div class="form-group">

									<label for="Status1" class="col-sm-2 control-label">
										Status </label>
									<div class="col-sm-3">
										<input type="text" class="form-control" name="Status1"
											placeholder="Enter Status" size="50" />
									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-offset-2 col-sm-3">
									<button type="submit" class="btn btn-default">OK</button>
								</div>
							</div>

						</form>


						<br> <br> <br> <br> <br> <br> <br>
						<br> <br> <br> <br> <br> <br> <br>
						<br>

					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>


