package ru.danila.demooooo.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.danila.demooooo.model.Todo;
import ru.danila.demooooo.model.User;
import ru.danila.demooooo.repository.TodoRepository;
import ru.danila.demooooo.service.UserService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    private TodoRepository todoRepository;

    @GetMapping("/get")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @GetMapping("/tasks/{id}")
    public List<Todo> getAllTasks(@PathVariable Long id) {
        return todoRepository.findByUserId(id);
    }

}
