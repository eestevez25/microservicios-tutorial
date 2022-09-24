package com.microservices.carservice.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarDto {
    private Long carId;
    private String carName;
    private String carType;
    private Long userId;
}
