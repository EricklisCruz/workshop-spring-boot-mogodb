package com.syudyprojects.demo.repositories;

import com.syudyprojects.demo.domain.entities.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    @Query("{ 'title': { $regex: ?0, $options: 'i' } }")
    List<Post> findBySearchTitle(String text);
    List<Post> findByTitleContainingIgnoreCase(String text);
}
