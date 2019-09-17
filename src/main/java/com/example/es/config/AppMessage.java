package com.example.es.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;

@Configuration
@PropertySources({
        @PropertySource("classpath:messages.properties")
})
public class AppMessage {

    @Autowired
    Environment environment;

    public String getProperty(String key) {
        return environment.getProperty(key);
    }
}
