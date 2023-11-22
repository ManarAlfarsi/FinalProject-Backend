package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Role;
import com.example.demo.model.User;

import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * UserRepository
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    List<User> findByRole(Role role);

}
