package com.skald.ats.inventory.api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Inventory Management API")
                        .description("API for Inventory Management")
                        .version("1.0.0")
                        .contact(contact()));
    }


    private Contact contact(){
        return new Contact()
                .email("alan.lima@skaldit.com.br")
                .name("Alan Lima")
                .url("https://www.linkedin.com/in/alaanlimaa/");
    }

}
