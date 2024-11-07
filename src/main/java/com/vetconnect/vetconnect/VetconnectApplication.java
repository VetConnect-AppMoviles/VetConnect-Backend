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
                registry.addMapping("/**")
                        .allowedOrigins("https://resilient-contentment-production.up.railway.app", "http://localhost:60195")  // URL de producción y localhost para desarrollo
                        .allowedMethods("HEAD", "GET", "POST", "DELETE", "PATCH")  // Métodos permitidos
                        .allowCredentials(true)  // Permitir credenciales si es necesario
                        .allowedHeaders("*");  // Permitir cualquier encabezado
            }
        };
    }
}

}
