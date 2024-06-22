package io.github.aj8gh.todosec.componenttest.client;

import static org.springframework.http.HttpMethod.GET;

import java.net.URI;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
@RequiredArgsConstructor
public class HttpClient {

  private static final String BASE_URI = "http://localhost:";
  private static final String PORT_PROPERTY = "local.server.port";

  private final RestTemplate restTemplate;
  private final Environment environment;

  public <T> ResponseEntity<T> get(String url, Class<T> responseType) {
    return restTemplate.getForEntity(url, responseType);
  }

  public <T> ResponseEntity<T> get(
      MultiValueMap<String, String> headers,
      String endpoint,
      Class<T> responseType) {
    var request = new RequestEntity<T>(headers, GET, uri(endpoint));
    var response = restTemplate.exchange(request, responseType);
    log.info("status {} body {}", response.getStatusCode(), response.getBody());
    return response;
  }

  private URI uri(String endpoint) {
    var uri = URI.create(BASE_URI + environment.getProperty(PORT_PROPERTY) + endpoint);
    log.info("{}", uri);
    return uri;
  }
}
