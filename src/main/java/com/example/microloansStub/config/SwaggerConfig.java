package com.example.microloansStub.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Эмулятор книжного магазина",
                description = "Эмулируется работа внешней системы для проведения НТ сервиса Микрозаймы",
                contact = @Contact(
                        name = "Агафнов Владислав Алексеевич",
                        email = "agafonov@mail.ru"
                )
        )
)
public class SwaggerConfig {
}
