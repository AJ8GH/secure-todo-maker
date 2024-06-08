package io.github.aj8gh.todosec.api.controller;

import io.github.aj8gh.todosec.api.model.Token;
import io.github.aj8gh.todosec.api.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TokenController {

  private final JwtService service;

  @GetMapping("/token")
  public String getToken() {
    return service.generateToken();
  }

  @GetMapping("/decode-token")
  public Token decodeToken(JwtAuthenticationToken token) {
    return new Token(token.getToken(), token.getAuthorities());
  }
}
