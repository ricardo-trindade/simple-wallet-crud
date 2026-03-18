package com.backend.biblioteca.services;

import com.backend.biblioteca.dtos.UsuarioRequestDTO;
import com.backend.biblioteca.dtos.UsuarioResponseDTO;
import com.backend.biblioteca.entities.Usuario;
import com.backend.biblioteca.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository repository;

    private UsuarioResponseDTO toResponseDTO(Usuario usuario) {
        return new UsuarioResponseDTO(
                usuario.getNome(),
                usuario.getEmail()
        );
    }

    @Transactional
    public UsuarioResponseDTO criarUsuario(UsuarioRequestDTO dto) {
        Usuario usuario = new Usuario();

        usuario.setNome(dto.nome());
        usuario.setEmail(dto.email());

        Usuario saved = repository.save(usuario);
        return toResponseDTO(saved);
    }

    @Transactional(readOnly = true)
    public List<UsuarioResponseDTO> listarUsuarios() {
        return repository.findAll().stream().map(this::toResponseDTO).toList();
    }

    @Transactional(readOnly = true)
    public UsuarioResponseDTO buscarPorId(Long id) {
        Usuario usuario = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        return toResponseDTO(usuario);
    }

    @Transactional
    public UsuarioResponseDTO atualizarUsuario(Long id, UsuarioRequestDTO dto) {
        Usuario usuario = repository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        usuario.setNome(dto.nome());
        usuario.setEmail(dto.email());

        Usuario saved = repository.save(usuario);
        return toResponseDTO(saved);
    }

    @Transactional
    public void deletarUsuario(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Usuario não encontrado");
        }

        repository.deleteById(id);
    }

}
