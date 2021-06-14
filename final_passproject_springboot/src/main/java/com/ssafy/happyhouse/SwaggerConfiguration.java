package com.ssafy.happyhouse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


// http://localhost:8000//swagger-ui.html

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	@Bean
	public Docket postsApi1() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("member")
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.ssafy.happyhouse.controller"))
				.paths(PathSelectors.ant("/member/**"))
				.build();
	}
	
	@Bean
	public Docket postsApi2() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("housedeal")
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.ssafy.happyhouse.controller"))
				.paths(PathSelectors.ant("/houseController/**"))
				.build();
	}
	
	@Bean
	public Docket postsApi3() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("qna")
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.ssafy.happyhouse.controller"))
				.paths(PathSelectors.ant("/post/**"))
				.build();
	}

	@Bean
	public Docket postsApi4() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("comment")
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.ssafy.happyhouse.controller"))
				.paths(PathSelectors.ant("/comment/**"))
				.build();
	}
	
	@Bean
	public Docket postsApi5() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("board")
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.ssafy.happyhouse.controller"))
				.paths(PathSelectors.ant("/board/**"))
				.build();
	}
	
	@Bean
	public Docket postsApi6() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("bcomment")
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.ssafy.happyhouse.controller"))
				.paths(PathSelectors.ant("/bcomment/**"))
				.build();
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("SSAFY API")
				.description("SSAFY API Reference for Developers")
				.termsOfServiceUrl("https://edu.ssafy.com")
				.license("SSAFY License")
				.licenseUrl("ssafy@ssafy.com").version("1.0").build();
	}

}