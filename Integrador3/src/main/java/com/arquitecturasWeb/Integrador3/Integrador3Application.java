package com.arquitecturasWeb.Integrador3;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.sql.SQLException;

@SpringBootApplication
public class Integrador3Application {

	public static void main(String[] args) {
		SpringApplication.run(Integrador3Application.class, args);
	}

}
