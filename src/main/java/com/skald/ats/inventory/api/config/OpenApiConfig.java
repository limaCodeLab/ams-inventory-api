package com.skald.ats.inventory.api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Inventory Management API")
                        .description("Gerenciamento de estoque")
                        .version("1.0.0")
                        .contact(new Contact()
                                .email("alan.lima@skaldit.com.br")
                                .name("Alan Lima")
                                .url("https://www.linkedin.com/in/alaanlimaa/")));

    }

}
