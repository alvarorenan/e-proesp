package com.eproesp.loginSecurity;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.eproesp.loginSecurity.controller.FileUploadController;

@Configuration
@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan({"com.eproesp.loginSecurity", "controller"})
public class LoginSecurityTutorialApplication {

	public static void main(String[] args) {
		new File(FileUploadController.uploadDirectory).mkdir();
		SpringApplication.run(LoginSecurityTutorialApplication.class, args);
	}
}
