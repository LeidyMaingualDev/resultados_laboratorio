package com.laboratorio.repositories;

import com.laboratorio.entities.users.User;
import com.laboratorio.entities.users.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    long countByRole(UserRole role);
}
