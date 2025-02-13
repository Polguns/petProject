package ru.danila.demooooo.service;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Sort;
import ru.danila.demooooo.model.Todo;
import ru.danila.demooooo.repository.TodoRepository;

import java.time.LocalDate;
import java.util.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TodoServiceTest {
    @InjectMocks
    private TodoService todoService;

    @Mock
    private TodoRepository todoRepository;


    @Test
    void date_filterByDate_throwsExceptions() {
        Todo todo1 = new Todo();
        todo1.setDateToComplete(LocalDate.of(2024 ,11,12));
        Todo todo2 = new Todo();
        todo2.setDateToComplete(LocalDate.of(2024 ,11,10));
        Todo todo3 = new Todo();
        todo3.setDateToComplete(LocalDate.of(2024 ,11,13));

        List<Todo> unsortedList = Arrays.asList(todo2, todo1, todo3);
        List<Todo> expectedSortedTodos = Arrays.asList(todo2, todo1, todo3);

        when(todoRepository.findAll(any(Sort.class))).thenReturn(unsortedList);

        List<Todo> result = todoService.sortByDate();

        Assertions.assertEquals(expectedSortedTodos, result);

        verify(todoRepository, times(1)).findAll(Sort.by(Sort.Direction.ASC, "date_to_complete"));


    }

    @Test
    void status_findByStatus_throwExceptions() {
        Todo todo1 = new Todo();
        todo1.setStatus("Complete");
        Todo todo2 = new Todo();
        todo2.setStatus("Complete");
        Todo todo3 = new Todo();
        todo3.setStatus("Stopped");

        List<Todo> completedTodos = Arrays.asList(todo1, todo2); // Ожидаемый результат

        when(todoRepository.findByStatus("Complete")).thenReturn(completedTodos);

        List<Todo> result = todoService.filterByStatus("Complete");

        Assertions.assertEquals(completedTodos, result);

    }


}
