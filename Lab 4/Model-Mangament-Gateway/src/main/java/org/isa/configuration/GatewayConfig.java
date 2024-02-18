package org.isa.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder,
                                     @Value("${isa.model.url}") String modelUrl,
                                     @Value("${isa.ship.url}") String shipUrl,
                                     @Value("${isa.gateway.host}") String host) {
        return builder.routes()
                .route("model_route", r -> r
                        .path("/models/**")
                        .uri(modelUrl))
                .route("ship_route", r -> r
                        .path("/ships/**")
                        .uri(shipUrl))
                .route("model_id_route", r -> r
                        .path("/models/{id}")
                        .uri(modelUrl))
                .route("ship_id_route", r -> r
                        .path("/ships/{id}")
                        .uri(shipUrl))
                .route("fallback_route", r -> r
                        .path("/**")
                        .filters(f -> f.rewritePath("/api(?<remaining>.*)", "/$\\{remaining}"))
                        .uri(host))
                .build();
    }
}
