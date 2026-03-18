package com.backend.biblioteca.controllers;

import com.backend.biblioteca.dtos.EmprestimoDTO;
import com.backend.biblioteca.dtos.EmprestimoRequestDTO;
import com.backend.biblioteca.services.EmprestimoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emprestimos")
@RequiredArgsConstructor
public class EmprestimoController {

    private final EmprestimoService service;

    @PostMapping
    public ResponseEntity<EmprestimoDTO> criarEmprestimo(@RequestBody @Valid EmprestimoRequestDTO dto) {
        EmprestimoDTO response = service.criarEmprestimo(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<EmprestimoDTO>> listarEmprestimosPorUsuario(@PathVariable Long usuarioId) {
        List<EmprestimoDTO> response = service.listarEmprestimosPorUsuario(usuarioId);
        return ResponseEntity.ok(response);
    }
}
