	$(document).ready(function(){
	    $("#submitButton").on("click",function(){
	    
	    var userentered=$("#userName").val();
	    var pass=$("#password").val();
	    var cnfpass=$("#confirmPassword").val();
	     var f=r();
	    	if(f.includes(userentered))
	    		{
	    		
	    		$("#error").show().html("User name already exists");
	    		return false;
	    		}
	    	if(pass!=cnfpass)
	    		{
	    	
	    		$("#error").show().html("Invalid Input");
	    		return false;
	    		}
	    	
	    	var amountent=$("#amount").val();
	    	if(+amountent.length<1 || +amountent.length>5 )
			{
	    		$("#error").show().html("Invalid Input");
			return false;
			}
		 
	    });
	});
	function Login()
	{
		window.location="login"
		}
