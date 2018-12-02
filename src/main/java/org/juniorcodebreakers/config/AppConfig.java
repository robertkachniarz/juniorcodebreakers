package org.juniorcodebreakers.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @ConditionalOnMissingBean
    @Bean
    public RestOperations restTemplate() {
        return new RestTemplate();
    }
}
