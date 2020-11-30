package com.topgear.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.topgear.entity.RegistrationService;
import com.topgear.repo.H2;
import com.topgear.repo.H2Payments;
import com.topgear.service.ServiceLayer;


@Controller
@SessionAttributes("registrationservice")
public class HomeController{
	@Autowired
	H2 h2;
	@Autowired
	H2Payments h2Payments;
	
	@Autowired
	ServiceLayer serviceLayer;

	 @ModelAttribute("registrationservice")
	   public RegistrationService registrationservice() {
	      return new RegistrationService();
	   }
	
	@RequestMapping(value="/login")
	   public String login(Model m,RegistrationService reg) {
		     	            
		   return "Login";
	   }


	   @RequestMapping(value="/registrationservice")
	   public String registrationservice(RegistrationService rs) {
          serviceLayer.Save(rs);
          
 	        return "redirect:/login";
	   }
	   
	   @RequestMapping(value="/registration")
	   public String registration(Model m){
		  m.addAttribute("usernamelist",h2.findAllUserName() );
		   String accountNumber="ABC20190000";
		   if(h2.count()==0)
		   {	
			   m.addAttribute("accountNumber","ABC201900001"); 
		   }
		   else
		   {
			   m.addAttribute("accountNumber",accountNumber+(h2.count()+1)); 
		   }
	        return "Registration";
	   }
	   
	   @RequestMapping(value="/performtransaction")
	   public String performtransaction(Principal pr,Model model) {
		  RegistrationService reg=new RegistrationService();
		  reg=h2.findByUserName(pr.getName());
		  model.addAttribute("Accountnumbers",h2.findAllUserAccountNo());
		  model.addAttribute("Loggeduser",h2.findByUserName(pr.getName()).getAccountNumber());
		  model.addAttribute("balance",reg.getAmount());
		 
				  return "PerformTransaction"; 
	   }
	   
	   
	   @RequestMapping(value="/username")
	   public String username(@ModelAttribute("registrationservice") RegistrationService reg) {
	 
	   	   return null;
	   }
	   @RequestMapping(value="/usernamevalidation")
	   public @ResponseBody String usernamevalidaion(HttpServletRequest req) {
	 String userid=req.getParameter("userid");
	 userid=userid.substring(11);
	 RegistrationService reg=h2.getOne(Integer.parseInt(userid));
	 
	   	   return reg.getUserName();
	   }
	   @RequestMapping(value="/forgotpassword")
	   public String forgotpassword(@SessionAttribute("registrationservice") RegistrationService reg,Model model) {
if(h2.findAllUserName().contains(reg.getUserName()))
{
	reg=h2.findByUserName(reg.getUserName());
	model.addAttribute("securityQuestion",reg.getSecurityQuestion());
	model.addAttribute("answer",reg.getAnswer());
	
}
else {
	model.addAttribute("userInvalid","User does not exist"  );
}
	
	   		   return "ForgotPassword";
	   }

	   @RequestMapping(value="/changepassword")
	   public String changepassword(HttpServletRequest req,Model model) {
		   if(req.getParameter("answer")!=null)
		   {
			  model.addAttribute("answer", req.getParameter("answer"));
			 
		   }
		
	        return "ChangePassword";
	   }
	   @RequestMapping(value="/changepasswordprocess")
	   public String changepasswordprocess(@SessionAttribute("registrationservice") RegistrationService reg,HttpServletRequest req) {
			reg=h2.findByUserName(reg.getUserName());
			reg.setPassword(req.getParameter("newPassword"));
			serviceLayer.Save(reg);
		
	        return "redirect:/login";
	   }
	 
	   @RequestMapping(value="/mydebitsprocess")
	   public String mydebitsprocess(Model model,Principal pr,HttpServletRequest req) {
		   int amount=Integer.parseInt(req.getParameter("amount"));
		 String remarks=req.getParameter("remarks");
		   int toaccount=Integer.parseInt( req.getParameter("payeeAccountNumber").substring(11));
		   String payeeName=req.getParameter("payeeName");
		   
		   RegistrationService reg=new RegistrationService();
			  reg=h2.findByUserName(pr.getName());
		   
		 serviceLayer.FundTransfer(reg.getAccountNumber(), toaccount, amount,pr.getName(),payeeName,remarks);
	
		  
		   
		   
		return "redirect:/mydebits";
	   }
	   
	   @RequestMapping(value="/mydebits")
	   public String mydebits(Model model,Principal pr,HttpServletRequest req) {
		   RegistrationService reg=new RegistrationService();
		reg=h2.findByUserName(pr.getName());
		
			  model.addAttribute("balance",reg.getAmount());
			  model.addAttribute("Payments",h2Payments.findAllByfromAccount(reg.getAccountNumber()));
			
			
	        return "MyDebits";
	   }
	   
	   @RequestMapping(value="/mycredits")
	   public String mycredits(Model model,Principal pr) {
		   RegistrationService reg=new RegistrationService();
			  reg=h2.findByUserName(pr.getName());
			  
			  model.addAttribute("balance",reg.getAmount());
			  model.addAttribute("Payments", h2Payments.findAllBytoAccount(reg.getAccountNumber()));
		
	        return "MyCredits";
	   }
	 
	    
	      
	    

}
