package ge.vakho.selenium_google_translate.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SpringFoxConfig {

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder() //
				.title("Google Translator REST API") //
				.description("This is a sample application which exposes Google Translate as REST service.") //
				.version("v1.0.0") //
				.license("Apache 2.0") //
				.licenseUrl("http://www.apache.org/licenses/LICENSE-2.0") //
				.build();
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2) //
				.apiInfo(apiInfo()) //
				.select() //
				.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class)) //
				.paths(PathSelectors.any()) //
				.build();
	}
}