package com.example.swagger_demo;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public OpenAPI customOpenAPI() {

        return new OpenAPI().
                components(new Components()).info(new Info()
                        .title("Swagger Test App")
                        .description("Swagger Test App : Description")
                        .version("1.0.0")
                );
    }
}
