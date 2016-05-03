<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="en-IN">

<head>
<meta http-equiv="Content-Type" content="application/xhtml+xml; charset=utf-8" />
<title>Online Shopping - Shop Online for Mobile Phones, Digital Cameras, Watches, Books and More at Flipkart.com</title>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>

<link rel='shortcut icon' href='images/shortcut icon.ico' />
<link href="css/bootstrap.css" rel="stylesheet"/>
<script src="JavaScripts/jquery-2.0.3.js"></script>
<script src="JavaScripts/bootstrap.min.js"></script>
<script src="JavaScripts/jquery-1.9.1.js"></script>
<script src="JavaScripts/jquery-ui.js"></script>
<script src="JavaScripts/jquery.min.js"></script>
<script src="JavaScripts/blockUI.js"></script>

<link href="css/bootstrap-theme.min.css" rel="stylesheet"/>
<link href="css/codebeautify.css" rel="stylesheet" />
<link href="css/codebeautify1.css" rel="stylesheet" />
<link href="css/codebeautify3.css" rel="stylesheet" />

<link rel="stylesheet" href="css/jquery-ui.css"/>
<link rel="stylesheet" href="style.css"/>
<script>
function myFunction() {
    var x = document.getElementById("fname");
    x.value = x.value.toUpperCase();
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
		//	var categoryName = $("#categoryname").val();
			
			 $.ajax({
				    type: 'POST',
				    contentType : "application/x-www-form-urlencoded; charset=utf-8",
				    data : {
				    	brand : pId.join(","),
				    	price : price.join(","),
				    	categoryName : "Mobile",
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
				    				
				    					temp += '<a href="getProductDetail?productID='+product.product_id+'">';
				    					temp += '<img src ="'+product.image+'" alt="'+product.product_id+'"  height="140px" width="auto" /> <br><br><br>';
						    			temp += '</a>';
				    				
				    		}
				    			
					    	temp += '<hr>';
					    	temp += '<div class="giveMeEllipsis">';
				//	 temp += '<a href="#?productID=<s:property value="product_id"/>">';
					    	temp += '<font size="4" color="black">'+product.product_name+'</font><br></a></div>';
					    	temp += '<hr><div style="height:50px">';
					    	
					    
				    				temp += '<font size="5px" color="#76553B"> Rs.'+product.price+'</font><br>';
				    	
					    	temp += '</div><hr>';
					    	
					   if(product.stock == 0)
							{
					    		temp += '<input type="checkbox" disabled >Add To Compare</input>';
							}
					    	else if (product.stock < 0)
					    	{
					    		temp += '<input type="checkbox" disabled >Add To Compare</input>';
					    	}
					    	else
					    	{
					    		temp += '<input type="checkbox" id="product_id" class="addtocompare" name="compare" pid="'+product.product_id+'"/>Add To Compare</input>';  
					    	}
					    	temp += '<hr>';
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
 
 
 
 
 
 
 
 
 
 
 
 
 
 

<body class="product" onload="FocusOnInput()">
	<div class="newMenu  fkart fksk-body line  ">

		<div id="fk-header">
			<div id="fk-mainhead-id" class="jank-fixed  ">
				<div class="header-topbar">
					<div class="header-content">
						<div class="unit size1of6">
							<a href="/" class="fk-text-center fk-font-11 logo-img-link fllt">
								<img width="149px" height="38px" class="logo-img retina-img" src="images/flipkart_india.png" />
								<div class="text">The Online Megastore</div>
							</a>
						</div>
						<div class="unitExt mainUnit">
							<div class="header-links unitExt">
								<ul class="link-list fk-font-12 fk-text-center required-tracking"
									data-tracking-id="ch_vn">

									<li><a href="/s/contact"> Seller </a></li>
									<li><a href="#">
									 <span class="header-track-icon"><img src="images/track.png" height="20px;" width="10px" alt="" /></span>
											Track Order
									</a></li>
									<li><a href="/notifications" id="notifications-link"
										title="Notifications" class="notifications-link yellow-bell">
										<img src="images/bell.jpg" height="25px;" width="35px" alt="" />
											<span class="notification-number notifications-count-dull"
											id="notifications-count-button">  0 </span>
									</a> 
									</li>
									<!-- agr login ni h to ye chaleg --> 
									<li><a class="signup-link" href="">Signup</a>
									</li>
									<li class="no-border"><a class="no-border js-login login-required" href="">Login</a>
									</li>
								</ul>
							</div>
							<!-- search engine -->

							<div class="fk-searchbar unit fclear">
								<form onsubmit="retrieve(this.value)" method="get" id="fk-header-search-form"
									action="search" >
									<div class="search-bar-wrap">
										<div class="search-bar">
											<div class="unit search-bar-text-wrap size5of6">
												<span class="search-bar-icon"> <img src="images/search.jpg" alt="" /></span>
 												<input type="text"id="search" name="search"
													 class="search-bar-text fk-font-13 ac_input"
													placeholder="Search for a product, category or brand"
													value=""  onchange="retrieve(this.value)"/>
														</div>
											<div class="unit search-bar-submit-wrap size1of6">
												<input type="submit"
													class="search-bar-submit fk-font-13 fk-font-bold"
													value="Search" />

											</div>
										</div>
									</div>
								</form>
								<div class="col-lg-12" id="showCourse2" align="right"></div>
								<!-- search engine close -->
								

								<!-- search bar and uske uper ko show krne k liye -->

							</div>

							<div class="unitExt cartContainer">
								<div id="panelsh">
									<div class='container fk-height-full cart-container '>
										<div class="tab-contents fk-height-full">
											<div id="cart-tab-content"
												class="tab-content fk-hidden fk-height-full"></div>
											<div id="digital-cart-tab-content"
												class="tab-content fk-height-full fk-hidden fk-font-custom">
											</div>
										</div>
									</div>
								</div>

								<div class="cart-btn-cont">
									<a class="btn btn-blue btn-cart" href="/viewcart"><img src="images/cart.png" style="margin-top:4px" height="25px" width="28px;"/>
											<span>Cart</span> <span id="item_count_in_cart_top_displayed"
										class="fk-inline-block cart-count">
										 <!-- cart search ke baju m jo value ati h usko print krane k liye -->
									</span>
									</a>
								</div>
							</div>
							
						</div>
						<div class="cls"></div>
					</div>
				</div>
				<!--  -->
				<div class="menu-header-content">
					<div class="menubar newMenu slowMenu">
						<div class="top-menu unit">
							<ul class="menu-links required-tracking" data-tracking-id="nmenu">

								<!-- for menu bar -->

								<li class="menu-l0 " ><a
									 class="menu-text fk-inline-block"> <span>Electronics</span>
								</a> 
								<span class="menu-arrow fk-inline-block"></span>
									<div id="submenu_electronics" class="submenu">
									</div></li>
								<!-- home &kitchen -->
								<li class="menu-l0  " ><a
									href="/home-store" class="menu-text fk-inline-block"> <span>Home &amp;
											Kitchen</span>
								</a> <span class="menu-arrow fk-inline-block"></span>
									<div id="submenu_home-kitchen" class="submenu">
										
									</div></li>
								<!--nem  -->
								<li class="menu-l0  " ><a href="/men"
									class="menu-text fk-inline-block" > <span>Men</span>
								</a> <span class="menu-arrow fk-inline-block"></span>
									<div id="submenu_men" class="submenu" >
										</div></li>

								<li class="menu-l0 "><a
									 class="menu-text fk-inline-block"
									> <span>Women</span>
								</a> <span class="menu-arrow fk-inline-block"></span>
									<div id="submenu_women" class="submenu">
									</div></li>

								<li class="menu-l0  " >
									<a href="/kids-corner" class="menu-text fk-inline-block"> 
									<span>Baby &amp; Kids</span>
								</a> <span class="menu-arrow fk-inline-block"></span>
									<div id="submenu_baby-kids" class="submenu">
									</div>
								</li>

								<li class="menu-l0  " >
									<a href="javascript:void(0)" class="menu-text fk-inline-block"> <span>Books &amp;
											Media</span>
								</a> <span class="menu-arrow fk-inline-block"></span>
									<div id="submenu_books-media" class="submenu">
									</div>
								</li>

								<li class="menu-l0  ">
									<a href="" class="menu-text fk-inline-block"> <span>More Stores</span>
								</a> <span class="menu-arrow fk-inline-block"></span>
									<div id="submenu_more-stores" class="submenu">

										<!-- script -->
									</div>

								</li>

								<li class="menu-l0 link-offer-zone ">

									<a href="/offers" class="menu-text fk-inline-block"> 
									<span>Offers Zone</span>
								</a>
								</li>
							</ul>
						</div>
					</div>
				</div>


				<div class="fclear"></div>
			</div>
		</div>
		
		
		<div class="container">
		<div class="col-md-1 "></div>
		<div class="col-md-3 ">
			<div class="background">
			

				<h4><b>BROWSE</b></h4>
				
				<hr noshade>
				<h5>
					<b>REFINE</b>
				</h5>
				<hr>
				<h5>Price</h5>
				<hr>
				<form>
					<input type="checkbox" class="filtersprice" name="checkboxprice" id="range" price="1"> Rs. 2000 and Below<br>
					<input type="checkbox" class="filtersprice" name="checkboxprice" id="range" price="2"> Rs. 2001 - Rs. 5000<br>
					<input type="checkbox" class="filtersprice" name="checkboxprice" id="range" price="3"> Rs. 5001 - Rs. 10000<br>
					<input type="checkbox" class="filtersprice" name="checkboxprice" id="range" price="4"> Rs. 10001 - Rs. 18000<br>
					<input type="checkbox" class="filtersprice" name="checkboxprice" id="range" price="5"> Rs. 18001 - Rs. 25000<br>
					<input type="checkbox" class="filtersprice" name="checkboxprice" id="range" price="6"> Rs. 25001 - Rs. 35000<br>
					<input type="checkbox" class="filtersprice" name="checkboxprice" id="range" price="7"> Rs. 35001 and Above
				</form> 
				
			
				<hr>
				<h5>Brand</h5>
				<hr>
<s:iterator value="stringArray1">

<input type="checkbox" id="brand"  name="checkbox"
					class="filters"	brandname="<s:property />">
						<s:property />
						<br>

</s:iterator>
<hr>
				
					<br>
					<br>
					<br>
			</div>
		</div>

		<div class="col-md-8 background" id="dataappended">
			<b> Showing all the products in the category </b><br>
			<br>

			<s:iterator value="products">
				<div class="col-md-4">
					<div class="border">
						<br>
						<center>
							<s:if test="%{stock == 0}">
							 <a href="#"> <img src="<s:property value="image"/>"
									alt="<s:property value="product_id"/>" height="140px"
									width="auto"><br> <img
									src="images/sold_out.jpg" alt="outofstock"
									height="40px">
								</a>
							</s:if>
							<s:if test="%{stock != 0}">
								<s:if test="%{stock >= 0}">
								
										<a
										href="getProductDetail?productID=<s:property value="productID"/>">
											<img src="<s:property value="image"/>"
											alt="<s:property value="product_id"/>" height="140px"
											width="auto"> <br>
										<br>
										<br>
										</a>
														</s:if>
								<s:if test="%{stock < 0}">
									<a href="#"> <img src="<s:property value="image"/>"
										alt="<s:property value="product_id"/>" height="140px"
										width="auto"><br> <img
										src="images/sold_out.jpg" alt="outofstock"
										height="40px">
									</a>
								</s:if>
							</s:if>
							<div class="giveMeEllipsis">
								<a
									href="getProductDetail?productID=<s:property value="product_id"/>">
									<font size="4" color="black"><s:property
											value="product_name" /></font><br>
						 	</a>
							</div>
							<hr>
							<div style="height:50px">
						
								<font size="5px" color="#76553B"> Rs. <s:property
										value="price" /><br><br>
								</font>
					
							</div>
							<hr>
							

							<input type="checkbox" id="productID" class="addtocompare" name="compare" pid="<s:property value="product_id"/> " />Add To Compare</input>

							<hr>

							<br>
							<br>
							<br>
						</center>
					</div>
					<br>
				</div>
			</s:iterator>
		</div>
		<div class="col-md-8" id="newdivision"></div>
	</div>

							</div>
						</div>
						


		<!-- main body part where we disply all things -->
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

				<!-- i think ki yha se disply hongi sari chije -->
				<div class="gd-row">
					<div class="gd-col gu16 top-section">
						<div id="fk-compare-cart-holder" class="hide">
							<div id="fk-compare-cart" class="static "></div>
							<div class="clear"></div>
						</div>
						<div class="left-col-wrap unit">
							<div class="left-col">

						
								<div id="main">hi disha<s:property value="result"></s:property></div>
	</div>
					</div>
				</div>
				<!-- <div class="gd-row">
					<div class="gd-col gu16"></div>
				</div>
				<div class="gd-row">
					<div class="gd-col gu16 line"></div>
				</div>

				<div class="gd-row">
					<div class="gd-col gu12">
						<div id="bundle-reco-module" class="fk-hidden"></div>
					</div>
				</div>
				<div class="gd-row">
					<div class="gd-col gu16">
						<div id="compatible-reco-module" class="fk-hidden"></div>
					</div>
				</div>

				<div class="gd-row">
					<div class="gd-col gu16">
						<div id="hSame-reco-module" class="fk-hidden"></div>

					</div>
				</div>


 -->
				<div class="gd-row">
					<div class="gd-col gu12">

						<div class="hsame-alt-reco">
							<div id="hSameAlt-reco-module" class="fk-hidden"></div>

						</div>
						<p class="bottomGenuineMessage">
							<strong>Please Note:</strong> All products sold on Flipkart are
							brand new and 100% genuine
						</p>
					</div>

					<!-- <div class="gd-col gu4">


						<div class="pp-rightside-recos-container">
							<div class="same-reco">
								<div id="vSame-reco-module" class="fk-hidden"></div>
							</div>
							<div class="cross-reco">
								<div id="vCross-reco-module" class="fk-hidden"></div>
							</div>
							<div class="cross-reco">
								<div id="recent-purchase-reco-module" class="fk-hidden"></div>
							</div>
						</div>
					</div>
				</div>
 -->


<!-- 
				<div class="gd-row">
					<div class="gd-col gu16"></div>
				</div>


				<div class="gd-row">
					<div class="gd-col gu12"></div>
				</div>

				<div class="gd-row">
					<div id="session-reco-module" class="fk-hidden"></div>
				</div> -->
			</div>
		</div>
		
</div>
<%@include file="/footer.jsp" %>
</div>

</body></html>
