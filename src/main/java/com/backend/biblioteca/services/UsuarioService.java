package com.backend.biblioteca.services;

import com.backend.biblioteca.dtos.UsuarioDto;
import com.backend.biblioteca.entities.UsuarioEntity;
import com.backend.biblioteca.repositories.UsuarioRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Transactional
    public UsuarioDto criarUsuario(UsuarioDto dto) {
        if (usuarioRepository.existsByEmail(dto.email())) {
            throw new IllegalArgumentException("Email já cadastrado");
        }

        UsuarioEntity usuarioEntity = new UsuarioEntity();
        usuarioEntity.setNome(dto.nome());
        usuarioEntity.setEmail(dto.email());

        UsuarioEntity savedUsuario = usuarioRepository.save(usuarioEntity);

        return new UsuarioDto(
                savedUsuario.getNome(),
                savedUsuario.getEmail()
        );
    }





}
