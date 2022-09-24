package com.microservices.carservice.persistence.mapper;

import com.microservices.carservice.domain.dto.CarDto;
import com.microservices.carservice.persistence.entity.Car;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ICarMapper {
    @Mappings({
            @Mapping(source = "id", target = "carId"),
            @Mapping(source = "name", target = "carName"),
            @Mapping(source = "type", target = "carType"),
            @Mapping(source = "userId", target = "userId")
    })
    CarDto toCarDto(Car car);
    List<CarDto> toCarDtoList(List<Car> carList);

    @InheritInverseConfiguration
    Car toCar(CarDto carDto);
}
