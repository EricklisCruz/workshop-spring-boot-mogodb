package com.syudyprojects.demo.config;

import com.syudyprojects.demo.domain.entities.Post;
import com.syudyprojects.demo.domain.entities.User;
import com.syudyprojects.demo.dto.AuthorDTO;
import com.syudyprojects.demo.repositories.PostRepository;
import com.syudyprojects.demo.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
@Profile(value = "test")
public class Instantiation implements CommandLineRunner {

    private final UserRepository userRepository;

    private final PostRepository postRepository;

    public Instantiation(UserRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();

        postRepository.deleteAll();

        User maria = new User("Maria Brown", "maria@gmail.com");
        User alex = new User("Alex Green", "alex@gmail.com");
        User bob = new User("Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(sdf.parse("21/03/2018"),
                "Partiu viagem", "Vou viajar para SP, abraços", new AuthorDTO(maria));
        Post post2 = new Post(sdf.parse("23/03/2018"),
                "Bom dia", "Acordei feliz hoje!!", new AuthorDTO(maria));

        postRepository.saveAll(Arrays.asList(post1, post2));

        maria.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(maria);
    }
}
