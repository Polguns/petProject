package ru.danila.demooooo.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.danila.demooooo.model.Todo;
import ru.danila.demooooo.model.User;
import ru.danila.demooooo.repository.UserRepository;
import ru.danila.demooooo.service.TodoService;
import ru.danila.demooooo.service.UserService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/todos")
public class TodoController {
    private final UserRepository userRepository;
    private TodoService todoService;

    private UserService userService;

    @GetMapping("/{userId}")
    public List<Todo> getTodoByUserId(@PathVariable Long userId) {
        return todoService.getTodosByUserId(userId);
    }

    @PostMapping("/{username}")
    public ResponseEntity<Todo> createTodo(@RequestBody Todo todo, @PathVariable String username) {
        User user = userService.findUserByUsername(username);
        todo.setUser(user);

        Todo createTodo = todoService.createTodo(todo);
        return ResponseEntity.ok(createTodo);
    }

    @PutMapping
    public Todo updateTodo(@RequestBody Todo todo) {
        return todoService.updateTodo(todo);
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
    }

    @GetMapping("/{username}/{status}")
    public List<Todo> filterByStatus(@PathVariable String username, @PathVariable String status) {
        userService.findUserByUsername(username);
        return todoService.filterByStatus(status);
    }

    @GetMapping("/{username}/sort")
    public List<Todo> sortByDate(@PathVariable String username) {
        userService.findUserByUsername(username);
        return todoService.sortByDate();
    }

}
