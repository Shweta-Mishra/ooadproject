<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
$(document).ready(function() {
	$("#Bank_Pay").click(function() {
		$("#Bank_Main").load('./bankLogin.jsp');
	});
	$("#Bank_Pay1").click(function() {
		$("#Bank_Main").load('./bankLogin.jsp');
	});
	$("#Bank_Pay2").click(function() {
		$("#Bank_Main").load('./bankLogin.jsp');
	});
	$("#Bank_Pay3").click(function() {
		$("#Bank_Main").load('./bankLogin.jsp');
	});
	$("#Bank_Pay4").click(function() {
		$("#Bank_Main").load('./bankLogin.jsp');
	});
	$("#Bank_Pay5").click(function() {
		$("#Bank_Main").load('./bankLogin.jsp');
	});
	$("#Bank_Pay6").click(function() {
		$("#Bank_Main").load('./bankLogin.jsp');
	});
	$("#Bank_Pay").click(function() {
		$("#Bank_Main").load('./bankLogin.jsp');
	});
	
	
});

</script>
<body>
	<div id="Bank_Main" class="col-md-8">
		<p>Pay using Net Banking</p>
		<br>
		<h3>Payment Method</h3>
		<table cellspacing="20">
			<tr>
				<td><button id="Bank_Pay" type="button">
						<img src="image/citi.jpeg" name="citi" height="50px" width="200px">
					</button></td>
				<td><button id="Bank_Pay1" type="button">
						<img src="image/hdfc.jpeg" name="hdfc" height="50px" width="200px">
					</button></td>
				<td><button id="Bank_Pay2" type="button">
						<img src="image/icici.jpeg" name="icici" height="50px"
							width="200px">
					</button></td>
			</tr>
			<tr>
				<td><button id="Bank_Pay3" type="button">
						<img src="image/index.png" name="Axis" height="50px" width="200px">
					</button></td>
				<td><button id="Bank_Pay4" type="button">
						<img src="image/sbi.png" name="sbi" height="50px" width="200px">
					</button></td>
				<td><button id="Bank_Pay5" type="button">
						<img src="image/kotek.jpeg" name="kotek" height="50px"
							width="200px">
					</button></td>
			</tr>
		</table>
		<br> <br>
		<form action="">
			All Bank
			<s:select id="Bank" list="#{'1':'IDBI','2':'AXIS','3':'TOY'}"
				headerValue="All Bank" headerKey="-1">

			</s:select>
			<br> <br>

			<button type="button" id="Bank_Pay6" class="btn btn-success"
				style="background-color: orange; height: 1.0cm;">Make
				Payment</button>

		</form>
	</div>
</body>
</html>