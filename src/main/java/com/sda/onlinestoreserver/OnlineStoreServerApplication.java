package com.sda.onlinestoreserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class OnlineStoreServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineStoreServerApplication.class, args);
    }

//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
