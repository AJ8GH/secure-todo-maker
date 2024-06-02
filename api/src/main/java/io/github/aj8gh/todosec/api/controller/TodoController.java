package io.github.aj8gh.todosec.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {

  @GetMapping("/temp")
  public String temp() {
    return "*** temp ***";
  }
}
