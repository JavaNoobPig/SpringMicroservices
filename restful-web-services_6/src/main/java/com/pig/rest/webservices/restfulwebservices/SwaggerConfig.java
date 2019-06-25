package com.pig.rest.webservices.restfulwebservices;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//Configuration
@Configuration
// Enable Swagger
@EnableSwagger2
public class SwaggerConfig {
	// name url email
	public static final Contact DEFAULT_CONTACT = new Contact("Happy Pig", "http://www.pig.com", "pig@gmail.com");

	public static final ApiInfo DEFAULT_API_INFO = new ApiInfo("Awesome API", // title
			"Awesome Api description", // description
			"1.0", // version
			"urn:tos", // termsOfService
			DEFAULT_CONTACT, // 上面的Contact
			"Apache 2.0", // licence name
			"http://www.apache.org/licenses/LICENSE-2.0" // license url
	);

	private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = new HashSet<String>(
			Arrays.asList("application/json","application/xml"));

	// Bean - Docket
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(DEFAULT_API_INFO)
				.produces(DEFAULT_PRODUCES_AND_CONSUMES)
				.consumes(DEFAULT_PRODUCES_AND_CONSUMES);
	}
	// Swagger 2
	// All the paths
	// All the apis
}
