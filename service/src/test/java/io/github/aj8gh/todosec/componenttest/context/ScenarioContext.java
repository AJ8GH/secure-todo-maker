package io.github.aj8gh.todosec.componenttest.context;

import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Data
@Component
public class ScenarioContext {

  private String token;
  private ResponseEntity<?> response;
}
