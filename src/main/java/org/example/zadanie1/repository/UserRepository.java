package org.example.zadanie1.repository;

import org.example.zadanie1.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> { }
