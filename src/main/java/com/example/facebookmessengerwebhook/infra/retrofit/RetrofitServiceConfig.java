package com.example.facebookmessengerwebhook.infra.retrofit;

import com.example.facebookmessengerwebhook.infra.RetrofitMessengerApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;

@Configuration
public class RetrofitServiceConfig {

    @Value("${api.facebook.base-url}")
    private String baseUrl;

    @Bean
    public RetrofitMessengerApi messengerApi() {
        Retrofit retrofit = RetrofitUtils.initRetrofit(baseUrl);
        return retrofit.create(RetrofitMessengerApi.class);
    }
}
