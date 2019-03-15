package com.javabootcamp.main.repos;


import com.javabootcamp.main.objects.BullhornPost;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BullhornPostRepository extends CrudRepository<BullhornPost,Long> { }

