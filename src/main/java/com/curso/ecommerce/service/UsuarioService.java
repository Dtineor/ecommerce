package com.curso.ecommerce.service;

import com.curso.ecommerce.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {



        public Usuario register(Usuario usuario);
        public Optional<Usuario> get(Integer id);
        public void update(Usuario Usuario);
        public void delete(Integer id );

        public List<Usuario> findAll();



}
