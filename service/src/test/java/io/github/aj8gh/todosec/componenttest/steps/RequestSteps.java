package io.github.aj8gh.todosec.componenttest.steps;

import io.cucumber.java.en.When;
import io.github.aj8gh.todosec.componenttest.client.HttpClient;
import io.github.aj8gh.todosec.componenttest.context.ScenarioContext;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;

@RequiredArgsConstructor
public class RequestSteps {

  private static final String BEARER = "Bearer ";

  private final HttpClient client;
  private final ScenarioContext scenarioContext;

  @When("a GET request is made to {string}")
  public void requestIsMade(String endpoint) {
    var headers = new HttpHeaders();
    headers.add(HttpHeaders.AUTHORIZATION, BEARER + scenarioContext.getToken());
    var response = client.get(headers, endpoint, String.class);
    scenarioContext.setResponse(response);
  }
}
