package com.microservices.usersservice.domain.service.feignclients;

import com.microservices.usersservice.domain.dto.CarDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name="car-service", url="http://localhost:8002", path = "/car")
public interface ICarFeignClient {

    @PostMapping("/save")
    public CarDto save1(@RequestBody CarDto carDto);


    @GetMapping("/user/{userId}")
    List<CarDto> getCarsByUser(@PathVariable Long userId);
}
