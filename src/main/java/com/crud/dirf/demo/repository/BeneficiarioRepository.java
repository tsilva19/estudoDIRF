package com.crud.dirf.demo.repository;

import com.crud.dirf.demo.dto.domain.Beneficiario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeneficiarioRepository extends JpaRepository<Beneficiario, Long> {}

