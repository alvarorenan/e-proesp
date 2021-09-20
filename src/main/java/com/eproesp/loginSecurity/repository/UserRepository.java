package com.eproesp.loginSecurity.repository;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.eproesp.loginSecurity.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>  {
    User findByUsername(String username);
   
}