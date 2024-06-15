package io.github.aj8gh.todosec.componenttest.steps;

import static org.assertj.core.api.Assertions.assertThat;

import io.cucumber.java.en.Then;
import io.github.aj8gh.todosec.componenttest.context.ScenarioContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ResponseSteps {

  private final ScenarioContext scenarioContext;

  @Then("a {int} response is returned")
  public void a200ResponseIsReturned(int expected) {
    var actual = scenarioContext.getResponse().getStatusCode().value();
    assertThat(actual).isEqualTo(expected);
  }
}
