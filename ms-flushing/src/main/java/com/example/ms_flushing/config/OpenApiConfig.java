package com.example.ms_flushing.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI().info(new Info()
                .title("ms-flushing - AgroBebederos")
                .description("Registro y gestión de flushing de líneas de bebederos")
                .version("1.0"));
    }
}
