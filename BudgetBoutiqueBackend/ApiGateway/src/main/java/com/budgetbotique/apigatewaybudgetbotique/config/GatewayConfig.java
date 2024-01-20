package com.budgetbotique.apigatewaybudgetbotique.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("user-service", r -> r.path("/auth/**").uri("http://localhost:8080"))
                .route("expense-service", r -> r.path("/api/expenses/**").uri("http://localhost:8081"))
                .build();
    }
}
