<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Category</title>
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
							<form class="form-horizontal" method="post" action="InsertProduct" enctype="multipart/form-data">
							<div class="form-group">
								<label  class="col-sm-2 control-label"> Recent product
									ID:</label>
								<label  class="col-sm-2"><s:property value="Item_ID"  /></label>
								
							</div>
							<div class="form-group">
								<label for="inputEmail3" class="col-sm-2 control-label">Item
									ID:</label>
								<div class="col-sm-5 ">
									<input type="text" class="form-control" name="Item_ID"
										placeholder="Enter Item id" id="Item_id" />
								</div>
							</div>
							<div class="form-group">
								<label for="inputEmail3" class="col-sm-2 control-label">Item
									name:</label>
								<div class="col-sm-5 ">
									<input type="text" class="form-control" name="Item_name"
										placeholder="ENTER Item name" id="Item_name" />
								</div>
							</div>
							<div class="form-group">
								<label for="Item_Description" class="col-sm-2 control-label">ENTER
									ITEM DESCRIPTION </label>
								<div class="col-sm-5">
									<textarea rows="4" cols="50" class="form-control"
										name="Item_Description" placeholder="Enter Description Here"></textarea>
								</div>
							</div>

							<div class="form-group">
								<label for="inputPassword3" class="col-sm-2 control-label">Brand</label>
								<div class="col-sm-5">
									<input type="text" class="form-control" name="Brand"
										placeholder="ENTER Brand" id="Brand" />
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-2 control-label">Image:</label>
								<div class="col-sm-5">
									<input type="file" class="form-control" name="photo1" />
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-2 control-label">Image:</label>
								<div class="col-sm-5">
									<input type="file" class="form-control" name="photo2" />
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-2 control-label">Image:</label>
								<div class="col-sm-5">
									<input type="file" class="form-control" name="photo3" />
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-2 control-label">Image:</label>
								<div class="col-sm-5">
									<input type="file" class="form-control" name="photo4" />
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-offset-2 col-sm-3">
									<button type="submit" class="btn btn-default">ADD</button>
								</div>
							</div>

						</form>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br>					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
