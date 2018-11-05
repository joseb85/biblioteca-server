package es.jose.biblioteca.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Archivo de configuración de la app
 * @since 28-oct-2018
 * @author joseb85
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"es.jose.biblioteca"})
public class WebAppConfig implements WebMvcConfigurer {
    
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**");
//    }

    /**
     * Permite el acceso a las vistas. Eliminar esto provoca un 404 al intentar
     * acceder a la aplicación
     * <p>
     * Llamando enable () en el predeterminado DefaultHandlerConfigurer, está
     * pidiendo a DispatcherServlet que reenvíe solicitudes de recursos
     * estáticos al servlet predeterminado del contenedor de servlet y no
     * intente manejarlos por sí mismo.
     *
     * @param configurer
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

}
