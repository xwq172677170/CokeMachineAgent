package com.cs7375.CokeMachineAgent.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SpringDocOpenApiConfig {
	
	@Bean
	public GroupedOpenApi publicApi() {
	    return GroupedOpenApi.builder()
	            .group("coke-machine")
	            .pathsToMatch("/api/coke-machine/**")
	            .build();
	}
	
	@Bean
	public OpenAPI customOpenAPI() {
	    return new OpenAPI()
	        .info(new Info()
	            .title("CS7375 Coke Machine AI Agent UI")
	            .version("1.0.0 - Beta"));
	}
}
