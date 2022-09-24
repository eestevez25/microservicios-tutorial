package com.microservices.carservice.domain.service;

import com.microservices.carservice.domain.dto.CarDto;
import com.microservices.carservice.domain.repository.ICarDomainRepository;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CarService {

    ICarDomainRepository iCarDomainRepository;

    public List<CarDto> getAll(){
        return iCarDomainRepository.getAll();
    }

    public CarDto save(CarDto carDto){
        return iCarDomainRepository.save(carDto);
    }

    public Optional<CarDto> getById(Long carId){
        return iCarDomainRepository.getById(carId);
    }

    public List<CarDto> getCarsByUserId(Long userId){
        return iCarDomainRepository.getCarsByUserId(userId);
    }
}
