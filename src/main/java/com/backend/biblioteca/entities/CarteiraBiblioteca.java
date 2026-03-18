package com.backend.biblioteca.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "carteira_biblioteca")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarteiraBiblioteca {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDate dataEmissao;
    private Boolean isValid;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
