package com.udemy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling //para habilitar spring btach y las tareas que se repetiran
public class PruebaAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(PruebaAppApplication.class, args);
	}

}
