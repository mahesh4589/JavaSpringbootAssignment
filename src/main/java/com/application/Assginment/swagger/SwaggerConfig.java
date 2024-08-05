package com.application.Assginment.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;


/*import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;*/

@OpenAPIDefinition
@Configuration
public class SwaggerConfig {

	
	  @Bean public OpenAPI customOpenAPI() { return new OpenAPI() .info(new Info()
	  .title("API Documentation") .version("1.0")
	  .description("API Documentation for the Assignment Application")); }
	 


	/*
	 * @Bean public Docket swaggerApi() { return new
	 * Docket(DocumentationType.SWAGGER_2) .select()
	 * .apis(RequestHandlerSelectors.basePackage("com.application.Assginment"))
	 * .paths(PathSelectors.any()) .build();
	 * 
	 * }
	 */
	 
}
