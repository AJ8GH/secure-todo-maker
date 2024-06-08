package io.github.aj8gh.todosec.api.service;

import static java.time.temporal.ChronoUnit.DAYS;

import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.crypto.RSASSASigner;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import java.time.Instant;
import java.util.Date;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JwtService {

  private final RSAKey rsaKey;
  private final String issuer;
  private final int ttlDays;

  @SneakyThrows
  public String generateToken() {
    var signer = new RSASSASigner(rsaKey);
    var claimsSet = new JWTClaimsSet.Builder()
        .issuer(issuer)
        .expirationTime(Date.from(Instant.now().plus(ttlDays, DAYS)))
        .build();

    var jwt = new SignedJWT(
        new JWSHeader.Builder(JWSAlgorithm.RS256)
            .keyID(rsaKey.getKeyID())
            .build(),
        claimsSet);

    jwt.sign(signer);
    return jwt.serialize();
  }
}
