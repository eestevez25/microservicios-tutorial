package com.microservices.motoservice.domain.service;

import com.microservices.motoservice.domain.dto.MotoDto;
import com.microservices.motoservice.domain.repository.IMotoDomainRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MotoService {
    private IMotoDomainRepository iMotoDomainRepository;

    public List<MotoDto> getAll(){
        return iMotoDomainRepository.getAll();
    }

    public MotoDto save(MotoDto motoDto){
        return iMotoDomainRepository.save(motoDto);
    }

    public Optional<MotoDto> getMotoById(Long motoId){
        return iMotoDomainRepository.getMotoById(motoId);
    }

    public List<MotoDto> getMotosByUserId(Long userId){
        return iMotoDomainRepository.getMotosByUserId(userId);
    }
}
