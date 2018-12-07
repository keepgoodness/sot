package org.sot.config;

import org.sot.interceptors.LoggerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler(
				"/fonts/**",
				"/images/**",
				"/js/**",
				"/styles/**"
		).addResourceLocations(
				"classpath:/META-INF/resources/webjars/",
				"classpath:/static/fonts/",
				"classpath:/static/images/",
				"classpath:/static/js/",
				"classpath:/static/styles/"
		);
	}

//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(new LoggerInterceptor());
//	}

}
//
//}
