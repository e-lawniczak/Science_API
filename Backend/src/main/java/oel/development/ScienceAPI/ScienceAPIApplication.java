package oel.development.ScienceAPI;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@OpenAPIDefinition(
		info = @Info(title = "ScienceAPI", version = "v1"),
		security = @SecurityRequirement(name = "bearerAuth")
)
@SecurityScheme(
		name = "bearerAuth",
		type = SecuritySchemeType.HTTP,
		scheme = "bearer",
		bearerFormat = "JWT"
)
@SpringBootApplication(scanBasePackages = {"oel.development.ScienceAPI", "oel.core"})
@EntityScan(basePackages = {"oel.development.ScienceAPI", "oel.core"})
@EnableJpaRepositories(basePackages = {"oel.development.ScienceAPI", "oel.core"})
@Import(oel.core.security.SecurityConfig.class)
public class ScienceAPIApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScienceAPIApplication.class, args);
	}

}
