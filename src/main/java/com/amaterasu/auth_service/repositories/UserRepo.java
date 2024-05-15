package com.amaterasu.auth_service.repositories;

import com.amaterasu.auth_service.entities.User;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {

    Optional<User> findByUsername(String username);
}
