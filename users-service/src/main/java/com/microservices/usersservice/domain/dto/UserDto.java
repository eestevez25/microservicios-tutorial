package com.microservices.usersservice.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private Long userId;
    private String userName;
    private String userEmail;
}
