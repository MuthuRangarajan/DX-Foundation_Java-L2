package com.topgear.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.topgear.entity.RegistrationService;
import com.topgear.repo.H2;
@Service
public class Userdetailsservice implements UserDetailsService {

	@Autowired
	H2 h2;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		RegistrationService reg =h2.findByUserName(username);
		
		if(reg==null)
		{
      
			throw new UsernameNotFoundException("Not found");
			
		}
			
		return new Userprinciple(reg);
	}

}
