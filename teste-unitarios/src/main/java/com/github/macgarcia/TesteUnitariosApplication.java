package com.github.macgarcia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(enableDefaultTransactions = false)
public class TesteUnitariosApplication {

	public static void main(String[] args) {
		SpringApplication.run(TesteUnitariosApplication.class, args);
	}

}
