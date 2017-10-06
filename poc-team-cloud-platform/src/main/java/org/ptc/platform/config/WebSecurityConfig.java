//package org.ptc.platform.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
//
//	// @formatter:off
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http
//	      .authorizeRequests()
//	        .antMatchers("/login","/about").permitAll() // #4
//	        .antMatchers("/**").hasRole("USER") // #6
//	        .anyRequest().authenticated() // 7
//	        .and()
//	    .formLogin()  // #8
//	        .loginPage("/login").failureUrl("/login-error") // #9
//	        .permitAll(); // #5
//	}
//	// @formatter:on
//
//	// @formatter:off
//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		auth
//			.inMemoryAuthentication()
//				.withUser("user").password("password").roles("USER");
//	}
//	// @formatter:on
//	
//	  @Override
//	  public void configure(WebSecurity web) throws Exception {
//	    web
//	      .ignoring()
//	         .antMatchers("/resources/**"); // #3
//	  }
//	
//}
