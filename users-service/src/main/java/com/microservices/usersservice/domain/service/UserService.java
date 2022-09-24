package com.microservices.usersservice.domain.service;

import com.microservices.usersservice.domain.dto.CarDto;
import com.microservices.usersservice.domain.dto.MotoDto;
import com.microservices.usersservice.domain.dto.UserDto;
import com.microservices.usersservice.domain.repository.UserDomainRepository;
import com.microservices.usersservice.domain.service.feignclients.ICarFeignClient;
import com.microservices.usersservice.domain.service.feignclients.IMotoFeignClient;
import com.microservices.usersservice.persistence.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;

@Service
public class UserService {

    @Autowired
   private UserDomainRepository userDomainRepository;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ICarFeignClient iCarFeignClient;
    @Autowired
    private IMotoFeignClient iMotoFeignClient;

    @Value("${cars.endPoint}")
    private String carsEndPoint;

    @Value("${motos.endPoint}")
    private String motosEndPoint;

    public List<UserDto> getAll(){
        return userDomainRepository.getAll();
    }

    public Optional<UserDto> getUserById(Long userId){
        return userDomainRepository.getUserById(userId);
    }

    public UserDto save (UserDto userDto){
        return userDomainRepository.saveUser(userDto);
    }

    public List<CarDto> getCarDtoList(Long userId){
        return restTemplate.getForObject(carsEndPoint + userId, List.class);
    }

    public List<MotoDto> getMotoDtoList(Long userId){
        return restTemplate.getForObject(motosEndPoint + userId, List.class);
    }

    public CarDto saveCar(Long userId, CarDto carDto){
        carDto.setUserId(userId);
        return iCarFeignClient.save1(carDto);
    }

    public MotoDto saveMoto(Long userId, MotoDto motoDto){
        motoDto.setUserId(userId);
        return iMotoFeignClient.save(motoDto);
    }

    public List<CarDto> getCars(Long userId){
        return iCarFeignClient.getCarsByUser(userId);
    }

    public List<MotoDto> getMotos(Long userId){
        return iMotoFeignClient.getMotosByUser(userId);
    }

    public Map<String, Object> getUserAndVehicles(Long userId) {
        Map<String,Object> result = new HashMap<>();
        UserDto userDto = userDomainRepository.getUserById(userId).orElse(null);
        Predicate<UserDto> userDtoPredicate = userDto1 -> userDto1 != null;

        if(userDtoPredicate.test(userDto)){
            result.put("user", userDto);
            setVehicles(userId, result);
        } else{
            result.put("Mensaje", "El usuario no existe");
        }
        return result;
    }


    private void setVehicles(Long userId, Map<String, Object> result) {
        setCarList(userId, result);
        setMotoList(userId, result);
    }

    private void setMotoList(Long userId, Map<String, Object> result) {
        List<MotoDto> motoDtoList = iMotoFeignClient.getMotosByUser(userId);
        if(motoDtoList.isEmpty()){
            result.put("motoDtoList", "El usuario no tiene Motos");
        } else{
            result.put("motoDtoList", motoDtoList);
        }
    }

    private void setCarList(Long userId, Map<String, Object> result) {
        List<CarDto> carDtoList = iCarFeignClient.getCarsByUser(userId);
        if(carDtoList.isEmpty()){
            result.put("carDtoList", "El usuario no tiene carros");
        } else{
            result.put("carDtoList", carDtoList);
        }
    }
}
