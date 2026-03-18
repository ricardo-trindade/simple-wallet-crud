package com.backend.biblioteca.dtos;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record EmprestimoRequestDTO(
        @NotNull LocalDate dataEmprestimo,
        LocalDate dataDevolucao,
        @NotNull Long usuarioId
) {
}
