package com.microservices.motoservice.domain.repository;

import com.microservices.motoservice.domain.dto.MotoDto;

import java.util.List;
import java.util.Optional;

public interface IMotoDomainRepository {
    List<MotoDto> getAll();

    MotoDto save(MotoDto motoDto);

    Optional<MotoDto> getMotoById(Long motoId);

    List<MotoDto> getMotosByUserId(Long userId);
}
