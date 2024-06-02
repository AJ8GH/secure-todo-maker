package io.github.aj8gh.todosec.api.controller;

import io.github.aj8gh.todosec.api.model.Token;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TokenController {

  @GetMapping("/token")
  public Token getToken(JwtAuthenticationToken token) {
    return new Token(token.getToken(), token.getAuthorities());
  }
}
