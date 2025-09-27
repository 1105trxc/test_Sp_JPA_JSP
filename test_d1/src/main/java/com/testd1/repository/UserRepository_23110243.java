package com.testd1.repository;
import com.testd1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository_23110243 extends JpaRepository<User, String> {
    Optional<User> findByUsernameAndPassword(String username, String password);
}