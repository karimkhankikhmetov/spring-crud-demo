package com.project.todotasks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EnableJpaRepositories

public class TodotasksApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodotasksApplication.class, args);
	}
}

