package com.microservices.carservice.domain.repository;

import com.microservices.carservice.domain.dto.CarDto;

import java.util.List;
import java.util.Optional;

public interface ICarDomainRepository {
    List<CarDto> getAll();

    CarDto save(CarDto carDto);

    Optional<CarDto> getById(Long carId);

    List<CarDto> getCarsByUserId(Long userId);
}
