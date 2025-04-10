package com.project.todotasks;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TodotasksApplicationTests {
	@Autowired
	TestRestTemplate restTemplate;

	@Test
	@DirtiesContext
	void ShouldCreateTask() {
		Task task = new Task(null, "Homewrok", "Do the linear algebra homework", false);
		ResponseEntity<Void> createResponse = restTemplate.postForEntity("/tasks", task, void.class);
		assertThat(createResponse.getStatusCode()).isEqualTo(HttpStatus.CREATED);
	}
}
