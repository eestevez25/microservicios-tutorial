package com.microservices.usersservice.domain.service.feignclients;

import com.microservices.usersservice.domain.dto.CarDto;
import com.microservices.usersservice.domain.dto.MotoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name="moto-service", url="http://localhost:8003", path="/moto")
public interface IMotoFeignClient {

    @PostMapping("/save")
    public MotoDto save(@RequestBody MotoDto motoDto);



    @GetMapping("/moto/{userId}")
    List<MotoDto> getMotosByUser(@PathVariable Long userId);
}
