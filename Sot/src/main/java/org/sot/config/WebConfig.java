///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package org.sot.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
///**
// *
//// * @author Jordan
//// */
//@EnableWebSecurity
//@Configuration
////@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
//public class WebConfig extends WebSecurityConfigurerAdapter {
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.headers().cacheControl().disable();
//				.and().authorizeRequests()
//				.antMatchers("/**").permitAll();
//				.anyRequest().authenticated();
//	}
//
//}
