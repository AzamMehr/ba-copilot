package com.copilot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
        import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.copilot")
public class BaCopilotApp {

	public static void main(String[] args) {
		SpringApplication.run(BaCopilotApp.class, args);
	}

}
