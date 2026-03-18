package com.backend.biblioteca.repositories;

import com.backend.biblioteca.entities.CarteiraBiblioteca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarteiraRepository extends JpaRepository<CarteiraBiblioteca, Long> {
}
