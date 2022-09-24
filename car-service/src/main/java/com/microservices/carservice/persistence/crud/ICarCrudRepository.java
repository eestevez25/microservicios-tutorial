package com.microservices.carservice.persistence.crud;

import com.microservices.carservice.persistence.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICarCrudRepository extends JpaRepository<Car,Long> {
    List<Car> findByUserId(Long userId);
}
