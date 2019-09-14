package com.example.es.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(ElasticSearchConfig.class)
public class AppConfig {
}
