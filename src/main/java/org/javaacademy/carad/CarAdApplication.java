package org.javaacademy.carad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CarAdApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(CarAdApplication.class, args);

	}
}
