package com.securitydemo.inmemorysecurity.config;

import com.securitydemo.inmemorysecurity.entities.User;
import com.securitydemo.inmemorysecurity.repositories.UserRepo;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class DataLoader {

    @Bean
    public ApplicationRunner loadData(UserRepo userRepository, PasswordEncoder passwordEncoder) {
        return (ApplicationArguments args) -> {
            User user1 = new User();
            user1.setUsername("user1");
            user1.setPassword(passwordEncoder.encode("pass1"));
            user1.setActive(true);
            user1.getRoles().add("USER");

            User user2 = new User();
            user2.setUsername("admin");
            user2.setPassword(passwordEncoder.encode("admin"));
            user2.setActive(true);
            user2.getRoles().add("ADMIN");

            User user3 = new User();
            user3.setUsername("baap");
            user3.setPassword(passwordEncoder.encode("baap123"));
            user3.setActive(true);
            user3.getRoles().add("ADMIN");
            user3.getRoles().add("USER");

            userRepository.save(user1);
            userRepository.save(user2);
            userRepository.save(user3);
        };
    }
}


