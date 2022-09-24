package com.microservices.usersservice.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MotoDto {
    private String motoName;
    private String motoType;
    private Long userId;
}
