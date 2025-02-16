package com.crud.dirf.demo.controller;

import com.crud.dirf.demo.dto.domain.Beneficiario;
import com.crud.dirf.demo.services.BeneficiarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/beneficiarios")
@Tag(name = "Beneficiarios", description = "API para gerenciamento de beneficiarios")
public class BeneficiarioController {
    @Autowired
    private BeneficiarioService service;

    @Operation(summary = "Lista todos os beneficiários")
    @GetMapping
    public List<Beneficiario> listar() {
        return service.listarTodos();
    }

    @Operation(summary = "Cadastra um novo beneficiário")
    @ApiResponse(responseCode = "201", description = "Beneficiário cadastrado com sucesso")
    @PostMapping
    public Beneficiario salvar(@RequestBody Beneficiario beneficiario) {
        return service.salvar(beneficiario);
    }

    @Operation(summary = "Atualiza um beneficiario")
    @PutMapping("/{id}")
    public Beneficiario atualizar(@PathVariable Long id, @RequestBody Beneficiario beneficiario) {
        return service.atualizar(id, beneficiario);
    }

    @Operation(summary = "Deleta um beneficiario pelo ID")
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}

