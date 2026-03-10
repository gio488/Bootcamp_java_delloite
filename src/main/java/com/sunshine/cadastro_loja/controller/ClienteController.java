package com.sunshine.cadastro_loja.controller;

import com.sunshine.cadastro_loja.dto.ClienteDTO;
import com.sunshine.cadastro_loja.model.Cliente;
import com.sunshine.cadastro_loja.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;


    @PostMapping
    public Cliente cadastrar(@RequestBody ClienteDTO dados) {
        return service.salvar(dados);
    }


    @GetMapping
    public List<Cliente> listar() {
        return service.listarTodos();
    }


    @GetMapping("/{id}")
    public Cliente buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }


    @PutMapping("/{id}")
    public Cliente atualizar(@PathVariable Long id, @RequestBody ClienteDTO dados) {
        return service.atualizar(id, dados);
    }


    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.excluir(id);
    }
}