package com.topgear.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
@Configuration
@EnableWebSecurity
public class Appsecurity extends WebSecurityConfigurerAdapter{
   
	@Autowired
	private UserDetailsService userDetailsService;

 @Bean   
public AuthenticationProvider authpro()
{
	DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
provider.setUserDetailsService(userDetailsService);
provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
return provider;
}

@Override
protected void configure(HttpSecurity http) throws Exception {
	// TODO Auto-generated method stub
	http.csrf().disable().authorizeRequests().antMatchers("/h2-console/**","/jquery-3.2.1.min.js","/login.js","/resources/**","/changepassword.js","/performtransaction.js","/forgotpassword.js","/registration.js","/registration","/registrationservice","/forgotpassword","/changepassword","/username","/usernamevalidation","/changepasswordprocess").permitAll()
	.anyRequest().authenticated().and().formLogin().usernameParameter("userName").loginPage("/login").defaultSuccessUrl("/performtransaction",true).and().logout().logoutUrl("/logout").logoutSuccessUrl("/login").invalidateHttpSession(true).permitAll();
	
	
	http.headers().frameOptions().disable();
}







	
	
}
