package com.stackroute.LoginService.repository;

import com.stackroute.LoginService.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {


    User findByNameAndPassword(String username, String password);

    boolean existsByName(String name);
}
