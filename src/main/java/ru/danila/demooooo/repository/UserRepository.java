package ru.danila.demooooo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.danila.demooooo.model.User;


public interface UserRepository  extends JpaRepository<User, Long> {
    User findByUsername(String username);

}
