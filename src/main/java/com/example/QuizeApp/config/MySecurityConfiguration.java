package com.example.QuizeApp.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.QuizeApp.serviceImpl.UserDeatilsServiceImpl;

@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)


public class MySecurityConfiguration extends WebSecurityConfigurerAdapter {

	
	@Autowired
	private JwtAuthenticationFilter JwtAuthenticationFilter;
	
	
	@Autowired
	private JwtAuthicationEntryPoint unauthorizedHandler;
	
	
	@Autowired
	private UserDeatilsServiceImpl userDeatilsServiceImpl;
	
	
	
	@Bean
	 @Override
	    public AuthenticationManager authenticationManagerBean() throws Exception {
	        return super.authenticationManagerBean();
	 }
	
	
//	//it is using for plan test
//	@Bean
//
//	public PasswordEncoder passwordEncoder()
//	{
//		return NoOpPasswordEncoder.getInstance();
//	}
	
	
	@Bean
	
 public BCryptPasswordEncoder passwordEncoder()
	{
	return 	new BCryptPasswordEncoder();
	}
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(userDeatilsServiceImpl).passwordEncoder(passwordEncoder());
		
		
		
	}
	
	
	
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		
		http.csrf().disable().cors().disable().authorizeRequests().antMatchers("/generate-token","/user/save").permitAll()
		.antMatchers(HttpMethod.OPTIONS).permitAll()
		.anyRequest().authenticated()
		.and()
		.exceptionHandling()
		.authenticationEntryPoint(unauthorizedHandler)
		.and()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	  http.addFilterBefore(JwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
	}
	
}
	
	
