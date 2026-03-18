package com.backend.biblioteca.dtos;

import java.time.LocalDate;

public record CarteiraResponseDTO(
        Long id,
        LocalDate dataEmissao,
        Boolean isValid
) {
}
