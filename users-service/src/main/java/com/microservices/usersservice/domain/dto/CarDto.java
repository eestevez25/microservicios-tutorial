package com.microservices.usersservice.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CarDto {
    private String carName;
    private String carType;
    private Long userId;
}
