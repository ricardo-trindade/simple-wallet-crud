package com.backend.biblioteca.services;

import com.backend.biblioteca.dtos.CarteiraRequestDTO;
import com.backend.biblioteca.dtos.CarteiraResponseDTO;
import com.backend.biblioteca.entities.CarteiraBiblioteca;
import com.backend.biblioteca.entities.Usuario;
import com.backend.biblioteca.repositories.CarteiraRepository;
import com.backend.biblioteca.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CarteiraService {

    private final CarteiraRepository carteiraRepository;
    private final UsuarioRepository usuarioRepository;

    private CarteiraResponseDTO toResponseDTO(CarteiraBiblioteca carteira) {
        return new CarteiraResponseDTO(
                carteira.getId(),
                carteira.getDataEmissao(),
                carteira.getIsValid()
        );
    }

    @Transactional
    public CarteiraResponseDTO criarCarteira(CarteiraRequestDTO dto) {
        Usuario usuario = usuarioRepository.findById(dto.usuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (usuario.getCarteira() != null) {
            throw new RuntimeException("Usuário já possui uma carteira");
        }

        CarteiraBiblioteca carteira = new CarteiraBiblioteca();
        carteira.setDataEmissao(dto.dataEmissao());
        carteira.setIsValid(dto.isValid());
        carteira.setUsuario(usuario);

        CarteiraBiblioteca saved = carteiraRepository.save(carteira);
        return toResponseDTO(saved);
    }
}
