package com.sunshine.cadastro_loja.service;

import com.sunshine.cadastro_loja.dto.ClienteDTO;
import com.sunshine.cadastro_loja.model.Cliente;
import com.sunshine.cadastro_loja.repository.ClienteRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class ClienteServiceTest {

    @Mock
    private ClienteRepository repository;

    @InjectMocks
    private ClienteService service;

    @Test
    @DisplayName("Deve salvar um cliente com sucesso")
    void deveSalvarComSucesso() {
        ClienteDTO dto = new ClienteDTO("Giovanna", "12345678900");
        Cliente clienteSimulado = new Cliente();
        clienteSimulado.setId(1L);
        clienteSimulado.setNome("Giovanna");
        clienteSimulado.setCpf("12345678900");

        Mockito.when(repository.save(any(Cliente.class))).thenReturn(clienteSimulado);

        Cliente resultado = service.salvar(dto);

        assertNotNull(resultado);
        assertEquals("Giovanna", resultado.getNome());
        Mockito.verify(repository, Mockito.times(1)).save(any(Cliente.class));
    }

    @Test
    @DisplayName("Deve lançar exceção ao buscar cliente inexistente")
    void deveLancarExcecaoAoBuscarInexistente() {
        Mockito.when(repository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> {
            service.buscarPorId(99L);
        });
    }

    @Test
    @DisplayName("Deve excluir um cliente com sucesso")
    void deveExcluirComSucesso() {
        Long idExistente = 1L;
        Cliente clienteSimulado = new Cliente();
        clienteSimulado.setId(idExistente);


        Mockito.when(repository.findById(idExistente)).thenReturn(Optional.of(clienteSimulado));


        service.excluir(idExistente);


        Mockito.verify(repository, Mockito.times(1)).delete(clienteSimulado);
    }

    @Test
    @DisplayName("Deve listar todos os clientes")
    void deveListarTodosClientes() {
        Mockito.when(repository.findAll()).thenReturn(List.of(new Cliente()));

        var lista = service.listarTodos();

        assertNotNull(lista);
        assertFalse(lista.isEmpty());
    }

    @Test
    @DisplayName("Deve atualizar um cliente com sucesso")
    void deveAtualizarComSucesso() {
        Long idExistente = 1L;
        ClienteDTO novosDados = new ClienteDTO("Giovanna Alterada", "12345678900");

        Cliente clienteAntigo = new Cliente();
        clienteAntigo.setId(idExistente);
        clienteAntigo.setNome("Giovanna");

        Mockito.when(repository.findById(idExistente)).thenReturn(Optional.of(clienteAntigo));
        Mockito.when(repository.save(any(Cliente.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Cliente resultado = service.atualizar(idExistente, novosDados);

        assertEquals("Giovanna Alterada", resultado.getNome());
        Mockito.verify(repository).save(any(Cliente.class));
    }
}