//package com.travel.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//import static org.springframework.security.config.Customizer.withDefaults;
//
//@Configuration // indicates that the class has @Bean definition methods
//@EnableWebSecurity
//public class Security {
//
//@Bean
// public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
// http.authorizeRequests()
//         .anyRequest().authenticated()
//         .and()
//         .httpBasic(withDefaults());
//
//         //.csrf().disable();
//// Needs authentication
////http.authorizeHttpRequests().anyRequest().authenticated();
////
////http.httpBasic(Customizer.withDefaults()).csrf().disable();;
////
////// http.formLogin();
// http
//         .authorizeRequests(authorizeRequests ->
//                 authorizeRequests
//                         .anyRequest().authenticated()
//         )
//         .httpBasic(withDefaults()).csrf(withDefaults()). // Disable CSRF protection
//
//
//
// return http.build();
// }
//}