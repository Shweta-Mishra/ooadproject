
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en-IN">
<link href="css/bootstrap.css" rel="stylesheet">
<script src="JavaScripts/jquery-2.0.3.js"></script>
<script src="JavaScripts/bootstrap.min.js"></script>
<script src="JavaScripts/notification.js"></script>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="/struts-tags" prefix="s"%>
<head>
<meta http-equiv="Content-Type"
	content="application/xhtml+xml; charset=utf-8" />

<title>Flipkart</title>
<!--
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
    -->


<meta name="robots" content="noodp" />
<!-- Login -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1" />

<link rel='shortcut icon' href='css/shortcut icon.ico' />

<!-- ye stylesheet1,2,3 h  -->

<link href="http://img5a.flixcart.com/www/prod/basic-cebe3355-nogz.css"
	rel="stylesheet" />
<link
	href="http://img5a.flixcart.com/www/prod/HPSLite-c8ae7b70-nogz.css"
	rel="stylesheet" />
<link
	href="http://img5a.flixcart.com/www/prod/legoProductPage-0650d849-nogz.css"
	rel="stylesheet" />
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css"
	rel="stylesheet" />





<title>Flipkart</title>



<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>


<!-- Login -->
<style type="text/css">
.modal-footer {
	border-top: 0px;
}
</style>

<Script>
	function ajax2(){
		
		
		var xmlhttp; if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari 
			xmlhttp=new XMLHttpRequest(); } 
		else {// code for IE6, IE5
			xmlhttp=new ActiveXObject("Microsoft.XMLHTTP"); 
		} xmlhttp.onreadystatechange=function() 
		{ 
			if (xmlhttp.readyState==4 && xmlhttp.status==200)
			{ 
				console.log(xmlhttp.responseText); 
				document.getElementById("noti").innerHTML=xmlhttp.responseText;
				//event.preventDefault(); 
				} 
			} 
		xmlhttp.open("GET","check_note",true);
		xmlhttp.send(); 
		return true; 
		// event.preventDefault();
		//event.preventDefault();
		
		
	}


	
	
	</Script>
</head>
<body class="product">
	<div class="newMenu  fkart fksk-body line  ">

		<div id="fk-header">
			<div id="fk-mainhead-id" class="jank-fixed  ">
				<div class="header-topbar">
					<div class="header-content">
						<div class="unit size1of6">
							<a href="/" class="fk-text-center fk-font-11 logo-img-link fllt">
								<img width="149px" height="38px" class="logo-img retina-img"
								data-retina="flipkart_india_retina.png" src="flipkart_india.png" />
								<div class="text">The Online Megastore</div>
							</a>
						</div>
						<div class="unitExt mainUnit">

							<div class="header-links unitExt">
								<ul
									class="link-list fk-font-12 fk-text-center required-tracking"
									data-tracking-id="ch_vn">

									<li><a href="/s/contact"> Seller </a></li>
									<li><a href="/s/contact"> 24x7 Customer Care </a></li>
									<li><a href="#"> <span class="header-track-icon"></span>
											Track Order
									</a></li>
									<li>
									<!-- Notification div starts here -->

	<% 
				if(session.getAttribute("email") == null) 
				{ 
			%>

	<img src="images/bell.JPG" height="25px"
		data-contentwrapper=".mycontent" rel="popover" data-title="">


	<div class="mycontent hide">

		<div class="notification-popup-header">Notifications</div>
		<br>
		<div class="no-notifications">Get notifications on order's
			placed!</div>
		<br>
		<div class="whatrnotif1">What are Notifications??</div>
		<br>
		<div class="whatrnotif2">
			Notifications are timely alerts on your order status!! <br> <strong><b>Sign-in</b></strong>
			now to start receiving notifications.
		</div>

	</div>

	<% 
				}
				else 
				{ 
			%>

	<img id="notification_button" src="images/bell.JPG" height="25px"
		data-contentwrapper=".mycontent" rel="popover" data-title="" onclick="ajax2()">

	<div class="mycontent hide">

		<div class="notification-popup-header">Notifications</div>
		<br>
		<div id="get_notification">
			 <div id="noti"></div> 
		</div>

	</div>
	<%
				}
			%>

	<!-- Notification div ends here -->
									
									<%-- <a href="/notifications" id="notifications-link"
										title="Notifications" class="notifications-link yellow-bell">
											<span class="notification-number notifications-count-dull"
											id="notifications-count-button"> 0 </span>
									</a> <script type="text/javascript+fk-window-onload">
            FKART.notificationsAddOnload({
              nearElement:'#notifications-link',
              'browseAB':''
              }
            );
        </script> --%>
        </li>


									<li class="no-border greeting-link"><a class="no-border"
										href="/account/">Hi <%
										if (session.getValue("fname") == null) {
											out.print("");
										}

										else {
											out.print(session.getValue("fname"));
										}
									%>!
									</a>
										<ul class="account-dropdown">
											<li><s:url id="url" action="get">
												</s:url> <s:a href="%{url}">Account</s:a></li>

											<li class="js-orders"><a href="#">Orders</a></li>
											<li><a href="#">Wallet</a></li>

											<li><a href="#">Wishlist</a></li>
											<li><a href="#">eBooks Library</a></li>
											<li><a href="#">Reviews & Ratings</a></li>

											<li><a href="#">Email Preferences</a></li>
											<li><a href="Logout">Logout</a></li>
										</ul></li>

									<li>
										<!-- agr login ni h to ye chaleg --> <a
										class="no-border js-login login-required" href="#"
										data-toggle="modal" data-target="#SignupModal">Signup</a>
									</li>
									<li class="no-border">
										<!--   

 
 --> <a class="no-border js-login login-required" href="#"
										data-toggle="modal" data-target="#loginModal">Login</a>


									</li>
								</ul>

							</div>


							<!-- search engine -->

							<div class="fk-searchbar unit fclear">
								<form onsubmit="" method="get" id="fk-header-search-form"
									action="" autocomplete="off">
									<div class="search-bar-wrap">
										<div class="search-bar">
											<div class="unit search-bar-text-wrap size5of6">
												<span class="search-bar-icon"> </span> <input type="text"
													name="q" class="search-bar-text fk-font-13 ac_input"
													placeholder="Search for a product, category or brand"
													value="" id="fk-top-search-box" />
											</div>
											<div class="unit search-bar-submit-wrap size1of6">
												<input type="submit"
													class="search-bar-submit fk-font-13 fk-font-bold"
													value="Search" />

											</div>
										</div>
									</div>
								</form>
								<!-- search engine close -->
								<fieldset>
									<input type='hidden' name='ab_buk' id='ab_buk' value="new-new" />
									<input type="hidden" id="fk-vertical-auto-suggestions" value=""
										name="vertical" />
								</fieldset>


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
									<a class="btn btn-blue btn-cart" href="/viewcart"> <span
										class="cart-icon"> </span> <span class='cart-label'>
											Cart </span> <span id="item_count_in_cart_top_displayed"
										class="fk-inline-block cart-count"> <!-- cart search ke baju m jo value ati h usko print krane k liye -->
									</span>
									</a>
								</div>
							</div>
							<script type="text/javascript">
								
							</script>
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

								<li class="menu-l0  " data-key="electronics"><a
									href="javascript:void(0)" class="menu-text fk-inline-block"
									data-tracking-id="electronics"> <span>Electronics</span>
								</a> <span class="menu-arrow fk-inline-block"></span>
									<div id="submenu_electronics" class="submenu"
										data-submenu-key="electronics">
										<script type="text/javascript" class="menu_docwrite">
											(function() {
												var loader_html = "<div class='fk-loader-middle'></div>", html;
												if (window.localStorage
														&& (html = window.localStorage
																.getItem("submenu_html-electronics"))
														&& html != "") {
													document.write(html);
												} else {
													window.DWMM = true;
													document.write(loader_html)
												}
											})();
										</script>
									</div></li>
								<!-- home &kitchen -->
								<li class="menu-l0  " data-key="home-kitchen"><a
									href="/home-store" class="menu-text fk-inline-block"
									data-tracking-id="home-kitchen"> <span>Home &amp;
											Kitchen</span>
								</a> <span class="menu-arrow fk-inline-block"></span>
									<div id="submenu_home-kitchen" class="submenu"
										data-submenu-key="home-kitchen">
										<script type="text/javascript" class="menu_docwrite">
											(function() {
												var loader_html = "<div class='fk-loader-middle'></div>", html;
												if (window.localStorage
														&& (html = window.localStorage
																.getItem("submenu_html-home-kitchen"))
														&& html != "") {
													document.write(html);
												} else {
													window.DWMM = true;
													document.write(loader_html)
												}
											})();
										</script>
									</div></li>
								<!--nem  -->
								<li class="menu-l0  " data-key="men"><a href="/men"
									class="menu-text fk-inline-block" data-tracking-id="men"> <span>Men</span>
								</a> <span class="menu-arrow fk-inline-block"></span>
									<div id="submenu_men" class="submenu" data-submenu-key="men">
										<script type="text/javascript" class="menu_docwrite">
											(function() {
												var loader_html = "<div class='fk-loader-middle'></div>", html;
												if (window.localStorage
														&& (html = window.localStorage
																.getItem("submenu_html-men"))
														&& html != "") {
													document.write(html);
												} else {
													window.DWMM = true;
													document.write(loader_html)
												}
											})();
										</script>
									</div></li>

								<li class="menu-l0  " data-key="women"><a
									href="javascript:void(0)" class="menu-text fk-inline-block"
									data-tracking-id="women"> <span>Women</span>
								</a> <span class="menu-arrow fk-inline-block"></span>
									<div id="submenu_women" class="submenu"
										data-submenu-key="women">
										<script type="text/javascript" class="menu_docwrite">
											(function() {
												var loader_html = "<div class='fk-loader-middle'></div>", html;
												if (window.localStorage
														&& (html = window.localStorage
																.getItem("submenu_html-women"))
														&& html != "") {
													document.write(html);
												} else {
													window.DWMM = true;
													document.write(loader_html)
												}
											})();
										</script>
									</div></li>

								<li class="menu-l0  " data-key="baby-kids"><a
									href="/kids-corner" class="menu-text fk-inline-block"
									data-tracking-id="baby-kids"> <span>Baby &amp; Kids</span>
								</a> <span class="menu-arrow fk-inline-block"></span>
									<div id="submenu_baby-kids" class="submenu"
										data-submenu-key="baby-kids">
										<script type="text/javascript" class="menu_docwrite">
											(function() {
												var loader_html = "<div class='fk-loader-middle'></div>", html;
												if (window.localStorage
														&& (html = window.localStorage
																.getItem("submenu_html-baby-kids"))
														&& html != "") {
													document.write(html);
												} else {
													window.DWMM = true;
													document.write(loader_html)
												}
											})();
										</script>
									</div></li>

								<li class="menu-l0  " data-key="books-media"><a
									href="javascript:void(0)" class="menu-text fk-inline-block"
									data-tracking-id="books-media"> <span>Books &amp;
											Media</span>
								</a> <span class="menu-arrow fk-inline-block"></span>
									<div id="submenu_books-media" class="submenu"
										data-submenu-key="books-media">
										<script type="text/javascript" class="menu_docwrite">
											(function() {
												var loader_html = "<div class='fk-loader-middle'></div>", html;
												if (window.localStorage
														&& (html = window.localStorage
																.getItem("submenu_html-books-media"))
														&& html != "") {
													document.write(html);
												} else {
													window.DWMM = true;
													document.write(loader_html)
												}
											})();
										</script>
									</div></li>

								<li class="menu-l0  " data-key="more-stores"><a
									href="javascript:void(0)" class="menu-text fk-inline-block"
									data-tracking-id="more-stores"> <span>More Stores</span>
								</a> <span class="menu-arrow fk-inline-block"></span>
									<div id="submenu_more-stores" class="submenu"
										data-submenu-key="more-stores">

										<!-- script -->
									</div></li>

								<li class="menu-l0 link-offer-zone " data-key="offer-zone">

									<a href="/offers" class="menu-text fk-inline-block"
									data-tracking-id="offer-zone"> <span>Offers Zone</span>
								</a>
								</li>
							</ul>
						</div>
					</div>
				</div>


				<div class="fclear"></div>
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
					<div class="gd-col gu16 top-section" itemscope
						itemtype="http://schema.org/Product">
						<div id="fk-compare-cart-holder" class="hide">
							<div id="fk-compare-cart" class="static "></div>
							<div class="clear"></div>
						</div>
						<div class="left-col-wrap unit">
							<div class="left-col"></div>
						</div>
						<div class="right-col-wrap lastUnit">
							<div class="right-col lpadding20 line">
								<div class="product-details line"></div>
							</div>
						</div>
					</div>
				</div>
				<div class="gd-row">
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

					<div class="gd-col gu4">


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




				<div class="gd-row">
					<div class="gd-col gu16"></div>
				</div>


				<div class="gd-row">
					<div class="gd-col gu12"></div>
				</div>

				<div class="gd-row">
					<div id="session-reco-module" class="fk-hidden"></div>
				</div>
			</div>
		</div>

		<!-- footer contents -->
		<div class="fk-mainfooter fksk-mainfooter tpadding20 bpadding5 new-vd"
			id="fk-mainfooter-id">
			<div class="fk-content fksk-content bpadding10">
				<div class="line tpadding20 bpadding20 footer-dark-top-border">
					<div class="unit fk-footer-links-container">
						<div class="unit size1of4">
							<span class="fk-footer-sub-head fk-footer-unit"><strong>Help</strong></span>
							<a class="fk-footer-unit fk-footer-link" href="/s/help/payments">Payments</a>
							<a class="fk-footer-unit fk-footer-link"
								href="/help/savedcard_how">Saved Cards</a> <a
								class="fk-footer-unit fk-footer-link" href="/s/help/shipping">Shipping</a>
							<a class="fk-footer-unit fk-footer-link"
								href="/s/help/cancellation-returns"> Cancellation &amp;
								Returns </a> <a class="fk-footer-unit fk-footer-link" href="/s/help">FAQ</a>

						</div>
						<div class="unit size1of4">
							<span class="fk-footer-sub-head fk-footer-unit"><strong>Flipkart</strong></span>
							<a class="fk-footer-unit fk-footer-link" href="/s/contact">Contact
								Us</a> <a class="fk-footer-unit fk-footer-link" href="/about-us">About
								Us</a>



						</div>
						<div class="unit size1of4 required-tracking"
							data-tracking-id="ch_vn">
							<span class="fk-footer-sub-head fk-footer-unit"><strong>Flipkart
									eBooks</strong></span> <a class="fk-footer-unit fk-footer-link"
								href="/ebooks/gettingstarted" target="_blank"> eBooks Quick
								Start Guide </a> <a class="fk-footer-unit fk-footer-link"
								href="/help/flyteeBookfaq" target="_blank">eBooks FAQ</a> <a
								class="fk-footer-unit fk-footer-link" href="/ebooks/apps"
								target="_blank">eBooks App</a>

						</div>
						<div class="lastUnit size1of4">
							<span class="fk-footer-sub-head fk-footer-unit"><strong>Misc</strong></span>
							<a class="fk-footer-unit fk-footer-link"
								href="http://www.flipkart.com">Online Shopping</a> <a
								class="fk-footer-unit fk-footer-link" href="/affiliate/"
								target="_blank">Affiliate</a> <a
								class="fk-footer-unit fk-footer-link" href="/buy-gift-voucher">e-Gift
								Voucher</a> <a class="fk-footer-unit fk-footer-link"
								href="/?sitevariant=mobile">Flipkart lite</a> <a
								class="fk-footer-unit fk-footer-link" href="/flipkart-first">Flipkart
								First Subscription</a> <a class="fk-footer-unit fk-footer-link"
								href="/elearning-faq">eLearning FAQ</a>
						</div>
					</div>

				</div>
				<div class="fk-footer-ssa"></div>
				<div class="line fk-footer-policy">
					<div class="unit tpadding5">

						<span class="fk-footet-cr">&copy; 2007-2015 <span>Flipkart.com.</span></span>

					</div>
					<div class="fk-footer-kit unitExt fk-inline-block">
						<strong class="title fk-float-left">Keep in touch</strong>
					</div>
				</div>
			</div>
		</div>

		<script>
			$(function() {
				//twitter bootstrap script
				$("button#submit").click(function() {
					$.ajax({
						type : "POST",
						url : "process.php",
						data : $('form.contact').serialize(),
						success : function(msg) {
							$("#Login").html(msg)
							$("#form-content").modal('hide');
						},
						error : function() {
							alert("failure");
						}
					});
				});
			});
		</script>


		<!--  Login modal -->

		<div class="modal fade" id="loginModal" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">

					<!-- Header Section -->
					<div class="modal-header">
						<h2>Login</h2>
					</div>

					<!-- Body Section -->
					<div class="modal-body">
						<s:form class="form col-md-12" action="LoginAction">

							<div class="form-group">
								<div class="line rw">
									<div class="unit size1of3 lf">
										<label class="fk-label" for="email">Email Address</label>
									</div>
									<div class="unit size3of4 lastUnit rt">
										<input id="email" class="fk-input" type="text"
											autocomplete="on" required="true" name="email"></input>
									</div>
								</div>
							</div>

							<div class="form-group">

								<div class="line rw">
									<div class="unit size1of3 lf">
										<label class="fk-label" for="password">Password</label>
									</div>
									<div class="unit size3of4 lastUnit rt">
										<input id="password" class="fk-input" type="password"
											autocomplete="off" required="true" name="password"></input>
									</div>
								</div>
							</div>


							<input class="btn btn-blue" value="Login" type="submit">
						</s:form>
					</div>

					<!-- Footer Section -->
					<div class="modal-footer">
						<div class="col-md-12">
							<span class="pull-left"><a href="#">Forgot Password?</a></span>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!--  Signup modal -->
		<div class="modal fade" id="SignupModal" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">

					<!-- Header Section -->
					<div class="modal-header">
						<h2>Signup</h2>
					</div>

					<!-- Body Section -->
					<div class="modal-body">
						<s:form class="form col-md-8" action="SignupAction">

							<div class="form-group">

								<div class="line rw">
									<div class="unit size1of3 lf">
										<label class="fk-label" for="email">Email Address</label>
									</div>
									<div class="unit size3of4 lastUnit rt">
										<input id="email" class="fk-input" type="email"
											autocomplete="on" required="true" name="email"></input>
									</div>
								</div>
							</div>


							<div class="form-group">
								<div class="line rw">
									<div class="unit size1of3 lf">
										<label class="fk-label" for="password">Password</label>
									</div>
									<div class="unit size3of4 lastUnit rt">
										<input id="password" class="fk-input" type="password"
											autocomplete="off" required="true" name="password"></input>
									</div>
								</div>
							</div>

							<div class="form-group">
								<div class="line rw">
									<div class="unit size1of3 lf">
										<label class="fk-label" for="password">Repeat</label>
									</div>
									<div class="unit size3of4 lastUnit rt">
										<input id="password_check" class="fk-input" type="password"
											autocomplete="off" required="true" name="password_check"></input>
									</div>
								</div>
							</div>

							<div class="form-group">
								<div class="line rw">
									<div class="unit size1of3 lf">
										<label class="fk-label" for="email">First Name</label>
									</div>
									<div class="unit size3of4 lastUnit rt">
										<input id="fname" class="fk-input" type="text"
											autocomplete="on" required="true" name="fname"></input>
									</div>
								</div>
							</div>

							<div class="form-group">
								<div class="line rw">
									<div class="unit size1of3 lf">
										<label class="fk-label" for="email">Last Name</label>
									</div>
									<div class="unit size3of4 lastUnit rt">
										<input id="lname" class="fk-input" type="text"
											autocomplete="on" required="true" name="lname"></input>
									</div>
								</div>
							</div>

							<div class="form-group">
								<div class="line rw">
									<div class="unit size1of3 lf">
										<label class="fk-label" for="email">Role</label>
									</div>
									<div class="unit size3of4 lastUnit rt">
										<input id="role" class="fk-input" type="text"
											autocomplete="on" required="true" name="role"></input>
									</div>
								</div>
							</div>

							<div class="form-group">
								<div class="line rw">
									<div class="unit size1of3 lf">
										<label class="fk-label" for="email">Gender</label>
									</div>
									<div class="unit size3of4 lastUnit rt">
										<input id="gender" class="fk-input" type="text"
											autocomplete="on" required="true" name="gender"></input>
									</div>
								</div>
							</div>


							<div class="form-group">
								<div class="line rw">
									<div class="unit size1of3 lf">
										<label class="fk-label" for="email">Mobile</label>
									</div>
									<div class="unit size3of4 lastUnit rt">
										<input id="Mobile" class="fk-input" type="text"
											autocomplete="on" required="true" name="Mobile"></input>
									</div>
								</div>
							</div>


							<div class="form-group">
								<div class="line rw">
									<div class="unit size1of3 lf">
										<label class="fk-label" for="email">Landline</label>
									</div>
									<div class="unit size3of4 lastUnit rt">
										<input id="Landline" class="fk-input" type="text"
											autocomplete="on" required="true" name="Landline"></input>
									</div>
								</div>
							</div>

							<div class="form-group">
								<input class="btn btn-green" value="Sign Up Now!" type="submit">
								</input>
						</s:form>
					</div>

					<!-- Footer Section -->
					<div class="modal-footer"></div>
				</div>
			</div>
		</div>
</body>
</html>

