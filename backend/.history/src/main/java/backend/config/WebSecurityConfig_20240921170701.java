package backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable() 
            .authorizeHttpRequests((requests) -> requests
                .antMatchers("", "/auth/login").permitAll()  
                .anyRequest().authenticated()  
            )
            .formLogin()  
                .loginPage("/login")  
                .permitAll()
            .and()
            .logout()  
                .permitAll();
                
        http.csrf().disable();
        http.headers().frameOptions().disable();
        return http.build();
    }
}
