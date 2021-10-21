package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class DemoApplication {

	@Value("${server.port}")
	private String port;

	@Value("${message}")
	private String messageFromApplication;


	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);

	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx){
//		Just printing all the beans created in Spring framework.
		return args -> {
			System.out.println("Let's inspect the beans");

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);

			for(String beanName : beanNames){
				System.out.println(beanName);
			}

			System.out.println(port);
//        Unable to access system.properties.
//        System.out.println(System.getenv("message"));

//        Accessing application.properties apart from port on heroku.
			System.out.println(messageFromApplication);

//        Getting from environment variables on heroku.
			System.out.println(System.getenv("message"));

		};
	}

}

