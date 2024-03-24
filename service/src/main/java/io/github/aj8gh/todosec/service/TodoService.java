package io.github.aj8gh.todosec.service;

import io.github.aj8gh.todosec.service.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TodoService {

  private final TodoRepository repository;

  void create() {
    repository.create();
  }

}
