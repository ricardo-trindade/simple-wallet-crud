package com.backend.biblioteca.repositories;

import com.backend.biblioteca.entities.CarteiraBibliotecaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarteiraBibliotecaRepository extends JpaRepository<CarteiraBibliotecaEntity, Long> {
}
