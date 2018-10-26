package org.sot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author Jordan
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//	private final UserDetailsService userDetailsService;
//
//	@Autowired
//	public SecurityConfig(UserDetailsService userDetailsService) {
//		this.userDetailsService = userDetailsService;
//	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/", "/login").permitAll()
				.antMatchers("/styles/**","/js/**","/images/**","/fonts/**").permitAll()
				.anyRequest().authenticated()
			.and()
				.formLogin()
				.loginPage("/login")
				.loginProcessingUrl("/login")
				.successForwardUrl("/login?error")
				.failureForwardUrl("/")
				.passwordParameter("password")
				.usernameParameter("username");
//				.and()
//			.formLogin()
//				.loginPage("/users/login").permitAll()
//				.passwordParameter("password").usernameParameter("username")
//				.and()
//			.userDetailsService(userDetailsService);
	}
}
