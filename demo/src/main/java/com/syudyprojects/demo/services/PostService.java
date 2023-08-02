package com.syudyprojects.demo.services;

import com.syudyprojects.demo.domain.entities.Post;
import com.syudyprojects.demo.repositories.PostRepository;
import com.syudyprojects.demo.services.exceptions.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post findPostById(String id) {
        return postRepository.findById(id).orElseThrow(
                () -> new ObjectNotFoundException("Post not found!!"));
    }

    public List<Post> findPostByTitle(String text) {
        return postRepository.findBySearchTitle(text);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
        return postRepository.fullSearch(text, minDate, maxDate);
    }
}
