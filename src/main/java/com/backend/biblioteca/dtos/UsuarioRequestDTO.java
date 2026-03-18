package com.backend.biblioteca.dtos;

import jakarta.validation.constraints.NotBlank;

public record UsuarioRequestDTO(
        @NotBlank String nome,
        @NotBlank String email
) {
}
