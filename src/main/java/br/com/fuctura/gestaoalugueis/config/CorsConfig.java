package br.com.fuctura.gestaoalugueis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Configuração de CORS (Cross-Origin Resource Sharing).
 * Permite que a API seja acessada por clientes de diferentes origens.
 **/

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*").
                        allowedMethods("GET", "POST", "PUT", "DELETE").allowedHeaders("*");

            }
        };
    }
}
