<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%@ include file="header.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="css/bootstrap.min.css">
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>

<style type="text/css">
table {
	background-color: white;
	border: 1px dotted black;
}

td,tr {
	border: solid, medium, 2px;
	background-color: white;
}
</style>
<meta charset='utf-8' />
<link href="css/jquery.fancybox.css" rel="stylesheet" type="text/css" />
<script src='js/jquery-1.9.1.min.js'></script>
<script src='js/jquery.elevateZoom-2.5.3.min.js'></script>
<script src='js/jquery.fancybox.js'></script>
<style type="text/css">
#gallery_01 img {
	border: 2px solid white;
}

.active img {
	border: 2px solid #333 !important;
}
</style>
<script type="text/javascript">
	function changeImage(img) {
		var image = document.getElementById('orignal');
		image.src = img.getAttribute('src');

	}
</script>
<style type="text/css">
.setimage {
	position: relative; img .getAttribute('src');
	bottom: -1cm;
}
</style>

<style type="text/css">
#nav {
	line-height: 100%;
	background-color: #eeeeee;
	height: 150%;
	width: 131px;
	float: left;
	padding: 5px;
}

#nav1 {
	line-height: 100%;
	background-color: #eeeeee;
	height: 150%;
	width: 131px;
	float: right;
	padding: 5px;
}

#footer {
	color: white;
	clear: both;
	border-top-color: black;
	text-align: center;
	padding: 5px;
}

.pd {
	position: relative;
	top: -4cm;
}

.mid {
	
}

.table {
	position: relative;
	left: 5cm;
	width: 20cm;
	border: medium;
	border-color: black;
}

.acd {
	background-color: orange;
	size: 10cm;
	height: 1cm;
	width: 6cm;
	position: relative;
	left: -13.0cm;
	top: -6.25cm;
}

table,th,td {
	border: 1px solid black;
	border-collapse: collapse;
}

th,td {
	padding: 5px;
	text-align: left;
}

table#t01 tr:nth-child(even) {
	background-color: #eee;
}

table#t01 tr:nth-child(odd) {
	background-color: #fff;
}

table#t01 th {
	background-color: #a9a9a9;
	color: white;
}
</style>
<script type="text/javascript">
	function mouseOut() {
		var img = document.getElementById('orignal');

		img.src = dh("#orignal").src;
	}
</script>

</head>

<body>
	<div>
		<div id="nav"></div>
		<div id="nav1"></div>
		<div id="fk-mainbody-id" class="fk-mainbody fksk-mainbody   ">

			<div class="fk-content fksk-content enable-compare">

				<div class="gd-row">
					<div class="gd-col gu16">
						<div id="oos-reco-module" class="fk-hidden"></div>
					</div>
				</div>
				<div class="gd-row">
					<div class="gd-col gu16">
						<div style="width: 10cm; position: relative; display: inline;">
							<div id="img"
								style="position: relative; top: 2cm; display: inline;">


								<!-- <img src= <s:property value="destpath"/> id="destpath" height="200px" width="200px"> -->
								<img  src=<s:property value="destpath"/>
									 height="200"
									width="200" name="mainImage" /> <br> <br>
																<s:iterator value="im">
									<img id="orignal" src=<s:property value="destpath"/>
										 height="50"
										width="50" onclick="changeImage(this)" />

								</s:iterator> 


								<script>
									dh("#orignal").elevateZoom({
										gallery : 'img',
										cursor : 'pointer',
										galleryActiveClass : 'active'
									});

									//pass the images to Fancybox
									dh("#orignal")
											.change(
													function() {
														dh("#orignal")
																.bind(
																		"change",
																		function(
																				e) {
																			var ez = dh(
																					'#orignal')
																					.data(
																							'elevateZoom');
																			dh
																					.fancybox(ez
																							.getGalleryList());
																			return false;
																		});
													});
								</script>
							</div>

							<s:iterator value="productInfo">

								<div
									style="position: relative; top: -5.5cm; left: 3cm; font-size: 1cm;"
									align="center">
									<b><s:property value="productName" /> </b>
								</div>

								<div
									style="position: relative; top: -2.5cm; left: 6cm; font-size: .4cm;">
									<s:iterator value="description1">
										<li><s:property value="description" /></li>
									</s:iterator>
								</div>
								<div
									style="position: relative; top: -2.0cm; left: 7cm; font-size: 0.5cm;">
									<b>Price<br> <s:property value="price" /></b>
								</div>
								<div
									style="position: relative; top: -2.0cm; left: 7cm; font-size: 0.5cm;">
									<b>Delivery Charge<br> <s:property
											value="deliverycharge" /></b>
								</div>
								<div
									style="position: relative; top: -3.3cm; left: 7.0cm; font-size: .5cm;">


								</div>

								<div
									style="position: relative; top: -4.5cm; left: 17cm; font-size: .5cm;">
									Sold By:
									<s:property value="seller" />
								</div>

								<div
									style="display: inline; position: relative; top: -3.0cm; left: 6.5cm; font-size: .5cm;">
									<a href="email.jsp"><button type="button"
											class="btn btn-warning"
											style="background-color: green; size: 10cm; height: 1cm; width: 6cm; position: relative; top: 2cm;">BUY
											NOW</button></a>
								</div>
								<div
									style="position: relative; top: -3.2cm; left: 15.5cm; font-size: .5cm;">
									DELIVERED BY:<br> Usually Delivered in 2-3 business days
								</div>

							</s:iterator>

							<div
								style="display: inline; position: relative; top: -11.2cm; left: 7cm; font-size: .5cm;">
								Rating:
								<s:property value="Avg_Rating" />
							</div>

							<div
								style="position: relative; top: -11.6cm; left: 20cm; font-size: .5cm;">

								<a href="WriteaReview.jsp" style="background-color: white;">Write
									a review</a>
							</div>
							<div>
								<form action="AddToCart" method="get">
									<input type="text"
										style="display: none; border-color: white; color: white; border-width: 0;"
										name="SP_ID" value=<s:property value= "SP_ID" />>
									<s:submit cssClass="acd" value="AddToCart" />
								</form>
							</div>
							<div>
								<table id="t01" border="1" align="center" class="table">
									<tr>
										<th colspan="2"><p align="center"
												style="font-size: .7cm;">Features</p></th>
										<s:iterator value="Attri_List">


											<tr>

												<td width="10cm"><s:property value="Feature" /></td>
												<td width="10cm"><s:property value="F_Value" /></td>

											</tr>
										</s:iterator>
								</table>
							</div>
							<br>
							<div
								style="position: relative; left: 5cm; font-size: .5cm; font-stretch: wider;">
								<br> <b><p style="font-size: 0.7cm;">Reviews for
										the product</p> </b>
								<div>
									<s:iterator value="Reviews">
										<br>
										<div style="background-color: gray; width: 25cm;">
											Reviewer Name:
											<s:property value="User" />
										</div>
										<br>

										<p
											style="font-size: .6cm; position: relative; left: 5cm; top: -0.5cm;">
											<b><s:property value="Review_Heding" /></b>
										</p>


										<p
											style="width: 20cm; font-size: .4cm; color: black; background-color: #C6F4FF;">
											<s:property value="Review_Description" />
										</p>

										<pre style="color: red;">                        									               Rating  <s:property
												value="Personal_Rating" />
										</pre>



									</s:iterator>
								</div>

							</div>

						</div>

					</div>
				</div>
			</div>


		</div>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>