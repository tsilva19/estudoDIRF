package com.crud.dirf.demo.dto.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Beneficiario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String cpfCnpj;

    private String nome;
    private String tipo; // PF ou PJ

    @ManyToOne
    @JoinColumn(name = "declarante_id", nullable = false)
    private Declarante declarante;
}

