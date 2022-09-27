package com.microservices.usersservice.domain.service.feignclients;

import com.microservices.usersservice.domain.dto.CarDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@FeignClient(name="car-service", url="http://localhost:8080", path = "/car")
@FeignClient(name="car-service", path = "/car")
public interface ICarFeignClient {

    @PostMapping("/save")
    public CarDto save1(@RequestBody CarDto carDto);


    @GetMapping("/user/{userId}")
    List<CarDto> getCarsByUser(@PathVariable Long userId);
}
