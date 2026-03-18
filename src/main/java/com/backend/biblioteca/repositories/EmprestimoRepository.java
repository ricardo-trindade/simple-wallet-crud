package com.backend.biblioteca.repositories;

import com.backend.biblioteca.entities.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {

}
