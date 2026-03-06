package com.backend.biblioteca.dtos;

public record EmprestimoDto(
        long id,
        String dataEmprestimo,
        String dataDevolucao
) {
}
