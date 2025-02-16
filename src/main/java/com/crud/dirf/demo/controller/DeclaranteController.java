package com.crud.dirf.demo.controller;


import com.crud.dirf.demo.dto.domain.Declarante;
import com.crud.dirf.demo.services.DeclaranteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/declarantes")
@Tag(name = "Declarantes", description = "API para gerenciamento de declarantes")
public class DeclaranteController {
    @Autowired
    private DeclaranteService service;

    @Operation(summary = "Lista todos os declarantes")
    @ApiResponse(responseCode = "200", description = "Lista de declarantes retornada com sucesso")
    @GetMapping
    public List<Declarante> listar() {
        return service.listarTodos();
    }

    @Operation(summary = "Cadastra um novo declarante")
    @ApiResponse(responseCode = "201", description = "Declarante cadastrado com sucesso")
    @PostMapping
    public Declarante salvar(@RequestBody Declarante declarante) {
        return service.salvar(declarante);
    }

    @Operation(summary = "Atualiza um declarante")
    @PutMapping("/{id}")
    public Declarante atualizar(@PathVariable Long id, @RequestBody Declarante declarante) {
        return service.atualizar(id, declarante);
    }

    @Operation(summary = "Deleta um declarante pelo ID")
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
