package com.vetconnect.vetconnect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableJpaAuditing
public class VetconnectApplication {

    public static void main(String[] args) {
        SpringApplication.run(VetconnectApplication.class, args);
    }

    @Configuration
    public static class MyConfiguration {
        @Bean
        public WebMvcConfigurer corsConfigurer() {
            return new WebMvcConfigurer() {
                @Override
                public void addCorsMappings(CorsRegistry registry) {
                    registry.addMapping("/**")  // Aplica a todas las rutas
                            .allowedOrigins("*")  // Permite solicitudes desde cualquier origen
                            .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH")  // Métodos permitidos
                            .allowCredentials(true)  // Permite el uso de credenciales si es necesario
                            .allowedHeaders("*");  // Permite cualquier encabezado
                }
            };
        }
    }
}
