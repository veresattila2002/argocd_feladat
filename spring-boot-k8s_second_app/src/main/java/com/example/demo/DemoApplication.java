package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RestController
public class DemoApplication {

	@Autowired
	private final RestTemplate restTemplate = new RestTemplate();

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/getmessage")
	public String getMessage()
	{
		String message = restTemplate.getForObject("http://spring-boot-app.spring-boot-app.svc.cluster.local:8080/message", String.class);
		return "Üzenet a másik apptól: " + message;
	}

	@GetMapping("/")
	public String message()
	{
		return "Hello world app 2";
	}


	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

}
