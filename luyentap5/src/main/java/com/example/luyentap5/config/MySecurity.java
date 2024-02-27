//package com.example.luyentap5.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Configuration
//@EnableWebSecurity
//public class MySecurity {
//
//    //    @Bean
////    public PasswordEncoder passwordEncoder() {
////        return new BCryptPasswordEncoder();
////    }
//////
////    @Bean
////    public UserDetailsService authentication() {
////        PasswordEncoder encoder = passwordEncoder();
////
////        List<UserDetails> users = new ArrayList<>();
////
////        UserDetails userDetails = User.builder()
////                .username("HangNT169")
//////                .password("{noop}123@123")
////                .roles("ADMIN")
////                .password(encoder.encode("123@123"))
////                .build();
////        users.add(userDetails);
////
////        UserDetails admin = User.builder()
////                .username("admin")
////                .password(encoder.encode("12345"))
////                .roles("ADMIN")
////                .build();
////        users.add(admin);
////        //phải mã hoá mật khẩu or ko mã hoá
////        return new InMemoryUserDetailsManager(users);
////    }
//////
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity.authorizeHttpRequests(req -> req.requestMatchers(new AntPathRequestMatcher("/api/khachhang/list"))
//                .hasRole("ADMIN")
//                .anyRequest().permitAll())
//                .formLogin(login -> login.loginProcessingUrl("/login"))
//                .logout(logout -> logout.logoutUrl("/"))
//        ;
//        ;
//
//        return httpSecurity.build();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public UserDetailsService authentication() {
//        PasswordEncoder encoder = passwordEncoder();
//
//        List<UserDetails> users = new ArrayList<>();
//
//        UserDetails userDetails = User.builder()
//                .username("HangNT169")
//                .password(encoder.encode("123@123"))
//                .roles("ADMIN")
//                .build();
//        users.add(userDetails);
//
//        UserDetails admin = User.builder()
//                .username("admin")
//                .password(encoder.encode("12345"))
//                .roles("ADMIN")
//                .build();
//        users.add(admin);
//
//        return new InMemoryUserDetailsManager(users);
//    }
//
//
//}
