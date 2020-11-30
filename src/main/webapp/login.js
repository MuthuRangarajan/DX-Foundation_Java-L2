$(document).ready(function(){
	    $("#userdata").on("click",function(){
	    	
		  var user=$("#userName").val();
		  if(user=="")
   	   {
			  $("#error").show();
   	   return false;
   	   }
	        $.ajax({
	        	type:'post',
	            url : 'username',
	            data: 'userName='+user,
	            
	             
	        });

	       
	    });
	    
 });
function errordiv()
{
	var x=b();
	
		if(x!="")
			{
			$("#error").show();
			}
		
	 	}
 function Registration()
 {
 	window.location="registration"
 	}
