package com.backend.biblioteca.repositories;

import com.backend.biblioteca.entities.EmprestimoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmprestimoRepository extends JpaRepository<EmprestimoEntity, Long> {

}
