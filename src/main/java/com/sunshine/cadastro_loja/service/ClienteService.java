package com.sunshine.cadastro_loja.service;

import com.sunshine.cadastro_loja.dto.ClienteDTO;
import com.sunshine.cadastro_loja.model.Cliente;
import com.sunshine.cadastro_loja.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Autowired
    private CPFvalidator cpfValidator;

    public Cliente salvar(ClienteDTO dados) {
        cpfValidator.validar(dados);

        Cliente cliente;
        if (dados.id() != null) {
            cliente = repository.findById(dados.id()).orElse(new Cliente());
        } else {
            cliente = new Cliente();
        }

        cliente.setNome(dados.nome());

        cliente.setCpf(dados.documento());

        return repository.save(cliente);
    }

    public List<Cliente> listarTodos() {
        return repository.findAll();
    }

    public Cliente buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }

    public Cliente atualizar(Long id, ClienteDTO dados) {
        return salvar(dados);
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }
}