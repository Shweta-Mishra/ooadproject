<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<!--  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<script src="js/jquery.js"></script>
<script src="js/jquery-ui.js"></script>
<script src="js/jquery-1.9.1.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery-ui.css"></script>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">

-->
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/bootstrap-theme.min.css">
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery-ui.js"></script>
<script src="js/jquery-1.9.1.js"></script>







<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>OrderDetails</title>




<style type="text/css">
    .bs-example{
    	margin: 10px;
    }
   
</style>

<script type="text/javascript">
var to=$.no conflict(true);
</script>




</head>
<body>
<%@include file="/header.jsp" %>
YOYO YOU R THERE
<s:iterator value="DetailList" >
<div class="panel panel-default">
	
			<div class="panel heading">
				<h3 class="bg-info" class="panel-title">ORDER DETAILS </h3>
			</div>
			<div class="form-group">
				<div class="panel-body">
				<div class="row">
					<div class="col-md-6">
					<table class="table">
					<tr><td>OrderId:<input type="button" id="pqr" value =<s:property value = "OI" /> disabled/> </td></tr>
					<tr><td>Product Name:<s:property value="Product_Name"/></td> </tr>
					<tr><td> Amount Paid:<s:property value="total"/></td></tr>
					</table>
					</div>
					<div class="col-md-6">
						 <p><s:property value="D_Name"></s:property>
						 <br>
						 <s:property value="Address"></s:property>
						 </p>
				
					</div>
					</div>
			
</div>
</div>
</div>

  <div class="panel panel-default">
  	
				<div class="panel heading">
				<div class="row" > 
				<div class="col-md-4">
					
					<h4  class="bg-info" class="panel-title" >PRODUCT DETAILS </h4>
				</div>
				<div class="col-md-4">
				<h4  class="bg-info" class="panel-title" >APPROVE ON </h4>
				</div>
				<div class="col-md-4">
				<h4  class="bg-info" class="panel-title" >STATUS </h4>
				</div>
				</div>
				</div>
				<div class="form-group">
					<div class="panel-body">
					<div class="col-md-4">
					<img src= <s:property value="destpath"/> id="destpath" height="100px" width="100px">
					<p> <s:property value="description"/> </p>
					</div>
					<div class="col-md-4">
					<s:property value="Approve_Date"/>
					<br><br><br><br>
					<button type="submit" class="btn btn-primary" id="recieved">Recieved</button>
					
					</div>
					<div>
					
					<%-- <li id="status"> <s:property value="Status"/></li></ul> --%>
					 </div>
					<!-- <input type="button" id="status" value =<s:property value = "Status" /> disabled/> -->
				 <div class="col-md-4" id="status"><s:property value="Status"/></div> 
					<br><br><br><br>
					<!--  <button type="submit" class="btn btn-primary" id="cancel">Cancel</button>-->
					 <div class="col-md-4">
					 <a href="#" class="btn btn-primary" data-toggle="modal" id="cancel">Cancel Order</a>
					</div>
					
					
				</div>
				</div>
				
				
				</div>
</s:iterator>

<script type="text/javascript">
$.noConflict();
$(document).ready(function() {
	/* alert("m outside if");
	var status=document.getElementById('status');
	alert(status.textContent);
	alert("yo me");
	if(status.textContent=="Recieved") { alert("m inside if");
		$('#recieved').addClass("disabled");
		$('#cancel').addClass("disabled");
	} 
	else{
		alert("m inside else");
		$('#recieved').removeClass("disabled");
	}; */
	
	
	
	   $('#cancel').click(function(event) {
		   var country = document.getElementById('pqr').value;
		   var status=document.getElementById('status');
		//	alert(status.textContent);
			if(status.textContent=="Recieved"||status.textContent=="cancelled"){
				$('#myModalcancel').modal('show');
			}
			
			else{
				$('#myModal').modal('show');
	      $.get('cancel11', {
	        term : country
	      },function(Response){
	    	  $("#status").text("cancelled");
	    	//  alert("your order has been cancelled");
	      });
			};
	      });

	   
	   $('#recieved').click(function(event) {
		   var rcv = document.getElementById('pqr').value;
		   var status=document.getElementById('status');
		//	alert(status.textContent);
			if(status.textContent=="cancelled"){
				$('#myModalcancel').modal('show');
			}
			else{
	      $.get('recieved', {
	        term : rcv
	      },function(Response){
	    	  $("#status").text("Recieved");
	      });
			};
	      });
	
	});
</script>
  
<%--  <script type="text/javascript">

$.noConflict();
jquery(document).ready(function($) {
	   $('#recieved').click(function(event) {
		   var rcv = document.getElementById('pqr').value;
	      $.get('recieved', {
	        term : rcv
	      },function(){
	    	  $("#test").text("Recieved");
	      });
	      });
	});



</script>
--%>










<div class="bs-example">
    <!-- Button HTML (to Trigger Modal) -->
   <!--   <a href="#myModal" class="btn btn-lg btn-primary" data-toggle="modal">Launch Demo Modal</a>-->
    
    <!-- Modal HTML -->
    <div id="myModal" class="modal fade">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title">Confirmation</h4>
                </div>
                <div class="modal-body">
                    <p>Do you want to cancel your order?</p>
                    <p class="text-warning"><small>click on confirm for cancellation</small></p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <button   id="cancel" type="submit" class="btn btn-primary" data-dismiss="modal">confirm</button>
                </div>
            </div>
        </div>
    </div>
</div>     


<!-- cancel modal -->
<div id="myModalcancel" class="modal fade">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title">Invalid Action</h4>
                </div>
            </div>
        </div>
    </div>







</body>
</html>