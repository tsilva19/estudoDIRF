package com.crud.dirf.demo.controller;

import com.crud.dirf.demo.dto.domain.Rendimento;
import com.crud.dirf.demo.services.RendimentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rendimentos")
@Tag(name = "Rendimentos", description = "API para gerenciamento de rendimentos")
public class RendimentoController {
    @Autowired
    private RendimentoService service;

    @Operation(summary = "Lista todos os rendimentos")
    @GetMapping
    public List<Rendimento> listar() {
        return service.listarTodos();
    }

    @Operation(summary = "Cadastra um novo rendimento")
    @ApiResponse(responseCode = "201", description = "Rendimento cadastrado com sucesso")
    @PostMapping
    public Rendimento salvar(@RequestBody Rendimento rendimento) {
        return service.salvar(rendimento);
    }

    @Operation(summary = "Atualiza um rendimento")
    @PutMapping("/{id}")
    public Rendimento atualizar(@PathVariable Long id, @RequestBody Rendimento rendimento) {
        return service.atualizar(id, rendimento);
    }

    @Operation(summary = "Deleta um rendimento pelo ID")
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}

