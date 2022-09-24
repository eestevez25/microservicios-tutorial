package com.microservices.usersservice.web.controller;

import com.microservices.usersservice.domain.dto.CarDto;
import com.microservices.usersservice.domain.dto.MotoDto;
import com.microservices.usersservice.domain.dto.UserDto;
import com.microservices.usersservice.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping("/user")
@RestControllerAdvice
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public ResponseEntity<List<UserDto>> getAll(){
        List<UserDto> userList = userService.getAll();
        if(userList.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(userList);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("userId") Long userId){
        return ResponseEntity.of(userService.getUserById(userId));
    }

    @PostMapping("/save")
    public ResponseEntity<UserDto> saveUser(@RequestBody UserDto userDto){
        return ResponseEntity.ok(userService.save(userDto));
    }

    @GetMapping("/cars/{userId}")
    public ResponseEntity<List<CarDto>> getCarList(@PathVariable Long userId){
        Optional<UserDto> user = userService.getUserById(userId);
        if(!user.isPresent()){
            return ResponseEntity.noContent().build();
        }
        List<CarDto> carDtoList = userService.getCarDtoList(userId);
        return ResponseEntity.ok(carDtoList);
    }

    @GetMapping("/motos/{userId}")
    public ResponseEntity<List<MotoDto>> getMotoList(@PathVariable Long userId){
        Optional<UserDto> user = userService.getUserById(userId);
        if(user.isPresent()){
            return ResponseEntity.noContent().build();
        }
        List<MotoDto> motoDtoList = userService.getMotoDtoList(userId);
        return ResponseEntity.ok(motoDtoList);
    }

    @PostMapping("/car/{userId}")
    public ResponseEntity<CarDto> carSave(@PathVariable("userId") Long userId, @RequestBody  CarDto carDto ){
        return ResponseEntity.ok(userService.saveCar(userId, carDto));
    }

    @PostMapping("/moto/{userId}")
    public ResponseEntity<MotoDto> motoSave(@PathVariable("userId") Long userId, @RequestBody  MotoDto motoDto ){
        return ResponseEntity.ok(userService.saveMoto(userId, motoDto));
    }

    @GetMapping("/all/{userId}")
    public ResponseEntity<Map<String, Object>> getAllVehicles(@PathVariable("userId") Long userId){
        Map<String, Object> result = userService.getUserAndVehicles(userId);
        return ResponseEntity.ok(result);
    }
}
