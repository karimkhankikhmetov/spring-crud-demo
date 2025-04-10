package com.project.todotasks;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


interface TaskRepository extends CrudRepository<Task, Long> {

}
