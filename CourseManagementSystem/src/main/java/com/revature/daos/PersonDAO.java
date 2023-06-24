package com.revature.daos;

import com.revature.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonDAO extends JpaRepository<Person, Integer> {
    boolean existsByUsername(String username);

    Optional<Object> findByUsername(String username);
}