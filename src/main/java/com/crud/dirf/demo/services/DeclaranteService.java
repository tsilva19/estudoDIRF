package com.crud.dirf.demo.services;

import com.crud.dirf.demo.dto.domain.Declarante;
import com.crud.dirf.demo.repository.DeclaranteRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class DeclaranteService {
    @Autowired
    private DeclaranteRepository repository;

    public List<Declarante> listarTodos() {
        return repository.findAll();
    }

    public Declarante salvar(Declarante declarante) {
        return repository.save(declarante);
    }

    public Declarante atualizar(Long id, Declarante novoDeclarante) {
        return repository.findById(id)
                .map(declarante -> {
                    declarante.setCpfCnpj(novoDeclarante.getCpfCnpj());
                    declarante.setNomeDeclarante(novoDeclarante.getNomeDeclarante());
                    declarante.setTipo(novoDeclarante.getTipo());
                    return repository.save(declarante);
                }).orElseThrow(() -> new RuntimeException("Declarante não encontrado"));
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}


