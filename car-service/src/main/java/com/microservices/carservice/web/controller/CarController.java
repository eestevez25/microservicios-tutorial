package com.microservices.carservice.web.controller;

import com.microservices.carservice.domain.dto.CarDto;
import com.microservices.carservice.domain.service.CarService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
@RestControllerAdvice
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/all")
    public ResponseEntity<List<CarDto>> getAll(){
        List<CarDto>carDtoList = carService.getAll();
        return getCarListResponseEntity(carDtoList);
    }

    @PostMapping("/save")
    public ResponseEntity<CarDto> save(@RequestBody CarDto carDto){
        return ResponseEntity.ok(carService.save(carDto));
    }

    @GetMapping("/{carId}")
    public ResponseEntity<CarDto> getCarById(@PathVariable Long carId){
        return ResponseEntity.of(carService.getById(carId));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<CarDto>> getCarsByUserId(@PathVariable Long userId){
        List<CarDto>carDtoList = carService.getCarsByUserId(userId);
        return getCarListResponseEntity(carDtoList);

    }

    private ResponseEntity<List<CarDto>> getCarListResponseEntity(List<CarDto> carDtoList) {
        if(carDtoList.isEmpty()){
            ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(carDtoList);
    }
}
