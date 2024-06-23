package io.github.aj8gh.todosec.api.controller;

import static io.github.aj8gh.todosec.api.constant.Endpoints.BASIC;
import static io.github.aj8gh.todosec.api.constant.Endpoints.DECODE_TOKEN;
import static io.github.aj8gh.todosec.api.constant.Endpoints.JWT;
import static io.github.aj8gh.todosec.api.constant.Endpoints.O_AUTH_2;
import static io.github.aj8gh.todosec.api.constant.Endpoints.TOKEN;

import io.github.aj8gh.todosec.api.model.Token;
import io.github.aj8gh.todosec.api.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

  private static final String JWT_RESPONSE = "*** Authenticated by JWT ***";
  private static final String BASIC_RESPONSE = "*** Authenticated by basic authentication ***";
  private static final String O_AUTH_2_RESPONSE = "*** Authenticated by OAuth 2.0 ***";

  private final JwtService service;

  @GetMapping(TOKEN)
  public String getToken() {
    return service.generateToken();
  }

  @GetMapping(JWT)
  public String temp() {
    return JWT_RESPONSE;
  }

  @GetMapping(DECODE_TOKEN)
  public Token decodeToken(JwtAuthenticationToken token) {
    return new Token(token.getToken(), token.getAuthorities());
  }

  @GetMapping(BASIC)
  public String basic() {
    return BASIC_RESPONSE;
  }

  @GetMapping(O_AUTH_2)
  public String oAuth2() {
    return O_AUTH_2_RESPONSE;
  }
}
