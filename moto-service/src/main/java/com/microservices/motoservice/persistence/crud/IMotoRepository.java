package com.microservices.motoservice.persistence.crud;

import com.microservices.motoservice.persistence.entity.Moto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IMotoRepository extends JpaRepository<Moto, Long> {
    List<Moto> findByUserId(Long userId);
}
