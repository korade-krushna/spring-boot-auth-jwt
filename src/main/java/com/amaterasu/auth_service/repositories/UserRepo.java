package com.amaterasu.auth_service.repositories;

import com.amaterasu.auth_service.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {

    Optional<User> findByUsername(String username);
}
