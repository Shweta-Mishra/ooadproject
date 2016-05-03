<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en-IN">
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="com.opensymphony.xwork2.ActionContext,com.opensymphony.xwork2.util.ValueStack,javax.servlet.http.HttpSession" %>
<%@ page import="flipkart.Model.*" %>


<head>
<meta http-equiv="Content-Type" content="application/xhtml+xml; charset=utf-8" />
<title>Flipkart</title>
<!--
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
    -->

<meta name="robots" content="noodp" />
<link rel='shortcut icon' href='images/shortcut icon.ico' />

<!-- ye stylesheet1,2,3 h  -->

<link href="css/codebeautify.css" rel="stylesheet" />
<link href="css/codebeautify1.css" rel="stylesheet" />
<link href="css/codebeautify3.css" rel="stylesheet" />
<link rel="stylesheet" href="css/jquery-ui.css"/>
<link rel="stylesheet" href="style.css"/>
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery-ui.js"></script>
<script src="js/jquery-1.9.1.js"></script>
 <script src="autocompleter.js"></script>
<link rel="stylesheet" href="style.css"/>
<script src="JavaScripts/jquery.min.js"></script>
<link href="css/bootstrap.css" rel="stylesheet"/>
<script src="JavaScripts/jquery-2.0.3.js"></script>
<script src="JavaScripts/bootstrap.min.js"></script>
<script src="JavaScripts/notification.js"></script>
<script src="JavaScripts/jquery-2.1.3.min.js"></script>



	<%--  <script type="text/javascript">
 var disha=  $.noConflict(true);
//	var flag=true;
 disha(document).ready(function() {
		alert("hi");
	 disha(function() { 
		
		
			disha(".menu-l0").click(function(){
				//alert("hi");
			var temp='';
	
			var uppercategoryname="";  
				uppercategoryname=this.id;
					//if(flag)
					//{		
				disha.ajax({
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
					   		temp += '<font size="3" color="black">'+count[index]+'</font>' ;
					  			    	temp += '</a>';
					  			    	temp+='<br>';
								

    }
 
					    	disha('.submenu').show();
					    	disha('.submenu').html(temp);
					
					    }
					});
						
	//	}
				//		flag=false;

			
			});
						

 });
	
		});
 </script>
 --%>
<script type="text/javascript">
function callhello() {
    alert("hi ni hu");
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
		    document.getElementById("menuhome").innerHTML=xmlhttp.responseText;
		    //event.preventDefault();
		   
	    }
	  }
	
xmlhttp.open("GET","menu",true);
	xmlhttp.send();
	return true;
    //many other code, for a test, I moved them. and replace a alert call.
}
</script>




<script>
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


	
	
	</script>
	

<!-- Login -->
<style type="text/css">
.modal-footer {
	border-top: 0px;
}
</style>

<script type="text/javascript">
<!--
// Form validation code for checking/matching password of Signup_form.
function validate()
{
 
   if( document.Signup_form.password.value != document.Signup_form.password_check.value )
   {
     alert( "Paaswords entered do not match!!" );
     document.Signup_form.password.focus() ;
     return false;
   }
}
</script>



<script type="text/javascript">
var muja= $.noConflict(true);

muja(document).ready(function(){
	muja("#floatingBarsG").hide();
	muja("#Login_form").click(function()
			{
		muja.ajax({
		    type: 'GET',	    
		    url:'LoginAction ?email=' + muja("#email").val() + '&password=' + muja("#password_login").val(),
		    success: function(data){
		    	//alert("data.message");
		    	//$("#getFname").html(data.message);
		    	var status=muja("#getFname").html();
		    	
		    	if(status=="user" || status=="admin" || status=="seller")
		    		{
		    		muja("#floatingBarsG").show();
		    		muja("#Login_form").submit();		    			
		    		}
		    	else
		    		{
		    			muja("#check_email_password").html("Invalid email or password");
		    		}
		     }});	
	});
});


</script>
 
	
</head>
<body class="product">
	<div class="newMenu  fkart fksk-body line  ">

		<div id="fk-header">
			<div id="fk-mainhead-id" class="jank-fixed  ">
				<div class="header-topbar">
					<div class="header-content">
						<div class="unit size1of6">
							<a href="Home.jsp" class="fk-text-center fk-font-11 logo-img-link fllt">
								<img width="149px" height="38px" class="logo-img retina-img" src="images/flipkart_india.png" />
								<div class="text">The Online Megastore</div>
							</a>
						</div>
						<div class="unitExt mainUnit">
							<div class="header-links unitExt">
								<ul class="link-list fk-font-12 fk-text-center required-tracking"
									data-tracking-id="ch_vn">

							
									<li><a href="TrackOrder">
									 <span class="header-track-icon"><img src="images/track.png" height="20px;" width="10px" alt="" /></span>
											Track Order
									</a></li>
									<li><li>
									<!-- Notification div starts here -->

	<% 
	int cartCount=0;
	
	session.setAttribute("cartCount", (int)cartCount);
	session.putValue("cartCount", cartCount);
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


        </li>
 
									</li>
											     		
										  <%
										if (session.getValue("fname") != null)
										{
										%>
										<li class="no-border greeting-link"><a class="no-border" href="/account/">Hi
											<%=session.getValue("fname")%>	     
										...!
									</a>
										<ul class="account-dropdown">
											<li><a href="get">Account</a></li>
											
											<li><a href="Logout">Logout</a></li>
										</ul></li>				
								</ul>
									</div>	
										
										
									<%
										} else {
										%>	
																			
										<li class="no border">
										<a class="no-border js-login login-required" href="#" data-toggle="modal" data-target="#SignupModal">Signup</a>
										</li>	
										<li class="no-border">
									 <a class="no-border js-login login-required" href="#" data-toggle="modal" data-target="#loginModal">Login</a>
									</li>
									</div>
						
							<% 
							}
							%>
							
							<!-- search engine -->

							<div class="fk-searchbar unit fclear">
								<form  name="termDDL" >
									<div class="search-bar-wrap">
										<div class="search-bar">
											<div class="unit search-bar-text-wrap size5of6">
												<span class="search-bar-icon"> <img src="images/search.jpg" alt="" /></span>
 												 <input type="text"	onselect="onTermChange()" id="search" name="product_name"
													class="search"	placeholder="Search For Product,Category or Brand " />
											</div>
											<div class="unit search-bar-submit-wrap size1of6">
												<input type="submit"class="search-bar-submit fk-font-13 fk-font-bold"
													onclick="onTermChange()" value="Search" />


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
									<a class="btn btn-blue btn-cart" href="DisplayCartAll"><img src="images/cart.png" style="margin-top:4px" height="25px" width="28px;"/>
											<span>Cart</span> <span id="item_count_in_cart_top_displayed"
										class="fk-inline-block cart-count"><%out.print(cartCount); %>
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
		<%@include file="menu.jsp"%>


		 	<div class="fclear"></div>
			</div>
		</div>

 <!-- <div id="fk-mainbody-id" class="fk-mainbody fksk-mainbody   ">

			<div class="fk-content fksk-content enable-compare">

				<div class="gd-row">
					<div class="gd-col gu16">
						<div id="oos-reco-module" class="fk-hidden"></div>
					</div>
				</div>
				<div class="gd-row">
					<div class="gd-col gu16"></div>
				</div>

  -->
 
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
						<s:form class="form col-md-12" action="LoginAction"  >

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
									<input id="password_login" class="fk-input" type="password"
										autocomplete="off" required="true" name="password"></input>
								</div>
							</div>
							</div>

			
							<input class="btn btn-blue"  type="submit" value="Login"/>
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
						<s:form class="form col-md-8" action="SignupAction" id="Signup_form" onsubmit="return(validate());" name="Signup_form" >
						
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
    						<div class="Line rw">	
    						<div class="unit size1of3 lf">
							                
                    <label for="interest" class="col-sm-2 control-label">Role </label>
                    </div>
	<div class="unit size3of4 lastUnit rt">
								
	<select name="role" class="form-control"  style="width: 170px">
        <option value="user">user</option>
      </select>
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
	
			
<!--   
  <script type="text/javascript">
 var jqq=  $.noConflict();
//	var flag=true;
 //jqq(document).ready(function() {
	 
	// jqq(function() { 
		
		
			jqq(".menu-l0").click(function(){
				//alert("hi");
			var temp='';
	
			var uppercategoryname="";  
				uppercategoryname=this.id;
					//if(flag)
					//{		
				jqq.ajax({
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
 
					    	jqq('.submenu').show();
					    	jqq('.submenu').html(temp);
					
					    }});
						
	//	}
				//		flag=false;

			
			});
						

// });
	
	//	});
 </script>
 -->
 
 
 <script type="text/javascript">
		function onTermChange() {
			//document.getElementById("courseDisplayChoice").selectedIndex = 0;
			document.termDDL.action = 'getProductDetail.action';
			document.termDDL.submit();
		}
	
		
	</script>
 
 
 
 
 
 
 </body>
 </html>