package com.project.sapbackend.configs;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Nurgissa",
                        email = "nkabarbek03@gmail.com"
                ),
                description = "Open API documentation for QueueOverFlow project",
                title = "Open API specification - Nurgissa",
                version = "1.0"
        ),
        servers = {
                @Server(
                        description = "Local ENV",
                        url = "http://localhost:8090"
                ),
                @Server(
                        description = "Dev ENV",
                        url = "https://www.google.ru/will-be-available-in-future"
                )
        },
        security = @SecurityRequirement(
                name = "bearerAuth"
        )

)
@SecurityScheme(
        name = "bearerAuth",
        description = "JWT auth description",
        scheme = "bearer",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER
)
public class OpenApiConfig {
}
//        http://localhost:8090/swagger-ui/index.html#/
//        http://localhost:8090/swagger-ui/index.html#/
//        http://localhost:8090/swagger-ui/index.html#/

