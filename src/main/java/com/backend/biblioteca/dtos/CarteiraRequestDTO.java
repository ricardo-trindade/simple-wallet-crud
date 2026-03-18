package com.backend.biblioteca.dtos;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record CarteiraRequestDTO(
        @NotNull LocalDate dataEmissao,
        @NotNull Boolean isValid,
        @NotNull Long usuarioId
) {
}
