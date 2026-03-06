package com.backend.biblioteca.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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
public class CarteiraBibliotecaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long numeroCarteira;

    @NotNull
    private LocalDate date;

    @NotNull
    private Boolean isValid;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private UsuarioEntity usuario;
}
