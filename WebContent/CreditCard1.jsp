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

<script type="text/javascript">

$(document).ready(function() {
	alert("chec the func");
	$("#Continue").hide();
	$("#Credit_Pay").click(function() {
		var Card_Number = $("#Card1").val();
		var CVV = $("#CVV").val();
		alert($("#CVV").val());
		var Month = $("#Month").val();
		var Year = $("#Year").val();
		var i = 0;
		var Credit = null;
		alert("In the payment");
		alert(Card_Number);
		$.ajax({

			type : "POST",
			url : "Make_Credit_Payment",
			data : {
				card1: Card_Number,
 				month: Month,
				year: Year,
				cvv1: CVV,
				balance: Credit,
				flag:i
				
			},

			dataType : "json",
			success : function(data) {
				
						alert(data.flag);
						if(data.flag == 1){
							alert("Payment made successfull");
							$("#Continue").show();
							}
							else if(data.flag ==2){
								alert("Insufficient balance");
							}
							else if(data.flag ==4){
								alert("Out of stock");
							}
							
							else{
								alert("Transaction failed Check your email or password");
							}
				
				}

		});
	});
});


</script>

</head>

<body>
	<div class="extra"></div>
	<div class=".elev" class="col-md-8">
		<form action="">
			<table cellspacing="5"
				style="background-color: #e0e0d1; height: 6cm; width: 14cm; font-size: .4cm;">
				<tr>
					<td><h2>Credit Card Details</h2></td>
					<td></td>
				</tr>
				<tr>
					<td>Card number:</td>
					<td><input type="text" id="Card1" value="xxxx-xxxx-xxxx-xxxx"
						onclick="this.value='';"></td>
				</tr>
				<tr>
					<td>Expiration:</td>
					<td><select id="Month">
							<option>1</option>
							<option>2</option>
							<option>3</option>
							<option>4</option>
							<option>5</option>
							<option>6</option>
							<option>7</option>
							<option>8</option>
							<option>9</option>
							<option>10</option>
							<option>11</option>
							<option>12</option>
					</select> <select id="Year">
							<option>2015</option>
							<option>2016</option>
							<option>2017</option>
							<option>2018</option>
							<option>2019</option>
							<option>2020</option>
							<option>2021</option>
							<option>2022</option>
					</select></td>
				</tr>
				<tr>
					<td>CVC Number:</td>
					<td><input id="CVV" type="password" value="xxx"
						onclick="this.value='';"></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td>
						<button id="Credit_Pay" type="button" class="btn btn-success"
							style="background-color: orange; height: 1.0cm;">Make
							Payment</button>
					</td>
				</tr>
				<tr>
					<td></td>
					<td>
						<a href="CartBill"><button id="Continue" type="button" class="btn btn-success"
							style="background-color: orange; height: 1.0cm;">Exit
							</button></a>
					</td>
				</tr>
				
			</table>
		</form>
	</div>
</body>
</html>