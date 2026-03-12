package com.sunshine.cadastro_loja.service;

import com.sunshine.cadastro_loja.dto.ClienteDTO;
import com.sunshine.cadastro_loja.service.ValidadorCliente;
import org.springframework.stereotype.Component;

@Component
public class CPFValidator implements ValidadorCliente {

    @Override
    public void validar(ClienteDTO dados) {
        if (dados.cpf().length() != 11) {
            throw new RuntimeException("CPF deve ter 11 dígitos");
        }
    }
}