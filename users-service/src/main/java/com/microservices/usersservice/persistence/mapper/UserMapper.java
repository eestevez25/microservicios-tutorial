package com.microservices.usersservice.persistence.mapper;

import com.microservices.usersservice.domain.dto.UserDto;
import com.microservices.usersservice.persistence.entity.User;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mappings({
            @Mapping(source = "id", target ="userId"),
            @Mapping(source = "name", target ="userName"),
            @Mapping(source = "email", target ="userEmail")
    })
    UserDto toUserDto(User user);
    List<UserDto> ToUserDtoList(List<User> userList);

    @InheritInverseConfiguration
    User toUser(UserDto userDto);
}
