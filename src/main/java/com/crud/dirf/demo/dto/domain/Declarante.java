package com.crud.dirf.demo.dto.domain;

import com.crud.dirf.demo.enumerate.TipoDeclarante;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Declarante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String cpfCnpj;

    private String nomeDeclarante;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoDeclarante tipo;

    @OneToMany(mappedBy = "declarante", cascade = CascadeType.ALL)
    private List<Rendimento> rendimentos;

}
