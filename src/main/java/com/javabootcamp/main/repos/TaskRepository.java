package com.javabootcamp.main.repos;

import com.javabootcamp.main.objects.Dog;
import com.javabootcamp.main.objects.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends CrudRepository<Task,Long> { }
