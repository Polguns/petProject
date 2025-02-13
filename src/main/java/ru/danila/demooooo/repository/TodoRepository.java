package ru.danila.demooooo.repository;

import lombok.NonNull;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.danila.demooooo.model.Todo;
import ru.danila.demooooo.model.User;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    List<Todo> findByUserId(Long userId);

    List<Todo> findByStatus(String status);

    List<Todo> findAll(Sort sort);

    Long user(User user);

}
