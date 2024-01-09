package com.workshop.mongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.workshop.mongo.domain.Post;
import com.workshop.mongo.domain.User;
import com.workshop.mongo.repositories.PostRepository;
import com.workshop.mongo.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User jon = new User(null, "jon Snow", "jon@gmail.com");
        User arya = new User(null, "Arya Stark", "arya@gmail.com");
        User eddard = new User(null, "Eddard Stark", "edstark@gmail.com");

        Post post1 = new Post(null, sdf.parse("21/03/1985"), "Partiu viagem", "Vou viajar para muralha, abraços", jon);
        Post post2 = new Post(null, sdf.parse("19/09/1986"), "Se perguntarem...",
                "...o que aconteceu aqui, diga a eles que o Norte se lembra", arya);

        userRepository.saveAll(Arrays.asList(jon, arya, eddard));
        postRepository.saveAll(Arrays.asList(post1, post2));
    }

}
