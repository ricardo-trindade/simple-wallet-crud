package com.backend.biblioteca.controllers;

import com.backend.biblioteca.dtos.CarteiraRequestDTO;
import com.backend.biblioteca.dtos.CarteiraResponseDTO;
import com.backend.biblioteca.services.CarteiraService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carteiras")
@RequiredArgsConstructor
public class CarteiraController {

    private final CarteiraService service;

    @PostMapping
    public ResponseEntity<CarteiraResponseDTO> criarCarteira(@RequestBody @Valid CarteiraRequestDTO dto) {
        CarteiraResponseDTO response = service.criarCarteira(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
