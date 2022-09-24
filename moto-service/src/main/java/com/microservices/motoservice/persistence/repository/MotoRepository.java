package com.microservices.motoservice.persistence.repository;

import com.microservices.motoservice.domain.dto.MotoDto;
import com.microservices.motoservice.domain.repository.IMotoDomainRepository;
import com.microservices.motoservice.persistence.crud.IMotoRepository;
import com.microservices.motoservice.persistence.mapper.IMotoMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class MotoRepository implements IMotoDomainRepository {

    private IMotoRepository iMotoRepository;
    private IMotoMapper iMotoMapper;

    @Override
    public List<MotoDto> getAll() {
        return iMotoMapper.toMotoDtoList(iMotoRepository.findAll());
    }

    @Override
    public MotoDto save(MotoDto motoDto) {
        return iMotoMapper.toMotoDto(iMotoRepository.save(iMotoMapper.toMoto(motoDto)));
    }

    @Override
    public Optional<MotoDto> getMotoById(Long motoId) {
        return iMotoRepository.findById(motoId).map(moto -> iMotoMapper.toMotoDto(moto));
    }

    @Override
    public List<MotoDto> getMotosByUserId(Long userId) {
        return iMotoMapper.toMotoDtoList(iMotoRepository.findByUserId(userId));
    }
}
