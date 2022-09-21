package com.curso.ecommerce.controller;

import com.curso.ecommerce.model.Alimento;
import com.curso.ecommerce.service.AlimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/administrador")
public class AdministradorController {

    @Autowired
    private AlimentoService alimentoService;

    @GetMapping("")
    public String home(Model model){
        List<Alimento> alimentos = alimentoService.findAll();
        model.addAttribute("alimentos",alimentos);

        return "administrador/home";
    }

}
