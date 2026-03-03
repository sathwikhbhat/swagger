package com.databaes.civilens.common.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class OpenApiConfig {

    @Value("${app.server.url:}")
    private String configuredServerUrl;

    @Bean
    public OpenAPI civilensOpenAPI() {
        List<Server> servers = new ArrayList<>();

        if (configuredServerUrl != null && !configuredServerUrl.isEmpty()) {
            servers.add(new Server()
                    .url(configuredServerUrl)
                    .description("Production Server"));
        }

        return new OpenAPI()
                .info(new Info()
                        .title("Civilens API")
                        .description(
                                "Privacy-first persona intake and scheme management service for matching individuals to government schemes.")
                        .version("1.0.0"))
                .servers(servers);
    }
}
