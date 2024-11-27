package com.company.books.backend.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ConfigSecurity {
	
	@Bean
	public UserDetailsManager userDetailsManager(DataSource dataSource) {
		
		return new JdbcUserDetailsManager(dataSource);
	}
	
	/**
	 * Configura las reglas de seguridad para las solicitudes HTTP en la aplicación.
	 * Define los permisos de acceso según los roles de los usuarios para las diferentes rutas y métodos HTTP.
	 * 
	 * @Bean - Marca el método como un componente administrado por Spring, registrando esta configuración en el contexto.
	 * 
	 * @param http - Proporciona la configuración de seguridad para las solicitudes HTTP.
	 * @return SecurityFilterChain - La cadena de filtros de seguridad configurada.
	 * @throws Exception - Puede lanzar excepciones relacionadas con la configuración de seguridad.
	 */
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http)throws Exception {
		http.authorizeHttpRequests( configure ->{
			configure
				.requestMatchers(HttpMethod.GET, "/v1/libros").hasRole("Empleado")
				.requestMatchers(HttpMethod.GET, "/v1/libros/**").hasRole("Empleado")
				.requestMatchers(HttpMethod.GET, "/v1/libros").hasRole("Jefe")
				.requestMatchers(HttpMethod.GET, "/v1/libros/**").hasRole("Jefe")
				.requestMatchers(HttpMethod.POST, "/v1/libros").hasRole("Jefe")
				.requestMatchers(HttpMethod.PUT, "/v1/libros/**").hasRole("Jefe")
				.requestMatchers(HttpMethod.DELETE, "/v1/libros/**").hasRole("Jefe")
				.requestMatchers(HttpMethod.GET, "/v1/categorias").hasRole("Empleado")
				.requestMatchers(HttpMethod.GET, "/v1/categorias/**").hasRole("Empleado")
				.requestMatchers(HttpMethod.GET, "/v1/categorias").hasRole("Jefe")
				.requestMatchers(HttpMethod.GET, "/v1/categorias/**").hasRole("Jefe")
				.requestMatchers(HttpMethod.POST, "/v1/categorias").hasRole("Jefe")
				.requestMatchers(HttpMethod.PUT, "/v1/categorias/**").hasRole("Jefe")
				.requestMatchers(HttpMethod.DELETE, "/v1/categorias/**").hasRole("Jefe")
				.requestMatchers("/v1/authenticate").permitAll();
		});
		// Habilita la autenticación básica (Basic Auth) con configuración por defecto.
		http.httpBasic(Customizer.withDefaults());
		
		// Desactiva la protección CSRF (Cross-Site Request Forgery) para simplificar el desarrollo.
		http.csrf(csrf-> csrf.disable());
		
		return http.build();
		
	}
	
	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}
	
	 /**
     * Configuración de la seguridad en memoria para la aplicación.
     * 
     * Este componente define usuarios con sus nombres de usuario, contraseñas, 
     * y roles para ser utilizados en la autenticación de la aplicación. 
     * Los datos se almacenan en memoria, lo que es ideal para pruebas o aplicaciones 
     * simples, pero no recomendado para entornos de producción.
     * 
     * @return InMemoryUserDetailsManager que contiene los usuarios definidos.
     
	@Bean
	public InMemoryUserDetailsManager userDetailsManager() {
		
		UserDetails javier = User.builder()
				.username("javier")
				.password("{noop}1234")
				.roles("Empleado")
				.build();
		
		UserDetails maria = User.builder()
				.username("maria")
				.password("{noop}1234")
				.roles("Empleado","Jefe")
				.build();
		
		UserDetails alvaro = User.builder()
				.username("alvaro")
				.password("{noop}1234")
				.roles("Empleado","Jefe")
				.build();
		
		return new InMemoryUserDetailsManager(javier,maria,alvaro);
		
	}
	*/
}
