package com.backend.biblioteca.services;

import com.backend.biblioteca.dtos.EmprestimoDTO;
import com.backend.biblioteca.dtos.EmprestimoRequestDTO;
import com.backend.biblioteca.entities.Emprestimo;
import com.backend.biblioteca.entities.Usuario;
import com.backend.biblioteca.repositories.EmprestimoRepository;
import com.backend.biblioteca.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmprestimoService {

    private final EmprestimoRepository repository;
    private final UsuarioRepository usuarioRepository;

    private EmprestimoDTO toDTO(Emprestimo emprestimo) {
        return new EmprestimoDTO(
                emprestimo.getId(),
                emprestimo.getDataEmprestimo(),
                emprestimo.getDataDevolucao()
        );
    }

    @Transactional
    public EmprestimoDTO criarEmprestimo(EmprestimoRequestDTO dto) {
        Usuario usuario = usuarioRepository.findById(dto.usuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setDataEmprestimo(dto.dataEmprestimo());
        emprestimo.setDataDevolucao(dto.dataDevolucao());
        emprestimo.setUsuario(usuario);

        Emprestimo saved = repository.save(emprestimo);
        return toDTO(saved);
    }

    @Transactional(readOnly = true)
    public List<EmprestimoDTO> listarEmprestimosPorUsuario(Long usuarioId) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        return usuario.getEmprestimos().stream().map(this::toDTO).toList();
    }
}
