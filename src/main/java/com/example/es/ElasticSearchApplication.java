package com.example.es;

import com.example.es.config.AppConfig;
import com.example.es.model.User;
import com.example.es.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@Import(AppConfig.class)
@EnableSwagger2
@ComponentScan(basePackages = {"com.example.es.controller", "com.example.es.repo", "com.example.es.service"})
public class ElasticSearchApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(ElasticSearchApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<User> users = Arrays.asList(new User(1001L, "Sateesh Kumar", "D", 123456789L)
                , new User(1001L, "Sateesh Kumar", "D", 123456789L)
				, new User(1002L, "Romit Kumar", "D", 123456789L)
                , new User(1003L, "Rithika", "D", 123456789L));


        users.forEach(user -> userService.save(user));

        System.out.println("Users : " + userService.findAll());
        System.out.println("UsersByFirstName : " + userService.findByFirstName("rithika"));
    }
}
