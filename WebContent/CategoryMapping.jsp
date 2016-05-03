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
							action="InsertCategoryMapping" enctype="multipart/form-data">
							<div class="row">

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
										<label for="UP_name" class="col-sm-2 control-label">Select
											upper category</label>

										<!-- <div style="height: 8cm; overflow: scroll;"> -->
										<select name="UP_name">
											<s:iterator value=" arruppercategoryModel"> -
											<option value="<s:property value="UP_name"/>"><s:property
														value="UP_name" />
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
										<label for="C_NAME" class="col-sm-2 control-label">Select
											Category</label>

										<!-- <div style="height: 8cm; overflow: scroll;"> -->
										<select name="C_name">
											<s:iterator value="arrCategoryModel"> -
											<option value="<s:property value="C_name"/>"><s:property
														value="C_name" />
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
										<label for="SC_NAME" class="col-sm-2 control-label">Select
											Sub Category</label>

										<!-- <div style="height: 8cm; overflow: scroll;"> -->
										<select name="SC_NAME">
											<s:iterator value="arrSubCategoryModel"> -
											<option value="<s:property value="SC_NAME"/>"><s:property
														value="SC_NAME" />
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
										<label for="LC_NAME" class="col-sm-2 control-label">Select
											Last Category</label>

										<!-- <div style="height: 8cm; overflow: scroll;"> -->
										<select name="LC_NAME">
											<s:iterator value="arrLastCategoryModel"> -
											<option value="<s:property value="LC_NAME"/>"><s:property
														value="LC_NAME" />
												</option>
											</s:iterator>
										</select>
										<!-- </div> -->
									</div>
								</div>
							</div>

							<div class="form-group">
								<div class="col-sm-offset-2 col-sm-3">
									<input type="submit" class="btn btn-info" value="OK"/>
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