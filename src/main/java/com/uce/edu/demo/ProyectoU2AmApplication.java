package com.uce.edu.demo;

import org.apache.log4j.Logger;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProyectoU2AmApplication implements CommandLineRunner {

	private static Logger logger = Logger.getLogger(ProyectoU2AmApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2AmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		logger.debug("Hola Mundo.");
	}

}
