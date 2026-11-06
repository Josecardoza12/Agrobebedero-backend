package com.example.ms_monitoreo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI().info(new Info()
                .title("ms-monitoreo - AgroBebederos")
                .description("Mediciones de temperatura del agua y alertas")
                .version("1.0"));
    }
}