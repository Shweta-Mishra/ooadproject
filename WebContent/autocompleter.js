

  var jq1= $.noConflict(true);

jq1(document).ready(function() {

		
		jq1("#search").autocomplete({
		source : function(request, response) {
			jq1.ajax({
				url : "searchAction",
				type : "POST",
				data : {
					term : request.term
				},
				dataType : "json",
				
				success : function(data) {
					//alert("hi in json");//var count=data.itemDetail;
					
					response(data.list);
				}
				
	
			});
		}
	});
		
		
});
	