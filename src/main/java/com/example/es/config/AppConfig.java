package com.example.es.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(ElasticSearchConfig.class)
public class AppConfig {

    @Bean
    public ModelMapper userModelMapper() {
        return new ModelMapper();
    }

    @Bean
    public ModelMapper productModelMapper() {
        return new ModelMapper();
    }

}
