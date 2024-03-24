package io.github.aj8gh.todosec.service;

import static org.mockito.Mockito.verify;

import io.github.aj8gh.todosec.service.repository.TodoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TodoServiceTest {

  @Mock
  private TodoRepository repository;

  @InjectMocks
  private TodoService subject;

  @Test
  void create() {
    subject.create();
    verify(repository).create();
  }

}
