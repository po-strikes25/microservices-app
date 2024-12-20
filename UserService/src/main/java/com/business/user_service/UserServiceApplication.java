package com.business.user_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
//@EnableEurekaClient: It is no longer required; Gets automatically enabled;
public class UserServiceApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(UserServiceApplication.class, args);
	}

}
