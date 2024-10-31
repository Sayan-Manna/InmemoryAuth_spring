package com.securitydemo.inmemorysecurity.config;

import com.securitydemo.inmemorysecurity.services.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

//import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {

//  private final DataSource dataSource;
  private final CustomUserDetailsService customUserDetailsService;


  @Bean
  SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

    httpSecurity
        .authorizeHttpRequests(auth -> auth
            .requestMatchers("/api/posts", "/error", "/h2-console/**", "/api/users").permitAll() // allow access to these endpoints without authentication or authorization
            .requestMatchers("/api/posts/**").hasAuthority("ADMIN") // only admin can access these endpoints
            .anyRequest().authenticated()); // all other requests need to be authenticated
    httpSecurity
//            .formLogin(Customizer.withDefaults())
            .httpBasic(Customizer.withDefaults())
            // Enable logout functionality
//            .logout(logout -> logout.permitAll())
            // disable csrf
            .csrf(csrfConfig -> csrfConfig.disable())
            // disable session management -> stateless
            .sessionManagement(sessionConfig -> sessionConfig.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

    // h2 console configuration
    httpSecurity.headers(headers -> headers.frameOptions(frameOptions -> frameOptions.sameOrigin()));

    return httpSecurity
        .build();
  }

//  @Bean
//  UserDetailsService myInMemoryUserDetailsService() {
//    UserDetails normalUser = User
//            .withUsername("sobom")
//            .password(passwordEncoder().encode("abc123"))
//            .roles("USER")
//            .build();
//    UserDetails adminUser = User
//            .withUsername("admin")
//            .password(passwordEncoder().encode("sayan123"))
//            .roles("ADMIN")
//            .build();
//
//    JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
//    jdbcUserDetailsManager.createUser(normalUser);
//    jdbcUserDetailsManager.createUser(adminUser);
//    return jdbcUserDetailsManager;
//    //return new InMemoryUserDetailsManager(normalUser, adminUser);
//  }
  @Bean
  public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
    return authenticationConfiguration.getAuthenticationManager();
  }
@Bean
public UserDetailsService userDetailsService() {

  return customUserDetailsService; // return your custom UserDetailsService
}
  @Bean
  PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
//  @Bean
//  public DaoAuthenticationProvider authenticationProvider() {
//    DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//    authProvider.setUserDetailsService(customUserDetailsService);
//    authProvider.setPasswordEncoder(passwordEncoder());
//    return authProvider;
//  }
  @Bean
  public AuthenticationProvider authenticationProvider() {
    DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
    daoAuthenticationProvider.setUserDetailsService(customUserDetailsService);
    daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
    return daoAuthenticationProvider;
  }


}
