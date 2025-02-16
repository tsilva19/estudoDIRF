package com.crud.dirf.demo.services;

import com.crud.dirf.demo.dto.domain.Rendimento;
import com.crud.dirf.demo.repository.RendimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RendimentoService {
    @Autowired
    private RendimentoRepository repository;

    public List<Rendimento> listarTodos() {
        return repository.findAll();
    }

    public Rendimento salvar(Rendimento rendimento) {
        return repository.save(rendimento);
    }

    public Rendimento atualizar(Long id, Rendimento novoRendimento) {
        return repository.findById(id)
                .map(rendimento -> {
                    rendimento.setTipoRendimento(novoRendimento.getTipoRendimento());
                    rendimento.setValor(novoRendimento.getValor());
                    rendimento.setDataPagamento(novoRendimento.getDataPagamento());
                    return repository.save(rendimento);
                }).orElseThrow(() -> new RuntimeException("Rendimento não encontrado"));
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}

