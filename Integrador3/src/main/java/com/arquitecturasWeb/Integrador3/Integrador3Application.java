package com.arquitecturasWeb.Integrador3;

import com.arquitecturasWeb.Integrador3.utils.CsvReader;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.sql.SQLException;

@SpringBootApplication
public class Integrador3Application {

	@Autowired
	private CsvReader loadDb;
	public static void main(String[] args) {
		SpringApplication.run(Integrador3Application.class, args);
	}

	@PostConstruct
	public void init() throws SQLException, IOException {
		this.loadDb.load();
	}

}
