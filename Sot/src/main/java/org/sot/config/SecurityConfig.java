package org.sot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
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

	private final UserDetailsService userDetailsService;

	@Autowired
	public SecurityConfig(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring()
				.antMatchers("/styles/**", "/js/**", "/images/**", "/fonts/**");
				
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().ignoringAntMatchers("/points/delete/**")
			.and()
		.authorizeRequests()
//				.antMatchers("/**").permitAll()
				.anyRequest().authenticated()
			.and().formLogin()
				.loginPage("/login").permitAll()
				.passwordParameter("password")
				.usernameParameter("username")
                        .and().userDetailsService(this.userDetailsService)
                              .rememberMe().key("uniqueAndSecret");
			
	}

	
	
}
