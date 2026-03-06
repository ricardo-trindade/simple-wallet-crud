package com.backend.biblioteca.dtos;

import java.time.LocalDate;

public record CarteiraBibliotecaDto(
        String numeroCarteira,
        LocalDate dataEmissao,
        Boolean isValid
) {
}
