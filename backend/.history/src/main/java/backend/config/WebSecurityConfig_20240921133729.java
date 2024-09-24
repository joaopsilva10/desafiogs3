package backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.Usuario;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable() 
            .authorizeHttpRequests((requests) -> requests
                .antMatchers("/", "/auth/login").permitAll()  
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

    
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = Usuario.withDefaultPasswordEncoder()
            .username("admin")
            .password("admin")
            .roles("ADMIN")
            .build();
        
        return new InMemoryUserDetailsManager(user);
    }
}
