package com.mawulidev.userhttpclient.config;

import com.mawulidev.userhttpclient.dto.UserResponse;
import com.mawulidev.userhttpclient.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class WebClientConfig {


    @Bean
   public UserHttpService userService(){
        WebClient client = WebClient.builder()
                .baseUrl("https://dummyjson.com")
                .build();
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builder(WebClientAdapter.forClient(client)).build();
        return factory.createClient(UserHttpService.class);
    }
}
