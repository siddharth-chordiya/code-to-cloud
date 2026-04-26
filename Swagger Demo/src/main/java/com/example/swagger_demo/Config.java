package com.example.swagger_demo;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .components(new Components())
            .info(new Info()
                .title("Swagger Demo App")
                .description("A lightweight Spring Boot application demonstrating API documentation using SpringDoc OpenAPI (Swagger UI). Showcases how to annotate RESTful endpoints and expose an interactive API explorer.")
                .version("1.0.0")
                .contact(new Contact()
                    .name("Swagger Demo App")
                    .email("example@email.com")
                    .url("https://github.com/siddharth-chordiya/code-to-cloud")
                )
                .license(new License()
                    .name("MIT License")
                    .url("https://opensource.org/licenses/MIT")
                )
                .termsOfService("https://example.com/terms")
            )
            .externalDocs(new ExternalDocumentation()
                .description("GitHub Repository")
                .url("https://github.com/siddharth-chordiya/code-to-cloud")
            )
            .addServersItem(new Server()
                .url("http://localhost:8080")
                .description("Local Development Server")
            )
            .addServersItem(new Server()
                .url("https://api.example.com")
                .description("Production Server")
            );
    }
}
