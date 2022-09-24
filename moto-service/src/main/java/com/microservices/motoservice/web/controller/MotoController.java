package com.microservices.motoservice.web.controller;

import com.microservices.motoservice.domain.dto.MotoDto;
import com.microservices.motoservice.domain.service.MotoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;

@RestController
@RequestMapping("/moto")
@AllArgsConstructor
public class MotoController {

    private MotoService motoService;

    @GetMapping("/all")
    public ResponseEntity<List<MotoDto>> gerAll(){
        List<MotoDto> motoAll = motoService.getAll();
        return getMotoListResponseEntity(motoAll);
    }

    @PostMapping("/save")
    public ResponseEntity<MotoDto> save(@RequestBody MotoDto motoDto){
        return ResponseEntity.ok(motoService.save(motoDto));
    }

    @GetMapping("/{motoId}")
    public ResponseEntity<MotoDto> getMotoById(@PathVariable Long motoId){
        return ResponseEntity.of(motoService.getMotoById(motoId));
    }


    @GetMapping("/moto/{userId}")
    public ResponseEntity<List<MotoDto>> getMotoByUserId(@PathVariable Long userId){
        List<MotoDto> motoAll = motoService.getMotosByUserId(userId);
        return getMotoListResponseEntity(motoAll);
    }

    private ResponseEntity<List<MotoDto>> getMotoListResponseEntity(List<MotoDto> motoDtoList) {
        if(motoDtoList.isEmpty()){
            ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(motoDtoList);
    }
}
