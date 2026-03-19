package com.sunshine.cadastro_loja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RevistaController {

    @GetMapping("/view/revistas/{id}")
    public String vitrine(@PathVariable Long id, Model model) {
        model.addAttribute("clientId", id);
        return "revistas";
    }
}