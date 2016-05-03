<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="en-IN">

<head>
<meta http-equiv="Content-Type"
	content="application/xhtml+xml; charset=utf-8" />
<title>Online Shopping - Shop Online for Mobile Phones, Digital
	Cameras, Watches, Books and More at Flipkart.com</title>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<link rel='shortcut icon' href='images/shortcut icon.ico' />
<link href="css/bootstrap.css" rel="stylesheet" />
<script src="JavaScripts/jquery-2.0.3.js"></script>
<script src="JavaScripts/bootstrap.min.js"></script>

<script src="JavaScripts/jquery-ui.js"></script>
<script src="JavaScripts/jquery.min.js"></script>
<script src="JavaScripts/blockUI.js"></script>

<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery-ui.js"></script>
<script src="js/jquery-1.9.1.min.js"></script>

<link href="css/bootstrap-theme.min.css" rel="stylesheet" />
<link href="css/codebeautify.css" rel="stylesheet" />
<link href="css/codebeautify1.css" rel="stylesheet" />
<link href="css/codebeautify3.css" rel="stylesheet" />

<link rel="stylesheet" href="css/jquery-ui.css" />
<link rel="stylesheet" href="style.css" />
<script>
function myFunction() {
    var x = document.getElementById("fname");
    x.value = x.value.toUpperCase();
}
</script>


<script type="text/javascript">
function sort(pricesort) {
 
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
			 //console.log(xmlhttp.responseText);
				
				
		    document.getElementById("sortdiv").innerHTML=xmlhttp.responseText;
		    //event.preventDefault();
		   
	    }
	  }
//alert(pricesort);
xmlhttp.open("GET","BrowseProductSort?sorttype="+pricesort,true);
	xmlhttp.send();
	return true;
    //many other code, for a test, I moved them. and replace a alert call.
}
</script>



<script type="text/javascript">
 function FocusOnInput()
 {
 document.getElementById("search").focus();
 }
 </script>



<script type="text/javascript">
	$(document).ready(function(){
		$("#newdivision").hide();
	});
</script>

<script type="text/javascript">
	$(document).ready(function(){
		$(".filters").change(function(event)
			{
			name();
		});
	});
</script>

<script type="text/javascript">
	$(document).ready(function(){
		$(".filtersprice").change(function(event)
			{
			name();
		});
	});
</script>
<%-- <script type="text/javascript">
   $.noConflict();
	var flag=true;
 $(document).ready(function() {
	 
	 $(function() { 
		// alert("hello disha i am inside function");
		 var uppercategoryname="";
			var temp='';
	
			$("#Electronics").mouseover(function(){
				  uppercategoryname="Electronics";
					if(flag)
					{		
				$.ajax({
					url  : 'fetchcat',
					type : 'GET',
					data : {
						supercatg :uppercategoryname
					},
				dataType : "json",
					
					success :	function(data){
						
					var count=data.fetchcat;
					var index;
					   
					    	for (index = 0; index < count.length; index++) {
  
      		temp += '<a href="BrowseProduct?uppercategoryname='+uppercategoryname+'&categoryname='+count[index]+'">';
					   		temp += count[index] ;
					  			    	temp += '</a>';
					  			    	temp+='<br>';
								

    }
 
					    	$('#submenu_electronics').show();
					    	$('#submenu_electronics').html(temp);
					
					    }});
						
		}
						flag=false;

			
			});
						

 });
	
		});
 </script>
 --%>

<%-- <script type="text/javascript">
$.noConflict();
function sort(pricesort)
{
	alert("in sort");
	var temp='<b> Showing all the products in the category </b><br><br>';

			 $.ajax({
				    type: 'POST',
				    contentType : "application/x-www-form-urlencoded; charset=utf-8",
				    data : {
				    	sorttype:pricesort,  
				    },
				    url:'BrowseProductOnFilters',
				    success: function(data){
				  
				    	$.each(data.productinfo, function(count, product) 
				    	{
				    		
				    		temp += '<div class="col-md-4"><div class="border"><center>';
				   	if(product.stock == 0)
							{
				    		//	temp += '<a href="#">';
				    			temp += '<img src ="'+product.image+'"  height="140px" width="auto" /><br>';
				    			temp += '<img src="images/sold_out.jpg" alt="Sold Out" height="40px">';
				    		//	temp += '</a>';
							}
				    		else
				    		{
				    				
				    					temp += '<a href="productSample?pid='+product.product_id+'">';
				    					temp += '<img src ="'+product.image+'" alt="'+product.product_id+'"  height="140px" width="auto" /> <br><br><br>';
						    			temp += '</a>';
				    				
				    		}
				    			
					    	temp += '<hr>';
					    	temp += '<div class="giveMeEllipsis">';
				 temp += '<a href="productSample"?pid=<s:property value="product.product_id+"/>">';
					    	temp += '<font size="4" color="black">'+product.product_name+'</font><br></a></div>';
					    	
					    	temp += '<font size="4" color="black"> '+product.product_description+'</font><br>';
					    	temp += '<hr><div style="height:40px">';
				    				temp += '<font size="4px" color="#76553B"> Rs.'+product.price+'</font><br>';
				    	
					    	temp += '</div><hr>';
					  
					    	
							temp += '<br><br>';
					    	temp += '</center></div></div>';
					    	
				    	});
				    	$("#newdivision").show();
				    	$("#newdivision").append(temp);
				    	
				    	temp = '';
				    }
				    });
			 $("#dataappended").hide();
		}
	
	
</script>
 --%>






<script type="text/javascript">
function name()
{
	var temp='<b> Showing all the products in the category </b><br><br>';
	var pId = [];
	var price = [];	
	var cnt = $("input[name='checkbox']:checked").length;
	var cnt1 = $("input[name='checkboxprice']:checked").length;
	if(cnt > 0 || cnt1 > 0)
		{
			$("#newdivision").empty();
			$(".filters").each(function() {
				if ($(this).is(':checked')) {
					  pId.push($(this).attr("brandname"));
				   }
			});
			$(".filtersprice").each(function() {
				if ($(this).is(':checked')) {
					 price.push($(this).attr("price"));
					}
			});	
			var categoryname = $("#categoryname").val();
			//alert(categoryname);
			 $.ajax({
				    type: 'POST',
				    contentType : "application/x-www-form-urlencoded; charset=utf-8",
				    data : {
				    	brand : pId.join(","),
				    	price : price.join(","),
				    	categoryname : categoryname,
				    	count : cnt,
				    	countprice : cnt1
				    },
				    url:'BrowseProductOnFilters',
				    success: function(data){
				    	$.each(data.productinfo, function(count, product) 
				    	{
				    		temp += '<div class="col-md-4"><div class="border"><center>';
				   	if(product.stock == 0)
							{
				    		//	temp += '<a href="#">';
				    			temp += '<img src ="'+product.image+'"  height="140px" width="auto" /><br>';
				    			temp += '<img src="images/sold_out.jpg" alt="Sold Out" height="40px">';
				    		//	temp += '</a>';
							}
				    		else
				    		{
				    				
				    					temp += '<a href="productSample?pid='+product.product_id+'">';
				    					temp += '<img src ="'+product.image+'" alt="'+product.product_id+'"  height="140px" width="auto" /> <br><br><br>';
						    			temp += '</a>';
				    				
				    		}
				    			
					    	temp += '<hr>';
					    	temp += '<div class="giveMeEllipsis">';
				 temp += '<a href="productSample"?pid=<s:property value="product.product_id+"/>">';
					    	temp += '<font size="4" color="black">'+product.product_name+'</font><br></a></div>';
					    	
					    	temp += '<font size="4" color="black"> '+product.product_description+'</font><br>';
					    	temp += '<hr><div style="height:40px">';
				    				temp += '<font size="4px" color="#76553B"> Rs.'+product.price+'</font><br>';
				    	
					    	temp += '</div><hr>';
					  
					    	
							temp += '<br><br>';
					    	temp += '</center></div></div>';
					    	
				    	});
				    	$("#newdivision").show();
				    	$("#newdivision").append(temp);
				    	
				    	temp = '';
				    }
				    });
			 $("#dataappended").hide();
		}
	else{
			$("#dataappended").show();
			$("#newdivision").empty();
		}
	}
</script>


</head>

<body class="product"">
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
					<div class="gd-col gu16">


						<div class="container">

							<div class="col-md-2 ">
								<div class="background">

									<br><br>
											<h4>
												<b>BROWSE</b>
											</h4> <br />

											<h5>
												<b><s:property value="uppercategoryname" /></b>
											</h5> <br /> <span class="glyphicon glyphicon-menu-down"
											aria-hidden="true"></span> <a
											href="BrowseProduct?uppercategoryname=<s:property value="uppercategoryname"/>&categoryname=<s:property value="categoryname"/>">


												<font color="black"> <s:property value="categoryname" />
											</font> </img>
										</a> <br />


											<hr noshade>
												<h5>
													<b>REFINE</b>
												</h5>
												<hr>
													<h5>Price</h5>
													<hr>
														<form>
															<input type="checkbox" class="filtersprice"
																name="checkboxprice" id="range" price="1"> Rs.
																2000 and Below<br> <input type="checkbox"
																	class="filtersprice" name="checkboxprice" id="range"
																	price="2"> Rs. 2001 - Rs. 5000<br> <input
																			type="checkbox" class="filtersprice"
																			name="checkboxprice" id="range" price="3">
																				Rs. 5001 - Rs. 10000<br> <input type="checkbox"
																					class="filtersprice" name="checkboxprice"
																					id="range" price="4"> Rs. 10001 - Rs. 18000<br>
																							<input type="checkbox" class="filtersprice"
																							name="checkboxprice" id="range" price="5">
																								Rs. 18001 - Rs. 25000<br> <input
																									type="checkbox" class="filtersprice"
																									name="checkboxprice" id="range" price="6">
																										Rs. 25001 - Rs. 35000<br> <input
																											type="checkbox" class="filtersprice"
																											name="checkboxprice" id="range" price="7">
																												Rs. 35001 and Above 
														</form>

														<input type="hidden" id="categoryname"
															value="<s:property value="categoryname"/>">
															<hr>
																<h5>Brand</h5>
																<hr>
																	<s:iterator value="brandnames">

																		<input type="checkbox" id="brand" name="checkbox"
																			class="filters" brandname="<s:property />"> <s:property />
																			<br>
																	</s:iterator>
																	<hr>

																		<br> <br> <br>
								</div>
							</div>

							<div class="col-md-8 background" id="dataappended">
								<b> Showing all the products in the category </b><br> <br>
										<div align="right">
											<form name="termDDL">
												sort by:
												<select name="pricesort" class="sort" id="pricesort" onchange="sort(this.value)"> 
												
												<option
														value="ASC,<s:property value="categoryname"/>,<s:property value="lastcategoryname"/> ,">price:low to high</option>
													<option value="DESC,<s:property value="categoryname"/>,<s:property value="lastcategoryname"/> ,">price:high to low</option>

												</select>
											</form>
											
										</div> 
										<div id=sortdiv><s:iterator value="products">
											<div class="col-md-4">
												<div class="border">
													<br> <center> <s:if test="%{stock == 0}">
															<a href="#"> <img src="<s:property value="image"/>"
																alt="<s:property value="product_id"/>" height="140px"
																width="auto"><br> <img
																		src="images/sold_out.jpg" alt="outofstock"
																		height="40px"></a>
														</s:if> <s:if test="%{stock != 0}">
															<s:if test="%{stock >= 0}">

																<a
																	href="productSample?pid=<s:property value="product_id"/>">
																	<img src="<s:property value="image"/>"
																	alt="<s:property value="product_id"/>" height="140px">
																		<br> <br> <br>
																</a>
															</s:if>
															<s:if test="%{stock < 0}">
																<a href="#"> <img src="<s:property value="image"/>"
																	alt="<s:property value="product_id"/>" height="140px"
																	width="auto"><br> <img
																			src="images/sold_out.jpg" alt="outofstock"
																			height="40px"></a>
															</s:if>
														</s:if>
														<div class="giveMeEllipsis">
															<a
																href="productSample?pid=<s:property value="product_id"/>">
																<font size="4" color="black"> <s:property
																	value="product_name" /></font><br>
															</a>
														</div>
														<div class="giveMeEllisis">
															<font size="1" color="black"> <s:property
																value="product_description" /></font><br>
														</div>
														<hr>
															<div style="height: 50px">

																<font size="5px" color="#76553B"> Rs. <s:property
																	value="price" /> <br><br></font>

															</div>
															<hr>




																<br> <br> <br>
														</center>
												</div>
												<br>
											</div>
										</s:iterator>
							</div></div>
							<div class="col-md-8" id="newdivision"></div>
						
						</div>

					</div>
				</div>



				<!-- main body part where we disply all things -->


			</div>

			<!-- i think ki yha se disply hongi sarijjjjjjjjjjjjj chije -->
			<!-- sb log apne code ko iske andr likho jisse gui sahi ho ske ..
				jise do part me chahiye h vo ye wala use kre for left -->
			<div class="gd-row">
				<div class="gd-col gu16 top-section">
					<div id="fk-compare-cart-holder" class="hide">
						<div id="fk-compare-cart" class="static "></div>
						<div class="clear"></div>
					</div>

				</div>
			</div>

		</div>
	</div>





	<%@include file="/footer.jsp"%>
</body>
</html>
