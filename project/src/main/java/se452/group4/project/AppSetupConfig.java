package se452.group4.project;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class AppSetupConfig {
	/**
	 * Defines services documentation based Swagger
	 * @see <a href="http://localhost:8080/swagger-ui/index.html">Swagger</a>  
	 * @param title
	 * @return
	 */
    @Bean
	public OpenAPI customOpenAPI(
		@Value("${flixnet.swagger.title:Default Title}") String title,
		@Value("${flixnet.swagger.version:Default Version}") String version,
		@Value("${flixnet.swagger.description:Default Description}") String description,
		@Value("${flixnet.swagger.terms-of-service:Default Terms}") String terms,
		@Value("${flixnet.swagger.license:Default License}") String license,
		@Value("${flixnet.swagger.url:Default Url}") String url
		) {
		return new OpenAPI().info(new Info()
		  .title(title)
		  .version(version)
		  .description(description));

		  // TODO: Maybe add authorize directly to swagger.
		//   .components(new Components().addSecuritySchemes("oAuth", null))
	}	}
