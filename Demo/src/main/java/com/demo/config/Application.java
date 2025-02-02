package com.demo.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@Configuration
@ComponentScan(basePackages = {"com.demo.*"})
@EnableJpaRepositories("com.demo.repository")
@EntityScan("com.demo.model")
@SpringBootApplication
public class Application {
	
	public static void main(String args[]) {
		SpringApplication.run(Application.class,args);
	}

}
