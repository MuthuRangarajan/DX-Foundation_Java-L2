$(document).ready(function(){
    $("#submitPassword").on("click",function(){
    	var ans=a();
    	if(ans=="")
		{		
    		window.location="login"
    		return false;
		}
    	if($("#newPassword").val().length<6)
    	{
    		$("#error").show().html("Invalid Input");
		return false;
		}
    	if($("#newPassword").val()!=$("#confirmPassword").val())
		{
    		$("#error").show();
		return false;
		}
    	
    	return true;
    	
    	
	
    });
});
function Login()
{
	window.location="login"
	}