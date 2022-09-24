package com.microservices.motoservice.persistence.mapper;

import com.microservices.motoservice.domain.dto.MotoDto;
import com.microservices.motoservice.persistence.entity.Moto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IMotoMapper {
    @Mappings({
            @Mapping(source = "id", target = "motoId"),
            @Mapping(source = "name", target = "motoName"),
            @Mapping(source = "type", target = "motoType"),
            @Mapping(source = "userId", target = "userId")
    })
    MotoDto toMotoDto(Moto moto);

    List<MotoDto> toMotoDtoList(List<Moto> motoList);

    @InheritInverseConfiguration
    Moto toMoto(MotoDto motoDto);
}
