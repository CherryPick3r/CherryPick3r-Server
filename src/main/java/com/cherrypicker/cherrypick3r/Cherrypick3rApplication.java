package com.cherrypicker.cherrypick3r;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


//@EnableBatchProcessing
@SpringBootApplication//(exclude = SecurityAutoConfiguration.class) // 스프링 시큐리티 꺼두기
@EnableJpaAuditing
public class Cherrypick3rApplication {

	public static void main(String[] args) {
		SpringApplication.run(Cherrypick3rApplication.class, args);
	}

}