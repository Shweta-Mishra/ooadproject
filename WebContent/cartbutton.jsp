<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>


 
<%@include file="ajaxscripts/CartAjax.jsp"%> 
<%-- <%@include file="AddToCart.jsp"%>--%>
 <script type="text/javascript">CartProducts
	 var static loaded=false;
	$(window).load(function(){
		if(loaded)
        	$('#myModal').modal('show');
    });
	 function AddToCart()
	{
		loaded=true;
		
	};
</script>

</head>
<body>
	<!-- Button trigger modal -->
	<form action="AddToCart"  ><!-- action="DisplayCart"    action="AddToCart"       onclick="AddToCart()"-->
		<input name="SP_ID" value="SP001">
	
	<button  value="Add To Cart"  >Add To Cart</button>
	<!-- data-toggle="modal"
		data-target="#myModal"
	 -->	
	 
	 </form>

	<!-- Modal -->

		<!--To other page  -->	

</body>
</html>




