package io.github.aj8gh.todosec.api.model;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

public record Token(
    Jwt token,
    Collection<GrantedAuthority> authorities
) {

}
