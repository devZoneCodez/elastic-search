package com.example.es;

import com.example.es.config.AppConfig;
import com.example.es.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@Import(AppConfig.class)
@EnableSwagger2
@ComponentScan(basePackages = {"com.example.es.controller"
        , "com.example.es.repo"
        , "com.example.es.service"
        , "com.example.es.util"
        , "com.example.es.exception"})
@EnableWebMvc
@Slf4j
public class ElasticSearchApplication implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Autowired
    private ElasticsearchTemplate esTemplate;

    public static void main(String[] args) {
        SpringApplication.run(ElasticSearchApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.trace("ElasticSearchApplication.rub - Start");

        log.info("ElasticsearchTemplate =" + esTemplate);
//
//        List<User> users = Arrays.asList(new User(1001L, "Sateesh Kumar", "D", 123456789L)
//                , new User(1001L, "Sateesh Kumar", "D", 123456789L)
//				, new User(1002L, "Romit Kumar", "D", 123456789L)
//                , new User(1003L, "Rithika", "D", 123456789L));
//
//
//        users.forEach(user -> userService.save(user));
//
//        log.info("Users : " + userService.findAll());
//        log.info("UsersByFirstName : " + userService.findByFirstName("rithika"));

        log.trace("ElasticSearchApplication.rub - End");
    }
}
