package backend.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.Usuario;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable() // Desabilitando CSRF para simplificar
            .authorizeHttpRequests((requests) -> requests
                .antMatchers("/login").permitAll()  // Permitir acesso ao endpoint de login sem autenticação
                .anyRequest().authenticated()  // Qualquer outra requisição deve ser autenticada
            )
            .formLogin()  // Usar autenticação baseada em formulário
                .loginPage("/login")  // Página de login customizada
                .permitAll()
            .and()
            .logout()  // Configuração de logout
                .permitAll();
        return http.build();
    }

    // Autenticação em memória (login: admin, senha: admin)
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
