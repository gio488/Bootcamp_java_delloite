package com.sunshine.cadastro_loja.controller;

import com.sunshine.cadastro_loja.dto.ClienteDTO;
import com.sunshine.cadastro_loja.model.Cliente;
import com.sunshine.cadastro_loja.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/view/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping
    public String abrirPagina(Model model) {
        model.addAttribute("clienteDTO", new ClienteDTO(null, null, null));
        return "clientes";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute("clienteDTO") ClienteDTO dados, Model model) {
        try {
            Cliente clienteSalvo = service.salvar(dados);
            model.addAttribute("cliente", clienteSalvo);
            model.addAttribute("clienteDTO", new ClienteDTO(null, null, null));
            return "clientes";
        } catch (RuntimeException e) {
            model.addAttribute("erro", e.getMessage());
            return "clientes";
        }
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Cliente c = service.buscarPorId(id);
        ClienteDTO dto = new ClienteDTO(c.getId(), c.getNome(), c.getCpf());

        model.addAttribute("clienteDTO", dto);
        model.addAttribute("cliente", c);
        return "clientes";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        service.excluir(id);
        return "redirect:/view/clientes";
    }
}