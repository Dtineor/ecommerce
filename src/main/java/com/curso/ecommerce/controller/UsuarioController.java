package com.curso.ecommerce.controller;

import com.curso.ecommerce.model.Usuario;
import com.curso.ecommerce.service.UsuarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    private final Logger LOGGER = LoggerFactory.getLogger(AlimentoController.class);

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/register")
    public String register(Usuario usuario){
        LOGGER.info("este es el usuario {}",usuario);

        usuarioServices.register(usuario);
        return "redirect:/usuario";
    }

}
