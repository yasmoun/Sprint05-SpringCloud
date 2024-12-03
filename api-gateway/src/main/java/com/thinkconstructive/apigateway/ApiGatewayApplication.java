package com.thinkconstructive.apigateway;

import org.apache.http.HttpStatus;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}
	@Bean
	public WebFilter corsFilter() {
		return (ServerWebExchange ctx, WebFilterChain chain) -> {
			ctx.getResponse().getHeaders().add("Access-Control-Allow-Origin", "http://localhost:4200");
			ctx.getResponse().getHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
			ctx.getResponse().getHeaders().add("Access-Control-Allow-Headers", "Origin, Content-Type, Accept, Authorization");
			ctx.getResponse().getHeaders().add("Access-Control-Allow-Credentials", "true");
			return chain.filter(ctx);
		};
	}

}
