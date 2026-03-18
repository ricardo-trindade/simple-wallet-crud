package com.backend.biblioteca.dtos;

import java.time.LocalDate;

public record EmprestimoDTO(
        Long id,
        LocalDate dataEmprestimo,
        LocalDate dataDevolucao
) {
}
