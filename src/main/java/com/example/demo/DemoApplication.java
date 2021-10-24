package com.example.demo;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@SpringBootApplication
public class DemoApplication {

	static Dotenv dotenv = Dotenv.load();

	@Value("${server.port}")
	private String port;

	@Value("${message}")
	private String messageFromApplication;

	@Value("${OS}")
	private String osFromApplication;

	public static String staticOS;

	static final String fileEnv = dotenv.get("MY_MESSAGE");

	public static void main(String[] args) {
		System.out.println("Static OS = " + staticOS);
		System.out.println("File env = " + fileEnv);

		SpringApplication.run(DemoApplication.class, args);

	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx){
//		Just printing all the beans created in Spring framework.
		return args -> {
			System.out.println("Let's inspect the beans");

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);

//			for(String beanName : beanNames){
//				System.out.println(beanName);
//			}

			System.out.println(port);
//        Unable to access system.properties.
//        System.out.println(System.getenv("message"));

//        Accessing application.properties apart from port on heroku.
			System.out.println(messageFromApplication);

//			System property
			System.out.println("System.properties message "+System.getProperty("message"));

//        Getting from environment variables on heroku.
			System.out.println(System.getenv("message"));

//			OS message from application.
			System.out.println(osFromApplication);



//			Another variable
			System.out.println(System.getenv("OS"));

		};
	}

}


