<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<style type="text/css">
	.elev{
		position: relative;
		padding-left: 5cm;
		padding-right: 5cm;
		padding-top:10cm;
		height: 15cm;
		top: -10cm;
	
	}
	
	.extra{
	height: 1cm;

	}
</style>

<script type="text/javascript">

$(document).ready(function() {
	alert("chec the func");
	$("#Continue").hide();
	$("#Bank_Pay").click(function() {
		var Bank_ID = $("#Bank_Id").val();
		var Bank_Password = $("#Bank_Password").val();

		var i = 0;
		var balance = null;
		alert("In the payment");
		
		$.ajax({

			type : "POST",
			url : "Make_Bank_Payment",
			data : {
				Bank_ID:Bank_ID,	
				Bank_Password:Bank_Password,
				flag:i,
				balance:balance
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
	<div class = "extra">
		
	
	</div>
	<div class=".elev" align="center">
	<form action="">
	<table cellspacing="5" style="background-color: #e0e0d1;height: 6cm;width: 14cm;font-size: .4cm;">
		<tr>
		<td><h2>Bank Log in</h2></td>
		</tr>
		<tr>
		<td>Bank user Id:</td>
		<td><input type="text" id = "Bank_Id"></td>
		</tr>
		<tr>
		<td>Bank Password:</td>
		<td><input id = "Bank_Password" type="password"></td>
		</tr>
		
		<tr>
		<td></td>
		<td>
		<button id = "Bank_Pay" type="button" class="btn btn-success" 
						style="background-color: orange; height: 1.0cm;">Make Payment</button>
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