package com.crud.dirf.demo.services;

import com.crud.dirf.demo.dto.domain.Beneficiario;
import com.crud.dirf.demo.repository.BeneficiarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeneficiarioService {
    @Autowired
    private BeneficiarioRepository repository;

    public List<Beneficiario> listarTodos() {
        return repository.findAll();
    }

    public Beneficiario salvar(Beneficiario beneficiario) {
        return repository.save(beneficiario);
    }

    public Beneficiario atualizar(Long id, Beneficiario novoBeneficiario) {
        return repository.findById(id)
                .map(beneficiario -> {
                    beneficiario.setCpfCnpj(novoBeneficiario.getCpfCnpj());
                    beneficiario.setNome(novoBeneficiario.getNome());
                    beneficiario.setTipo(novoBeneficiario.getTipo());
                    return repository.save(beneficiario);
                }).orElseThrow(() -> new RuntimeException("Beneficiário não encontrado"));
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}

