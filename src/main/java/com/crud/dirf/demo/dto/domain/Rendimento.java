package com.crud.dirf.demo.dto.domain;

import com.crud.dirf.demo.enumerate.TipoRendimento;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
public class Rendimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoRendimento tipoRendimento;

    private BigDecimal valor;
    private LocalDate dataPagamento;

    @ManyToOne
    @JoinColumn(name = "declarante_id", nullable = false)
    private Declarante declarante;
}

