package com.varaisys.intranet.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author Kartik Khurana
 * @CreationDate - 13-10-2022
 * @ModifyDate- 13-10-2022
 */

@SpringBootApplication
@ComponentScan("com.varaisys.intranet")
@EnableAutoConfiguration(exclude = { HibernateJpaAutoConfiguration.class })
public class IntranetMainBootConfiguration extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(IntranetMainBootConfiguration.class);

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(IntranetMainBootConfiguration.class, args);
	}
}
