package com.microservices.usersservice.persistence.Repository;

import com.microservices.usersservice.domain.dto.UserDto;
import com.microservices.usersservice.domain.repository.UserDomainRepository;
import com.microservices.usersservice.persistence.crud.UserCrudRepository;
import com.microservices.usersservice.persistence.entity.User;
import com.microservices.usersservice.persistence.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository implements UserDomainRepository {
    @Autowired
    private UserCrudRepository userCrudRepository;

    @Autowired
    private UserMapper userMapper;
    @Override
    public List<UserDto> getAll() {
        List<User> Users = userCrudRepository.findAll();
        return userMapper.ToUserDtoList(Users);
    }

    @Override
    public Optional<UserDto> getUserById(Long userId) {
        return userCrudRepository.findById(userId).map(user -> userMapper.toUserDto(user));
    }

    @Override
    public UserDto saveUser(UserDto userDto) {
        User user = userCrudRepository.save(userMapper.toUser(userDto));
        return userMapper.toUserDto(user);
    }
}
