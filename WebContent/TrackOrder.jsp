<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="js/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
<head>
<meta http-equiv="Content-Type"
	content="application/xhtml+xml; charset=utf-8" />
<title>Flipkart</title>
<!--
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
    -->

<meta name="robots" content="noodp" />
<link rel='shortcut icon' href='images/shortcut icon.ico' />

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!--  <meta http-equiv="X-UA-Compatible" content="IE=edge">-->
<meta name="viewport" content="width=device-width, initial-scale=1">

<link href="css/bootstrap.min.css" rel="stylesheet">


<title>Track Order</title>
</head>
<body>
	<%@include file="/header.jsp"%>

	<div class="newMenu  fkart fksk-body line  ">

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
				<!--  	<p>In the body</p>-->

				<!-- i think ki yha se disply hongi sari chije -->
				<div class="gd-row">
					<div class="gd-col gu16 top-section">
						<div id="fk-compare-cart-holder" class="hide">
							<div id="fk-compare-cart" class="static "></div>
							<div class="clear"></div>
						</div>
						<p>In the body</p>


						<div>
							<s:iterator value="OrderList">
								<div class="panel panel-default">
									<div class="panel heading">
										<h2 class="bg-info" class="panel-title">
											<a
												href="getOrderDetail?Order_Id=<s:property value="Order_Id"/>"
												class="btn btn-primary"> <s:property value="Order_Id" />
											</a>
										</h2>


									</div>
									<div class="form-group">
										<div class="panel-body">
											<table class="table">
												<tr>
													<td></td>
													<td>Name:<b><s:property value="Product_Name" /> </b></td>
													<td>price:<b><s:property value="price" /></b></td>
													<td>Status:<b><s:property value="Status" /></b></td>
												</tr>
											</table>
										</div>


										<div class="panel-footer">
											<div class="pull-left">
												<h6>
													Seller Name:
													<s:property value="seller_name" />
												</h6>
											</div>
											<div class="pull-right">
												<h6>
													Order Total:<b><s:property value="total" /></b>
												</h6>
											</div>
										</div>
									</div>
								</div>
							</s:iterator>
						</div>




					</div>
				</div>

			</div>
		</div>



	</div>

	<%@include file="/footer.jsp"%>
</body>
</html>