package es.jose.biblioteca.config;

import java.util.Arrays;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

/**
 * Archivo de configuración de seguridad
 *
 * @since 29-oct-2018
 * @author joseb85
 */
//@Configuration
//@EnableWebSecurity
public class WebSecurityConfig /* extends WebSecurityConfigurerAdapter */ {

//    @Autowired
//    private DataSource dataSource;
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//        auth.jdbcAuthentication().dataSource(dataSource)
//                .usersByUsernameQuery("select username, password, enabled"
//                        + " from users where username=?")
//                .authoritiesByUsernameQuery("select username, authority "
//                        + "from authorities where username=?")
//                .passwordEncoder(new BCryptPasswordEncoder());
//    }
//
//    /**
//     * Habilita la protección de las URL
//     *
//     * @param http
//     * @throws Exception .anyRequest().authenticated() --> indica que todas las
//     * peticiones estarán protegidas httpBasic() --> activa la protección HTTP
//     * básica csrf().disable() --> desactiva la protección contra ataques CSRF
//     * .antMatchers("...").hasRole("...") --> define cuales roles de usuario
//     * pueden acceder a una determinada URL formLogin() --> activa el formulario
//     * de autenticación por defecto .formLogin().loginPage("/login").permitAll()
//     * --> el formulario será definido en la página login.jsp logout() -->
//     * habilita el cierre de sesión de usuario, por defecto se usa la URL
//     * "/logout" .logout().permitAll() --> activa el cierre de sesión mediante
//     * la URL "/logout", cualquier usuario puede acceder a esta URL.
//     */
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().antMatchers("/**").permitAll();
////                .authorizeRequests()
//////                .antMatchers(HttpMethod.OPTIONS, "/login").permitAll()
////                .anyRequest()
////                .authenticated()
////                .and()
////                .httpBasic();
//    }
//
//    @Bean
//    CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration configuration = new CorsConfiguration();
//        configuration.setAllowedOrigins(Arrays.asList("*"));
//        configuration.setAllowedMethods(Arrays.asList("POST, GET, PUT, OPTIONS, DELETE"));
//        configuration.setAllowedHeaders(Arrays.asList("Origin, X-Requested-With, Content-Type, Accept, Authorization"));
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", configuration);
//        return source;
//    }
}
