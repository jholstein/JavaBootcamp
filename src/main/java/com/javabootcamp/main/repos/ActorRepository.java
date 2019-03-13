package com.javabootcamp.main.repos;

import com.javabootcamp.main.objects.Actor;
import com.javabootcamp.main.objects.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends CrudRepository<Actor,Long> { }
