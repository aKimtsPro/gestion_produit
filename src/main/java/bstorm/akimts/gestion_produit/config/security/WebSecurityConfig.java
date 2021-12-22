package bstorm.akimts.gestion_produit.config.security;

import bstorm.akimts.gestion_produit.config.security.jwt.JwtAuthFilter;
import bstorm.akimts.gestion_produit.config.security.jwt.JwtTokenProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.List;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final JwtTokenProvider provider;

    public WebSecurityConfig(JwtTokenProvider provider) {
        this.provider = provider;
    }

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf()
                .disable();

        // configuration des filtres
        http.addFilterBefore(new JwtAuthFilter(provider), UsernamePasswordAuthenticationFilter.class);

        // configuration de session
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);


        http.authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS).permitAll()
                .antMatchers("/produit/**").authenticated()
                .antMatchers("/is-logged").authenticated()
                .anyRequest().permitAll();

        http.headers()
                .frameOptions().disable();

    }
}
