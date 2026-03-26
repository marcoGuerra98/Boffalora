package com.boffa.project.config;

import com.boffa.project.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/login", "/css/**", "/js/**").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/home", true)
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout")
                        .permitAll()
                )
                .userDetailsService(userDetailsService);

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();

        return new PasswordEncoder() {
            @Override
            public String encode(CharSequence rawPassword) {
                return bcrypt.encode(rawPassword);
            }

            @Override
            public boolean matches(CharSequence rawPassword, String storedPassword) {
                if (storedPassword == null) {
                    return false;
                }

                // Fallback temporaneo: supporta sia hash BCrypt sia password legacy in chiaro.
                if (storedPassword.startsWith("$2a$") || storedPassword.startsWith("$2b$") || storedPassword.startsWith("$2y$")) {
                    return bcrypt.matches(rawPassword, storedPassword);
                }

                return rawPassword.toString().equals(storedPassword);
            }

            @Override
            public boolean upgradeEncoding(String encodedPassword) {
                return encodedPassword == null
                        || (!encodedPassword.startsWith("$2a$")
                        && !encodedPassword.startsWith("$2b$")
                        && !encodedPassword.startsWith("$2y$"));
            }
        };
    }
}

