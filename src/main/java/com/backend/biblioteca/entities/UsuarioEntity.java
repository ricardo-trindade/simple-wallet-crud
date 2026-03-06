package com.backend.biblioteca.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuarios")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    @Email
    private String email;

    @OneToOne
    @JoinColumn(name = "carteira_biblioteca_id")
    CarteiraBibliotecaEntity carteiraBiblioteca;

    @OneToMany
    @JoinColumn(name = "emprestimo_id")
    private List<EmprestimoEntity> emprestimos;
}
