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
						<form class="form-horizontal" method="post"
							action="insertCategory" enctype="multipart/form-data">
							<div class="form-group">
								<label  class="col-sm-2 control-label"> Last category
									ID:</label>
									<label  class="col-sm-2"><s:property value="C_ID"  /></label>
								
							</div>
							
							
							<div class="form-group">
								<label for="C_ID" class="col-sm-2 control-label">category
									ID:</label>
								<div class="col-sm-5 ">
									<input type="text" class="form-control" name="C_ID"
										placeholder="Enter category id" id="C_ID" />
								</div>
							</div>
							<div class="form-group">
								<label for="inputEmail3" class="col-sm-2 control-label">category
									name:</label>
								<div class="col-sm-5 ">
									<input type="text" class="form-control" name="C_name"
										placeholder="ENTER UP name" id="C_name" />
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-offset-2 col-sm-3">
									<button type="submit" class="btn btn-default">ADD</button>
								</div>
							</div>
							<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<!-- /#wrapper -->

<%-- <div id="fk-mainbody-id" class="fk-mainbody fksk-mainbody"
			class="gd-col gu16">
			<div class="fk-csontent fksk-content enable-compare">
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
					<form class="form-horizontal" method="post" action="insertCategory" enctype="multipart/form-data">
							<div class="form-group">
								<label for="C_ID" class="col-sm-2 control-label">category
									ID:</label>
								<div class="col-sm-5 ">
									<input type="text" class="form-control" name="C_ID"
										placeholder="Enter category id" id="C_ID" />
								</div>
							</div>
							<div class="form-group">
								<label for="inputEmail3" class="col-sm-2 control-label">category name:</label>
								<div class="col-sm-5 ">
									<input type="text" class="form-control" name="C_name"
										placeholder="ENTER UP name" id="C_name" />
								</div>
							</div>
															<div class="form-group">
								<div class="col-sm-offset-2 col-sm-3">
									<button type="submit" class="btn btn-default">ADD</button>
								</div>
							</div>

						</form>
					

					
					</div>
				</div>

			</div>

		</div>


			<!-- <div class="fk-content fksk-content enable-compare">
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
											</div>
				</div>

			</div>
 -->
	

	<!-- /#wrapper -->
	
	<%@include file="/footer.jsp"%>
</body>
</html>
 --%>

</body>
</html>
