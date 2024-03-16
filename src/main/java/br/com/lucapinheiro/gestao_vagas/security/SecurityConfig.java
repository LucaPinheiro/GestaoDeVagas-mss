package br.com.lucapinheiro.gestao_vagas.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class SecurityConfig {

    @Autowired
    private SecurityFilter securityFilter;

    // Para que é isso? Para configurar o Spring Security para desabilitar o CSRF e
    // então eu configure o Security
    // da minha aplicação de outra forma, por exemplo, com JWT.

    // para indicar que um método dentro da classe de configuração está sendo usado
    // para definir algum objeto já gerenciado pelo spring
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> { // Configuração de autorização das requisições
                    auth.requestMatchers("/candidate/").permitAll() // Permissão para criar candidato sem autenticação
                            .requestMatchers("/company/").permitAll() // Permissão para criar empresa sem autenticação
                            .requestMatchers("/candidate/auth").permitAll() // Permissão para autenticar candidato sem autenticação
                            .requestMatchers("/auth/company").permitAll(); // Permissão para autenticar empresa sem
                                                                           // autenticação
                    auth.anyRequest().authenticated(); // Qualquer outra requisição precisa de autenticação
                })
                .addFilterBefore(securityFilter, BasicAuthenticationFilter.class); // Adiciona o filtro de segurança para as
                                                                                 // requisições
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
