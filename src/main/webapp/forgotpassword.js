$(document).ready(function(){
    $("#forgotSubmit").on("click",function(){
    	var ans=a();
	  var enteredanswer=$("#answer").val();
	if(ans!=enteredanswer)
		{
		$("#error").show();
		return false;
		}
	
      
    });
});
function nouser()
{
	var f=forg();
	if(f!="")
		{
		$("#error").show().html("User does not exist");
		}
	
	}
function Login()
{
	window.location="login"
	}
