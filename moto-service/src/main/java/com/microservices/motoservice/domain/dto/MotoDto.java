package com.microservices.motoservice.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MotoDto {
    private Long motoId;
    private String motoName;
    private String motoType;
    private Long userId;
}
