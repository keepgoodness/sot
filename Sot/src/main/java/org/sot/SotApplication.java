package org.sot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SotApplication  { // extends SpringBootServletInitializer

	public static void main(String[] args) {
		SpringApplication.run(SotApplication.class, args);
	}
//  Когато се качва на сървър

//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//		return builder.sources(SotApplication.class);
//	}


}
