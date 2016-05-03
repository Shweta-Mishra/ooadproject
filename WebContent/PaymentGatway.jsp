<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="css/bootstrap.min.css">
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<style type="text/css">
#nav {
	line-height: 100%;
	background-color: #dddddd;
	height: 15cm;
	width: 150px;
	float: left;
	padding: 5px;
	position: relative;
	top: +20cm;
}

#n1 {
	line-height: 100%;
	background-color: #ffffff;
	width: 200px;
	float: left;
	padding: 5px;
	height: 8cm;
	font-size: 0.8cm;
	color: fcfcfc;
}

#nav1 {
	line-height: 100%;
	background-color: #eeeeee;
	height: 15cm;
	width: 150px;
	float: right;
	padding: 5px;
}
</style>

<style type="text/css">
.pay {
	position: relative;
	top: 10cm;
	padding-top: 13cm;
	background-color: blue;
	height: 10cm;
	width: 10cm;
}
</style>

<script type="text/javascript">
	function abc() {
		alert();
		$('#pay').load('./CreditCard1.jsp');
		
	}
	</script>

<script type="text/javascript">
	function Debit() {
		alert();
		$('#pay').load('./DebitCard1.jsp');
		
	}
	</script>

<script type="text/javascript">
	function NetBanking() {
		alert();
		$('#pay').load('./NetBanking1.jsp');
		
	}
	</script>


<script type="text/javascript">
	
	function NetBanking() {
		alert();
		$('#pay').load('./NetBanking1.jsp');
		
	}
	$(document).ready(function() {
	$("#COD").click(function(){
		$.ajax({
			type:"GET",
			url:"CartBill",
			data:{
				
			},
			success : function(data) {
				
			}
		});
	});
	});
	</script>

</head>
<body>



	<div class="col-md-2" align="left">



		<div id="sidebar-wrapper" align="center">
			<ul class="sidebar-nav">
				<button name="Credit Card" type="button" value="Credit Card"
					style="width: 200px; height: 1.5cm; border-bottom-style: solid;"
					onclick="abc()">Credit Card</button>


				<button name="Net Banking" type="submit" value="Net Banking"
					style="width: 200px; height: 1.5cm; border-bottom-style: solid;"
					onclick="NetBanking()">Net Banking</button>


				<button name="Debit Card" type="submit" value="Debit Card"
					style="width: 200px; height: 1.5cm; border-bottom-style: solid;"
					onclick="Debit()">Debit Card</button>
				<form action="CartBill">
					<button name="COD" type="submit" value="COD"
						style="width: 200px; height: 1.5cm; border-bottom-style: solid;"
						onclick="COD()" id="COD">COD</button>
				</form>
			</ul>
		</div>
	</div>

	<div id="pay" align="center"></div>


	<!--  <div id = "nav">
		
	</div>
	<div id = "n1">
		<button name="Credit Card" type="button" value="Credit Card" style="width: 200px;height: 1.5cm; border-bottom-style: solid;" onclick="abc()" >Credit Card</button>
		<button name="Net Banking" type="submit" value="Net Banking" style="width: 200px;height: 1.5cm; border-bottom-style: solid;" onclick="NetBanking()">Net Banking</button>
		<button name="Debit Card" type="submit" value="Debit Card" style="width: 200px;height: 1.5cm;border-bottom-style: solid;" onclick="Debit()">Debit Card</button>
		<button name="COD" type="submit" value="COD" style="width: 200px;height: 1.5cm;border-bottom-style: solid;">COD</button>
	</div>
		<div id = "nav1">
	
	</div>
	<div id = "pay">
	
	</div>
	
	<div id = "pay1">
	
	</div>
 -->
</body>
</html>
