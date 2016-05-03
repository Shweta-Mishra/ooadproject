-<%@ taglib prefix="s" uri="/struts-tags"%>

<%@include file="/head.jsp"%>
<%--  <script type="text/javascript">
	var loaded=false;
	$(window).load(function(){
		if(loaded)
        	$('#myModal').modal('show');
    });
	 function AddToCart()
	{
		loaded=true;
		
	} 
</script>

</head>
<body>
	<!-- Button trigger modal -->
		<!-- Modal -->


<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true"> --%>
		<div class="modal-dialog" style="width: 1000px">
			<div class="modal-content">
					
				<div class="modal-body">
				
						<div id="fk-mainbody-id"
							class="fk-mainbody fksk-mainbody fixedBarAdded">
							<div class=" fk-content fksk-content enable-compare">
								<div id="cartPage" class="cart cartpage ">
									<div class="cart_contents newvd">
										<div class="cartpage-tabs">
											<div id="cartpage-cart-tab" class="tab selected">
												Cart( <label id="cartCount" ><s:property
														value="cartCount" />
												</label>)
											</div>
											
											
											<script type="text/javascript">
											$(document).ready(function()
											{
												var cartval=$("#cartCount").text();
												if(cartval==0)
													{
													$("#EmptyDiv").show();
													$("#EmptyDiv1").show();
													}

												else
													$("#EmptyDiv").hide();

										    });
											</script>
											
											<div class="fclear"></div>
										</div>
									</div>
								</div>
								
						

								<div id="cartpage-cart-tab-content"
									class="cartpage-tab-content cp-tab-content fixed" style="height: 12cm;overflow: scroll;">
																		
									<table class="cart-table" cellspacing="0" cellpadding="0"
										width="100%">
										<thead class="fk-uppercase cart-head">
											<tr>
												<td class="product-info head-cell" colspan="2">
													<table cellspacing="0" cellpadding="0" width="100%">
														<tbody>
															<tr>
																<td class="image-cell"></td>
																<td class="item-cell"><span class="lpadding10"><u>Item</u></span>
																</td>
															</tr>
														</tbody>
														
											
													</table>
												</td>
												<td class="qty-cell head-cell lborder"><u>Qty</u></td>
												<td class="price-cell head-cell lborder"><u>Price</u></td>
												 <td class="head-cell delivery-cell lborder"><u>Delivery-Charges</u></td>
								 
												<td class="head-cell subtotal-cell lborder"><u>Subtotal</u></td>
											</tr>
											
										</thead>
										<tbody class="fk-uppercase cart-head" >
										
											<tr><label id="EmptyDiv" hidden="true">There are no items in this cart</label></tr>
											<br>
											<tr><input id="EmptyDiv1" onclick="window.location='Home.jsp'" type="button" hidden="true" style="color: green;" value="<< Continue Shopping"></tr>
																													
											<s:iterator value="CartProducts" status="status">
											<tr>
												<td class="product-info head-cell" colspan="2">
													<table cellspacing="0" cellpadding="0" width="100%">
														<tbody>
															<tr>
															<td>
																<td class="image-cell"></td>
																<td class="item-cell"><span class="lpadding10">
																		<img src="<s:property value="productImage"/>" style="height: 180px; width: 130px;">
																		<tr><label><s:property value="P_DESCRIPTION"/></label></tr>
																		
																</span>
																<label><s:property value="P_NAME"/></label>
																<br><label><s:property value="P_BRAND"/></label>
<%-- 				<br><label><s:property value="SELLER_NAME"/></label>
 --%>																</td>
															</tr>
														</tbody>
														
													</table>
												</td>
												<td class="qty-cell head-cell lborder">


													<form class="cart-qty-form">
														<div>
															<input type="text" maxlength="3" style="width: 20px;"  id="qty" value="<s:property value="productQty" />"/>
															<label id="quantiii" hidden="true" ><s:property value="productQty"/></label>
															 <br> 
															 
												<button style="color: blue" id="myP"  onclick="DisplaySave()"> Save</button><br>
												<label id="stock" >Available Stock: <s:property value="STOCK"/></label>
															
														</div>
													</form> 
													
													<label id="stock" hidden="true" ><s:property value="STOCK"/></label>
													<label id="msg" hidden="true">Out Of Stock value</label>
													
											<label id="SP_ID" hidden="true" ><s:property value="SP_ID"/></label>
														
												</td>
												
												<td class="price-cell head-cell lborder">
												 <s:property value="PRICE" /> </td>
												 
												 <td class="head-cell delivery-cell lborder"> <s:property value="DELIVERY_CHARGES" /></td>
												<td class="head-cell subtotal-cell lborder"> 
												<s:property value="TOTAL_PRICE" /></td>
												
												<td>
												<form >
												<div class="offer-savings fk-font-14 fk-inline-block"
										style="margin-right: 20px">
										<input type="text" hidden="true" id="SP_ID" value=<s:property value="SP_ID"/>/>
										
							
										<button style="color: blue" onclick="Remove(this.value)" id="SP_ID" value=<s:property value="SP_ID"/>>REMOVE</button>
									</div>
									</form></td>
											</tr>
											
										</s:iterator>
											
										</tbody>
										
									</table>

									
								</div>


								<div class="cart-footer" style="width: 800px">
									<div align="right">
									<span class="cart_light_grey lmargin80" 
										style="font-weight: bold;">Amount Payable:</span>
											 <span class="fk-bold"><label name="AMOUNT_PAYABLE"><s:property value="AMOUNT_PAYABLE"/></label></span>
									</div>
								</div>
							</div>



						</div>
						<div class="modal-footer">
							<div class="line tmargin20 bmargin20 lmargin10 rmargin10">
								<div class="unitExt">

									<div class="fk-inline-block">
										<div class="fk-inline-block">
											<input type="button" onclick="window.location='Home.jsp'" style="color: green;" value="<< Continue Shopping">

										</div>
										<div class="fk-inline-block lmargin10">
												<input
													class="btn btn-orange btn-buy-big place-order-button no-underline"
													type="submit" value="Place Order" onclick="window.location='CartLogin.jsp'"/>
										</div>
									</div>
								</div>
							</div>

						</div>
					</div>
					<!-- /.modal-content -->
				</div>
				<!-- /.modal -->
			</div>
		</div>
	</div>
	
	
	
	<script>
			function DisplaySave() 
			{	
			var val=$("#qty").val();;
			var val2;
			val2=$("#stock").text();
			//alert(($("#SP_ID").text()));
				if (val <= 0)
				{	$("#myP").hide();
				//alert("great2");
				}
				else if(val>val2)
						{
						alert("Out of Stock Value");
						$("#msg").show();
						}
					else
						{
						$("#myP").show();
						$("#msg").hide();
						SaveQuantity($("#SP_ID").text());
						}

			}
			

			function Remove(SP_ID)
			{
					var xmlhttp;
				if (window.XMLHttpRequest)
				  xmlhttp=new XMLHttpRequest();
				else
				  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
				xmlhttp.onreadystatechange=function()
				  {
				  if (xmlhttp.readyState==4 && xmlhttp.status==200)
					    document.getElementById("modal-content").innerHTML=xmlhttp.responseText;
				  };
				xmlhttp.open("POST","Remove?SP_ID="+SP_ID,true);
				// var formData = new FormData(form);
					xmlhttp.send();
					return true;

			} 
			

			function SaveQuantity(SP_ID)
			{
				var qty=document.getElementById('qty').value;
				alert(SP_ID);
				alert(qty);
				var xmlhttp;
				if (window.XMLHttpRequest)
				  xmlhttp=new XMLHttpRequest();
				else
				  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
				xmlhttp.onreadystatechange=function()
				  {
				  if (xmlhttp.readyState==4 && xmlhttp.status==200)
					    document.getElementById("modal-content").innerHTML=xmlhttp.responseText;
				  };
				xmlhttp.open("POST","SaveQTY?SP_ID="+SP_ID+"&productQty="+qty,true);
			 //  var formData = new FormData(form);
				xmlhttp.send();
				return true;

				
				}
	</script>
	