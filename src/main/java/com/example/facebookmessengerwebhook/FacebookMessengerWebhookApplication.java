package com.example.facebookmessengerwebhook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:/app.properties")
@SpringBootApplication
public class FacebookMessengerWebhookApplication {

    public static void main(String[] args) {
        SpringApplication.run(FacebookMessengerWebhookApplication.class, args);
    }

}
