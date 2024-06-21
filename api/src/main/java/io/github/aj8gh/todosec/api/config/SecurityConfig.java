package io.github.aj8gh.todosec.api.config;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.gen.RSAKeyGenerator;
import io.github.aj8gh.todosec.api.service.JwtService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

  @Bean
  SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
    return httpSecurity.authorizeHttpRequests(authorize -> authorize
            .requestMatchers("/v1/token").permitAll()
            .anyRequest().authenticated())
        .oauth2ResourceServer(configure -> configure.jwt(Customizer.withDefaults()))
        .build();
  }

  @Bean
  JwtDecoder jwtDecoder(RSAKey rsaKey) throws JOSEException {
    return NimbusJwtDecoder
        .withPublicKey(rsaKey.toRSAPublicKey())
        .build();
  }

  @Bean
  JwtService jwtService(
      RSAKey rsaKey,
      @Value("${jwt.issuer}") String issuer,
      @Value("${jwt.ttl-days}") int ttlDays) {
    return new JwtService(rsaKey, issuer, ttlDays);
  }

  @Bean
  RSAKey rsaKey(
      @Value("${jwt.rsa-key.size}") int rsaKeySize,
      @Value("$jwt.rsa-key.id}") String id
  ) throws JOSEException {
    return new RSAKeyGenerator(rsaKeySize)
        .keyID(id)
        .generate();
  }
}
