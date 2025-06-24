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

	private final RestTemplate restTemplate = new RestTemplate();

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/getmessage")
	public String getMessage()
	{
		String message = restTemplate.getForObject("http://localhost:8080/message", String.class);
		return "Üzenet a másik apptól: " + message;
	}

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

}
