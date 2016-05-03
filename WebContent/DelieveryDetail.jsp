<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<style type="text/css">
.elev {
	position: relative;
	padding-left: 5cm;
	padding-right: 5cm;
	padding-top: 10cm;
	height: 15cm;
	top: -10cm;
}

.extra {
	height: 1cm;
}
</style>

</head>

<body>
	<div class="extra"></div>
	<div class=".elev" align="center">
		<form action="AddDelieveryDetail">
			<table cellspacing="5"
				style="background-color: #e0e0d1; height: 6cm; width: 14cm; font-size: .4cm;">
				<tr>
					<td><h2>Delievery Details</h2></td>
				</tr>
				<tr>
					<td>Name:</td>
					<td><input type="text" id="userName" name="userName"></td>

				</tr>
				<tr>
					<td>Pin code:</td>
					<td><input type="text" id="pincode" name="pincode"></td>
				</tr>


				<tr>
					<td>Address:</td>
					<td><input id="address" type="text" name="address"></td>
				</tr>

				<tr>
					<td>City:</td>
					<td><input id="city" type="text" name="city"></td>
				</tr>

				<tr>
					<td>State:</td>
					<td><input id="State" type="text" name="State"></td>
				</tr>

				<tr>
					<td>Phone +91:</td>
					<td><input id="phone" type="text" name="phone"></td>
				</tr>



				<tr>
					<td></td>
					<td>
						<button id="Add_Detail" type="submit" class="btn btn-success"
							style="background-color: orange; height: 1.0cm;">Add_Detail</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
