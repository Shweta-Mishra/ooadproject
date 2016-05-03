<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<style>
/* Elegant Aero */
.elegant-aero {
	margin-left: auto;
	margin-right: auto;
	max-width: 1150px;
	background: #D2E9FF;
	padding: 20px 20px 20px 20px;
	font: 12px Arial, Helvetica, sans-serif;
	color: #666;
}

th {
	height: 30px;
}

#mainTab {
	width: 100%;
}

tr {
	border: solid, medium, 2px;
}

td {
	border: solid dotted, 2px;
}

.elegant-aero h1 {
	font: 24px "Trebuchet MS", Arial, Helvetica, sans-serif;
	padding: 10px 10px 10px 20px;
	display: block;
	background: #C0E1FF;
	border-bottom: 1px solid #B8DDFF;
	margin: -20px -20px 15px;
	font: 18px Arial, Helvetica, sans-serif bold;
	!
	important
}

.elegant-aero h1>span {
	display: block;
	font-size: 11px;
	font: bold;
	!
	important
}

.elegant-aero label>span {
	float: left;
	margin-top: 10px;
	color: #5E5E5E;
}

.elegant-aero label {
	display: block;
	margin: 0px 0px 5px;
}

.elegant-aero label>span {
	float: left;
	width: 20%;
	text-align: right;
	padding-right: 15px;
	margin-top: 10px;
	font-weight: bold;
}

.elegant-aero input[type="text"],.elegant-aero input[type="email"],.elegant-aero textarea,.elegant-aero select
	{
	color: #888;
	width: 70%;
	padding: 0px 0px 0px 5px;
	border: 1px solid #C5E2FF;
	background: #FBFBFB;
	outline: 0;
	-webkit-box-shadow: inset 0px 1px 6px #ECF3F5;
	box-shadow: inset 0px 1px 6px #ECF3F5;
	font: 200 12px/25px Arial, Helvetica, sans-serif;
	height: 30px;
	line-height: 15px;
	margin: 2px 6px 16px 0px;
}

.elegant-aero textarea {
	height: 100px;
	padding: 5px 0px 0px 5px;
	width: 70%;
}

.elegant-aero select {
	background: #fbfbfb url('down-arrow.png') no-repeat right;
	background: #fbfbfb url('down-arrow.png') no-repeat right;
	appearance: none;
	-webkit-appearance: none;
	-moz-appearance: none;
	text-indent: 0.01px;
	text-overflow: '';
	width: 70%;
}

.elegant-aero .button {
	padding: 10px 30px 10px 30px;
	background: #66C1E4;
	border: none;
	color: #FFF;
	box-shadow: 1px 1px 1px #4C6E91;
	-webkit-box-shadow: 1px 1px 1px #4C6E91;
	-moz-box-shadow: 1px 1px 1px #4C6E91;
	text-shadow: 1px 1px 1px #5079A3;
}

.btn1 {
	position: relative;
	left: 6cm;
	top: 0.3cm;
	width: 2.5cm;
	height: .7cm;
}

#maintr {
	border: medium;
	border-bottom: medium, thick, solid;
	border-left: none;
	border-right: none;
	border-top: none;
}

.elegant-aero .button:hover {
	background: #3EB1DD;
}
</style>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script src="js/jquery.min.js"></script>
<script>
	$(document)
			.ready(
					function() {
						
						var STOCK = null;
						$("#SubmitEmail")
								.click(
										function() {
											var email = $("#email").val();
											var password = $("#Password").val();
											var flag = 0;
											$
													.ajax({
														type : "POST",
														url : "VerifyEmail",
														data : {
															email : email,
															password : password,
															flag : flag
														},
														dataType : "json",
														success : function(data) {
															alert(data.flag);
															if (data.flag == 1) {
																$("#email111")
																		.slideUp();
																$(
																		"#delivery111")
																		.slideDown();
																$("#EditEmail")
																		.show();
																$(
																		"#mail_header")
																		.text(
																				$(
																						"#email")
																						.val());
																$(
																		"#mail_header")
																		.css(
																				"color",
																				"#808080");
															} else {
																$(
																		"#mail_header")
																		.text(
																				"Invalid Email Id or Password Please try again!");
																$(
																		"#mail_header")
																		.css(
																				"color",
																				"red");
																$("#EditEmail")
																		.hide();
															}
														}

													});
										});
						$("#continuecart").click(function(){
							var SP_ID=$("#SP_ID").val();
							//alert(SP_ID);
							$.ajax({
								type:"GET",
								url:"OrderAgain",
								data:{
									SP_ID:SP_ID
								},
								dataType:"json",
								success : function(data) {
									
								}
							});
						});
						
						

						$(".btn2").click(function() {

							
							var destpath = null;
							var price = 0;
							var subtotal = null;
							var total = null;
							var item = null;
							var detail = null;
							var sP_ID = null;
						
							$.ajax({

								type : "POST",
								url : "orderdetail",
								data : {
									STOCK : STOCK,
									destpath : destpath,
									price : price,
									item : item,
									subtotal : subtotal,
									total : total,
									detail : detail,
									SP_ID : sP_ID
								},

								dataType : "json",
								success : function(data) {
									STOCK = data.STOCK;
									$("#qty").val(1);
									$("#item").val(data.item);
									$("#price").val(data.price);
									$("img").attr("src", data.destpath);
									$("#subtotal").val(data.price);
									$("#total").val(data.price);
									$("#detail").val(data.detail);
									sP_ID = data.SP_ID;
									alert(sP_ID);
									$("#ContShop").val(data.SP_ID);
									alert($("#ContShop").val());
								}

							});

						});
						
						$("#qty").change(function() {
							
							var qty = $("#qty").val();
							var price = $("#price").val();
							var temp = null;
							if (qty <= 0)
								{$("#qty").val(1);}
							
							else if (qty >STOCK ) {
								$("#OD")
										.text(
												"Quantity  is greater than stock !!!! ");
								alert("Stock is"+STOCK);
								$("#OD").css("color", "#808080");
								/* if(STOCK>5){
									$("#qty").val(5);
									temp = price * 5;
									$("#subtotal").val(temp);
									$("#total").val(temp);
								}*/ 
								$("#qty").val(STOCK);
								temp = price * STOCK;
								$("#subtotal").val(temp);
								$("#total").val(temp);
								
							}
							else {
								temp = price * qty;
								$("#subtotal").val(temp);
								$("#total").val(temp);
							}
							
							
						});
							$(".btn3").click(function() {
							var Total = $("#total").val();
							var qty =$("#qty").val();
							
							$.ajax({
								
								type : "POST",
								url : "updateTotal",
								data : {
									total:Total,
									qty : qty
								},

								dataType : "json",
								success : function(data) {

									alert(data.total);
									$("#order112").slideUp();
									$("#payment112").slideDown(); 
								}

							});

							
						});

					});
	$(document).ready(function() {
		$("#EditEmail").hide();
		$("#delivery111").hide();
	});
	


	$(document).ready(function() {
		$("#EditEmail").hide();
		$("#order112").slideUp();
		$("#EditAddress").hide();
		

	});
	$(document).ready(function() {
		$("#EditEmail").click(function() {
			$("#email111").slideDown();
			$("#delivery111").slideUp();
			$("#mail_header").text("Log in Again");
			$("#mail_header").css("color", "#808080");
			$("#Password").val(null);
			$(this).hide();
		});
	});
	
	$(document).ready(function() {
		$("#EditAddress").click(function() {
			$("#delivery111").slideDown();
			$("#payment112").slideUp();
			$("#Address_header").text("Edit Your Address");
			$("#Address_header").css("color", "#808080");
			$(this).hide();
		});
		
		
	});
/* 	function QuntityChange() {
		var qty = $("#qty").val();
		var price = $("#price").val();
		var temp = null;
		if (qty <= 0)
			$("#qty").val(1);
		else if (qty > 5) {
			$("#OD")
					.text(
							"YOU CAN NOT ENTER MORE THAN 5 ITEMS OF SAME TYPE SORRY !!!! ");
			$("#OD").css("color", "#808080");
			$("#qty").val(5);
			temp = price * 5;
			$("#subtotal").val(temp);
			$("#total").val(temp);
		} else {
			temp = price * qty;
			$("#subtotal").val(temp);
			$("#total").val(temp);
		}

	} */
 function abc() {

		$('#pay').load('./CreditCard.jsp');

	}
	function Debit() {
		alert("hello");
		$('#pay').load('./Debitcard.jsp');

	}
	function NetBanking() {
		alert();
		$('#pay').load('./NetBanking.jsp');

	}
</script>
<script type="text/javascript">
	function storeAddress(form) {
		var name = $("#userName").val();
		var pin = $("#pincode").val();
		
		var add = $("#address").val();
		var phn = $("#phone").val();
		var city = $("#city").val();
		
		 if ((name.length >0) && (pin.length>0) && (add.length >0) && (phn.length>0)
				&& (city.length>0) ) { 
			 if((pin.length <6)|| (pin < 100000) || (pin> 999999)){alert("Enter valid pin!!!");} 
			 else if((phn.length < 10) || (phn < 7000000000) || (phn > 9999999999)){alert("Enter valid Contact No.!!!");}
			 else{
				 var xmlhttp;
					if (window.XMLHttpRequest)
						xmlhttp = new XMLHttpRequest();
					else
						xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
					xmlhttp.onreadystatechange = function() {
						if (xmlhttp.readyState == 4 && xmlhttp.status == 200)
						
						$("#delivery111").slideUp();
						$("#order112").slideDown();
					 	$("#EditAddress").show();

						$("#headerDelivery").text("DELEVERY ADDRESS");
						
							document.getElementById("maincenter").innerHTML = xmlhttp.responseText;
					};
					xmlhttp.open("POST", "./deliveryAdd", true);
					var formData = new FormData(form);
					xmlhttp.send(formData); 
			 }
			
		}
		else 
		{
			$("#headerDelivery").text("*ALL FIELDS ARE MANDATORY PLEASE FILL CAREFULLY");
		}	
	}
</script>
<script type="text/javascript">

/* function Continue_Shop(SP_ID)
{   
	//alert("in the function");
	var xmlhttp;
	if (window.XMLHttpRequest)
	  {// code for IE7+, Firefox, Chrome, Opera, Safari
	  xmlhttp=new XMLHttpRequest();
	  }
	else
	  {// code for IE6, IE5
	  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	  }
	xmlhttp.onreadystatechange=function()
	  {
	  if (xmlhttp.readyState==4 && xmlhttp.status==200)
	    {
			 console.log(xmlhttp.responseText);
		    document.getElementById("maincenter").innerHTML=xmlhttp.responseText;
		    //event.preventDefault();
		   
	    }
	  };
	alert("open");
	xmlhttp.open("POST","ADDINCART?SP_ID="+SP_ID,true);
	alert("send");
	xmlhttp.send();
} */

</script>


</head>
<body>


	<form id="12" action="">
		<b><h1 id="header" class="elegant-aero" style="height: 0.5cm;">
				<p id="mail_header"
					style="font-size: .5cm; position: relative; top: -0.6cm;">
					BEFORE PLACE ORDER PLEASE LOGIN!!!!!!</p>
				<input type="button" id="EditEmail"
					style="position: relative; left: 25cm; top: -1.8cm; height: .8cm; width: 3.5cm;"
					value="Edit Email" />
			</h1></b>

		<div id="email111" class=" elegant-aero">
			<label> <span>Email :</span> <input type="Email" name="email"
				id="email"
				style="border-style: none; width: 10cm; height: .7cm; background-color: #f5f5f5; position: relative; top: 0.1cm;"
				placeholder="Valid Email Address" />
			</label> <label> <span>Password :</span> <input id="Password"
				type="password" name="password"
				style="border-style: none; width: 10cm; height: .6cm; background-color: #f5f5f5; position: relative; top: .1cm;"
				placeholder="Password" style="text-" />
			</label> <input type="button" id="SubmitEmail" class="btn1" value="Continue" />
		</div>
	</form>
	<form id="34" action="">
		<b><h1 id="headerDelivery" class="elegant-aero">
				DELEVERY ADDRESS
				<!--   <span>Please fill all the texts in the fields.</span> -->
			</h1></b>
		<div id="delivery111" class="elegant-aero">
			<label> <span>Name :</span> <input id="userName" type="text"
				name="userName" placeholder="Your Full Name" />
			</label> <label> <span>Pincode :</span> <input id="pincode"
				type="text" name="pincode" placeholder="Pincode" />
			</label> <label> <span>Address :</span> <textarea id="address"
					name="address" placeholder="Your Full Addresss"></textarea>
			</label> <label> <span>Country :</span><br>
				<div class="col-sm-10">
					<b><p class="form-control-static">INDIA(services available
							only in india )</p> </b>
				</div>
			</label> <label> <span>City :</span> <input id="city" type="text"
				name="city" placeholder="City" />
			</label> <label> <span>State :</span> <input id="state" type="text"
				name="State" placeholder="State" />
			</label> <label> <span>Phone : +91</span> <input id="phone"
				type="text" name="phone" placeholder="Contact NO"  required="required"/>
			</label> <label> <span>&nbsp;</span> <input type="button"
				class="btn2" value="Continue" id="Delevery_order"
				onclick="storeAddress(this.form)" />
			</label>
		</div>
		<input type="button"  id="EditAddress" 
					style="position: relative; left: 27.5cm; top: -1.6cm; height: .8cm; width: 3.5cm;"
					value="Edit Address" />
	</form>

	<form action="" method="post">
		<b><h1 class="elegant-aero">
				<p id="OD">ORDER SUMMARY</p>
			</h1></b>
		<div id="order112" style="display: none;" class="elegant-aero">
			<table id="mainTab">
				<tr id="maintr">
					<th></th>
					<th>Item</th>
					<th>Qty</th>
					<th>Price</th>
					<th>Delivery Details</th>
					<th>Subtotal</th>
				</tr>
				<tr>
					<td style="width: 10%; position: relative;"><img src=""
						width="80px" height="80px" id="img"></td>
					<td style="width: 35%; position: relative;"><input type="text"
						id="item" style="background-color: #D2E9FF; font-stretch: wider;"
						readonly="readonly">
						</p></td>
					<td style="width: 10%; position: relative;"><input type="text"
						class="textboxclass" id="qty" ></td>
					<td style="width: 20%; position: relative;"><input type="text"
						id="price" style="background-color: #D2E9FF" readonly="readonly">
						</p></td>
					<td style="width: 20%; position: relative;"><input type="text"
						id="detail" style="background-color: #D2E9FF" readonly="readonly">
						</p></td>
					<td style="width: 30% position: relative; top: auto;"><b><input
							type="text" id="subtotal" style="background-color: #D2E9FF"
							readonly="readonly"></b></td>

				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td>
					<th>Estimated Total</th>
					</td>
					<td><b><input type="text" id="total"
							style="background-color: #D2E9FF" readonly="readonly"></b>
						</p></td>
				</tr>
				<tr>
					<td></td>
					<td>
					
			<a href="header.jsp"><button type="button"
								class="btn btn-success"
								style="background-color: orange;  " id="continuecart">
								<b>< Continue Shoping</b>
							</button></a>
							</td>
					<td></td>
					<td></td>
					<td><button type="button" class="btn3"
							style="background-color: orange;"id="placeorder">
							<b>Place Order</b>
						</button></td>

				</tr>
			</table>
		</div>
	</form>

	<s:form action="" method="post">
		<b>
			<h1 class="elegant-aero">PAYMENT METHOD</h1>
		</b>
		<div id="payment112" style="display: none;" class="elegant-aero">
			<button name="Credit Card" type="button" value="Credit Card"
				style="width: 200px; height: 1.5cm; border-bottom-style: solid;"
				onclick="abc()">Credit Card</button>
			<button name="Net Banking" type="submit" value="Net Banking"
				style="width: 200px; height: 1.5cm; border-bottom-style: solid;"
				onclick="NetBanking()">Net Banking</button>
			<button name="Debit Card" type="submit" value="Debit Card"
				style="width: 200px; height: 1.5cm; border-bottom-style: solid;"
				onclick="Debit()">Debit Card</button>
		<a href="verify.jsp">	<button name="COD" type="submit" value="COD"
				style="width: 200px; height: 1.5cm; border-bottom-style: solid;">COD</button></a>

			<div id="pay"></div>


		</div>
	</s:form>


</body>
</html>
