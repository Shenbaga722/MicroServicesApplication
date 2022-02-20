package com.example.demo.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfig {
    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder.routes()
                .route("customer-post", rt -> rt.path("/createCustomer/**")
                        .uri("http://localhost:8091/"))
                .route("customer-get", rt -> rt.path("/getCustomers/**")
                        .uri("http://localhost:8091/"))
                .route("account-post", rt -> rt.path("/account/createAccount/**")
                        .uri("http://localhost:8092/"))
                .route("account-get", rt -> rt.path("/account/getAccounts/**")
                        .uri("http://localhost:8092/"))
                .build();


    }
}
