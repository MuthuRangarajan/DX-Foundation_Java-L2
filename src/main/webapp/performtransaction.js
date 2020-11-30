$(document).ready(function(){
	
    $("#send").on("click",function(){
    	
    	   	var selectval=$("#payeeAccountNumber").val();
    	var payee=$("#payeeName").val();
    	
    	if(selectval=="Please Select Account Number")
    		{
    		$("#error").show();
    		return false;
    		
    		}
    	  
   
		 var amnt=document.getElementById("amount").value;
  	   var bal=b();
  	    	if(+amnt > +bal)
  	    		{  	    	
  	    		$("#error").show();
  	    		return false;
  	    		}
  	   	
        if( $("#mobileNumber").val().length != "10" )
        {
        	$("#error").show();
    		return false;
        }
       
      	 
		  $.ajax({
		        	type:'post',
		            url : 'usernamevalidation',
		            data: 'userid='+selectval,
		            success : function(dataa)
		            {  
		            	if($("#payeeName").val()!=dataa){
		            		$("#error").show();
		            		window.stop();
		            	}
		            	
		             
		            }
		                   
		        });
     
      });
    
   });
 
function PerformTransaction()
{
	
	window.location="performtransaction"
	}