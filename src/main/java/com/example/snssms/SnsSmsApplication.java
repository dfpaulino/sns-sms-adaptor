package com.example.snssms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SnsSmsApplication implements CommandLineRunner {

	@Autowired
	SendNotificationSMSService sendNotificationSMSService;


	public static void main(String[] args) {
		SpringApplication.run(SnsSmsApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		sendNotificationSMSService.pubTextSMS("hello from Java","+351967178860");
	}
}
