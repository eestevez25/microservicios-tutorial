package com.microservices.carservice.persistence.repository;

import com.microservices.carservice.domain.dto.CarDto;
import com.microservices.carservice.domain.repository.ICarDomainRepository;
import com.microservices.carservice.persistence.crud.ICarCrudRepository;
import com.microservices.carservice.persistence.entity.Car;
import com.microservices.carservice.persistence.mapper.ICarMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Repository
public class CarRepository implements ICarDomainRepository {

    private ICarMapper iCarMapper;

    private ICarCrudRepository iCarCrudRepository;

    @Override
    public List<CarDto> getAll() {
       List<Car> carList = iCarCrudRepository.findAll();
       return iCarMapper.toCarDtoList(carList);
    }

    @Override
    public CarDto save(CarDto carDto) {
        Car car = iCarCrudRepository.save(iCarMapper.toCar(carDto));
        return iCarMapper.toCarDto(car);
    }

    @Override
    public Optional<CarDto> getById(Long carId) {
        return iCarCrudRepository.findById(carId).map(car -> iCarMapper.toCarDto(car));
    }

    @Override
    public List<CarDto> getCarsByUserId(Long userId) {
        return iCarMapper.toCarDtoList(iCarCrudRepository.findByUserId(userId));
    }
}
