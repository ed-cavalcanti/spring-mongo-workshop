package com.workshop.mongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.workshop.mongo.domain.User;
import com.workshop.mongo.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User jon = new User(null, "jon Snow", "jon@gmail.com");
        User arya = new User(null, "Arya Stark", "arya@gmail.com");
        User eddard = new User(null, "Eddard Stark", "edstark@gmail.com");

        userRepository.deleteAll();
        userRepository.saveAll(Arrays.asList(jon, arya, eddard));
    }

}
