package ru.danila.demooooo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.danila.demooooo.model.Todo;
import ru.danila.demooooo.repository.TodoRepository;

import java.util.List;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> getTodosByUserId(Long userId) {
        return todoRepository.findByUserId(userId);
    }

    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public Todo updateTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }

    public List<Todo> filterByStatus(String status) {
        return todoRepository.findByStatus(status);
    }



    public List<Todo> sortByDate() {
        Sort sort = Sort.by(Sort.Direction.ASC, "dateToComplete");
        return todoRepository.findAll(sort);
    }
}
