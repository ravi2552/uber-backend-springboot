package com.ravi.uber.configs;

import com.ravi.uber.entities.User;
import com.ravi.uber.entities.enums.Role;
import com.ravi.uber.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class AdminInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {

        if(userRepository.findByEmail("admin@uber.com").isEmpty()){

            User admin = User.builder()
                    .name("Admin")
                    .email("admin@uber.com")
                    .password(passwordEncoder.encode("admin123"))
                    .roles(Set.of(Role.ADMIN))
                    .build();

            userRepository.save(admin);

            System.out.println("Admin user created successfully!");
        }
    }
}