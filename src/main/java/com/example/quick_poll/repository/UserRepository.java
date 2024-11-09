package com.example.quick_poll.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.quick_poll.model.User;

public interface UserRepository extends CrudRepository<User, Long>{

    public User findByUsername (String username);
}
