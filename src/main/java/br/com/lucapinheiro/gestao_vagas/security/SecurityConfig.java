package br.com.lucapinheiro.gestao_vagas.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    
    // Para que é isso? Para configurar o Spring Security para desabilitar o CSRF e então eu configure o Security
    // da minha aplicação de outra forma, por exemplo, com JWT.
    
    @Bean // para indicar que um método dentro da classe de configuração está sendo usado 
          // para definir algum objeto já gerenciado pelo spring
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable());
        return http.build();
    }
}
