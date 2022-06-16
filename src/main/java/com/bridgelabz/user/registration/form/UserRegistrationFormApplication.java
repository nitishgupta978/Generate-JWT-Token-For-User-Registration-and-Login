package com.bridgelabz.user.registration.form;

import com.bridgelabz.user.registration.form.serviceLayer.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class UserRegistrationFormApplication {
	@Autowired
	private EmailSenderService emailSenderService;


	public static void main(String[] args) {
		SpringApplication.run(UserRegistrationFormApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void sendEmail(){
		emailSenderService.sendEmail("nlg012001@gmail.com","Email send By SpringBoot","Email");
	}
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.bridgelabz.user.registration.form"))
				.build() ;

	}
}
