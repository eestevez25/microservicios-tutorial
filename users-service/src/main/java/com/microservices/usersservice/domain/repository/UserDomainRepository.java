package com.microservices.usersservice.domain.repository;

import com.microservices.usersservice.domain.dto.UserDto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface UserDomainRepository {
    List<UserDto> getAll();

    Optional<UserDto> getUserById(Long userId);

    UserDto saveUser(UserDto userDto);
}
