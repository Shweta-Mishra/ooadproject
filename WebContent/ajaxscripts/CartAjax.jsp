<!-- Author : Gazal Gupta (The TL) -->



<script>


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



</script>
