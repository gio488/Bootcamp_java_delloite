package com.sunshine.cadastro_loja.service;

import com.sunshine.cadastro_loja.dto.ClienteDTO;
import com.sunshine.cadastro_loja.model.Cliente;
import com.sunshine.cadastro_loja.repository.ClienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)

@MockitoSettings(strictness = Strictness.LENIENT)
public class ClienteServiceTest {

    @Mock
    private ClienteRepository repository;

    @InjectMocks
    private ClienteService service;

    private ValidadorCliente validadorMock;

    @BeforeEach
    void setup() {

        validadorMock = Mockito.mock(ValidadorCliente.class);


        List<ValidadorCliente> listaValidadores = new ArrayList<>();
        listaValidadores.add(validadorMock);


        ReflectionTestUtils.setField(service, "validadores", listaValidadores);
    }

    @Test
    @DisplayName("Deve salvar um cliente com sucesso")
    void deveSalvarComSucesso() {
        ClienteDTO dto = new ClienteDTO("Giovanna", "12345678900");
        Cliente clienteSimulado = new Cliente();
        clienteSimulado.setNome("Giovanna");

        Mockito.when(repository.save(any(Cliente.class))).thenReturn(clienteSimulado);

        Cliente resultado = service.salvar(dto);

        assertNotNull(resultado);
        Mockito.verify(repository).save(any(Cliente.class));
    }

    @Test
    @DisplayName("Deve lançar exceção quando CPF for inválido")
    void deveLancarExcecaoQuandoCpfInvalido() {
        ClienteDTO dtoInvalido = new ClienteDTO("Giovanna", "123");

        Mockito.doThrow(new RuntimeException("CPF inválido"))
                .when(validadorMock).validar(any(ClienteDTO.class));


        assertThrows(RuntimeException.class, () -> service.salvar(dtoInvalido));

        Mockito.verify(repository, Mockito.never()).save(any(Cliente.class));
    }

    @Test
    @DisplayName("Deve buscar por ID com sucesso")
    void deveBuscarPorId() {
        Long id = 1L;
        Mockito.when(repository.findById(id)).thenReturn(Optional.of(new Cliente()));
        assertNotNull(service.buscarPorId(id));
    }

    @Test
    @DisplayName("Deve excluir um cliente com sucesso")
    void deveExcluirComSucesso() {
        Long id = 1L;
        Cliente cliente = new Cliente();
        Mockito.when(repository.findById(id)).thenReturn(Optional.of(cliente));
        service.excluir(id);
        Mockito.verify(repository).delete(cliente);
    }

    @Test
    @DisplayName("Deve listar todos")
    void deveListarTodos() {
        Mockito.when(repository.findAll()).thenReturn(List.of(new Cliente()));
        assertFalse(service.listarTodos().isEmpty());
    }

    @Test
    @DisplayName("Deve atualizar com sucesso")
    void deveAtualizarComSucesso() {
        Long id = 1L;
        ClienteDTO dto = new ClienteDTO("Novo Nome", "12345678900");
        Cliente cliente = new Cliente();

        Mockito.when(repository.findById(id)).thenReturn(Optional.of(cliente));
        Mockito.when(repository.save(any(Cliente.class))).thenReturn(cliente);

        assertNotNull(service.atualizar(id, dto));
    }
}