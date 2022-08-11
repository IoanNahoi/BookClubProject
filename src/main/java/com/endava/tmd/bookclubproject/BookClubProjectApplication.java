package com.endava.tmd.bookclubproject;

import com.endava.tmd.bookclubproject.entity.Role;
import com.endava.tmd.bookclubproject.entity.User;
import com.endava.tmd.bookclubproject.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class BookClubProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookClubProjectApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(UserService userService) {
        return args -> {
            userService.saveRole(new Role(null, "ADMIN"));
            userService.saveRole(new Role(null, "USER"));
            userService.saveRole(new Role(null, "MANAGER"));
            userService.saveRole(new Role(null, "TECHNICIAN"));

            userService.addUser(new User("admin", "123456", "admin@admin.com", "admin", "admin", userService.getRoleByName("ADMIN")));
        };
    }

}
