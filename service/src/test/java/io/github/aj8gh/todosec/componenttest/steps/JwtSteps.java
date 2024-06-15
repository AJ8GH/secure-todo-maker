package io.github.aj8gh.todosec.componenttest.steps;

import io.cucumber.java.en.Given;
import io.github.aj8gh.todosec.api.service.JwtService;
import io.github.aj8gh.todosec.componenttest.context.ScenarioContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class JwtSteps {

  private final JwtService jwtService;
  private final ScenarioContext scenarioContext;

  @Given("a valid jwt token")
  public void validJwtToken() {
    var token = jwtService.generateToken();
    scenarioContext.setToken(token);
  }

  @Given("an invalid jwt token")
  public void invalidJwtToken() {
    scenarioContext.setToken("invalid-token");
  }

  @Given("no jwt token")
  public void noJwtToken() {
    scenarioContext.setToken(null);
  }
}
