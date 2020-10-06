package ru.rybinskov.gb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rybinskov.gb.domain.User;


public interface UserDao extends JpaRepository<User, Long> {
    User findFirstByName(String name);
}
