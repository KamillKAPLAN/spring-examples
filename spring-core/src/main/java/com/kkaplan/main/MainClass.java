package com.kkaplan.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.ApplicationContext;

import com.kkaplan.config.AppConfig;
import com.kkaplan.model.User;
import com.kkaplan.services.UserService;

public class MainClass {

	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		UserService userService = context.getBean(UserService.class);
		
		for (User user : userService.getUserList()) {
			System.out.println(user.getFirstName());
		}
	}	
}
