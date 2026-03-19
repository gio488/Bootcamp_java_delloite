package com.sunshine.cadastro_loja.service;

import com.sunshine.cadastro_loja.dto.ClienteDTO;
import org.springframework.stereotype.Component;

@Component
public class CPFvalidator implements ValidadorCliente {

    @Override
    public void validar(ClienteDTO dados) {
        if (dados.documento() == null || dados.documento().replaceAll("\\D", "").length() != 11) {
            throw new RuntimeException("CPF inválido! O CPF deve conter 11 dígitos.");
        }
    }
}