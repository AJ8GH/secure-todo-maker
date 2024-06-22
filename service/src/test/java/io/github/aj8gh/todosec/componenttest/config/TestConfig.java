package io.github.aj8gh.todosec.componenttest.config;

import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Configuration
public class TestConfig {

  private static final String ROOT_URI = "http://localhost";
  private static final String MESSAGE = "Error response, status {}, body {}";

  @Bean
  RestTemplate testRestTemplate() {
    return new RestTemplateBuilder()
        .rootUri(ROOT_URI)
        .defaultHeader(CONTENT_TYPE, APPLICATION_JSON_VALUE)
        .errorHandler(testResponseErrorHandler())
        .build();
  }

  @Bean
  ResponseErrorHandler testResponseErrorHandler() {
    return new ResponseErrorHandler() {
      @Override
      @SneakyThrows
      public boolean hasError(ClientHttpResponse response) {
        log.warn(MESSAGE, response.getStatusCode().value(), response.getBody());
        return false;
      }

      @Override
      @SneakyThrows
      public void handleError(ClientHttpResponse response) {
        log.warn(MESSAGE, response.getStatusCode().value(), response.getBody());
      }
    };
  }
}
