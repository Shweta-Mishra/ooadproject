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
/* 	
	function MakeLogin(form){
		
		var email = $(Bank_Id).val();
		var password = $(Bank_Password).val();
		alert(password);
		alert("in the function");
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
			    document.getElementById("#sidebar-wrapper").innerHTML=xmlhttp.responseText;
			    //event.preventDefault();
			   
		    }
		  };
		alert("open");
		xmlhttp.open("POST","CartVerify?email="+email+"&password="+password,true);
		alert("send");
		xmlhttp.send();
}

 */
</script>

</head>

<body>
	<div class="extra"></div>
	<div class=".elev" align="center">
		<form action="CartVerify">
			<table cellspacing="5"
				style="background-color: #e0e0d1; height: 6cm; width: 14cm; font-size: .4cm;">
				<tr>
					<td><h2>Log in</h2></td>
				</tr>
				<tr>
					<td>user Id:</td>
					<td><input type="text" id="Bank_Id" name="email"></td>

				</tr>
				<tr>
					<td>Password:</td>
					<td><input id="Bank_Password" type="password" name="password"></td>
				</tr>
				<tr>
					<td></td>
					<td>
						<button id="Bank_Pay" type="submit" class="btn btn-success"
							style="background-color: orange; height: 1.0cm;">Make
							Payment</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>