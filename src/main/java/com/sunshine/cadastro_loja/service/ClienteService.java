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

    // 1. Salvar
    public Cliente salvar(ClienteDTO dados) {
        Cliente cliente = new Cliente();
        cliente.setNome(dados.nome());
        cliente.setCpf(dados.cpf());
        return repository.save(cliente);
    }

    // 2. Listar Todos
    public List<Cliente> listarTodos() {
        return repository.findAll();
    }

    // 3. Buscar por ID (Consulta)
    public Cliente buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }

    // 4. Atualizar (Editar)
    public Cliente atualizar(Long id, ClienteDTO dados) {
        Cliente clienteExistente = buscarPorId(id);
        clienteExistente.setNome(dados.nome());
        clienteExistente.setCpf(dados.cpf());
        return repository.save(clienteExistente);
    }

    // 5. Excluir (Deletar)
    public void excluir(Long id) {
        Cliente cliente = buscarPorId(id);
        repository.delete(cliente);
    }
}