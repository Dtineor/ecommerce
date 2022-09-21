package com.curso.ecommerce.service;

import com.curso.ecommerce.model.Usuario;
import com.curso.ecommerce.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class UsuarioServiceImpl  implements UsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario register(Usuario alimento) {
        return usuarioRepository.save(alimento);
    }

    @Override
    public Optional<Usuario> get(Integer id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public void update(Usuario alimento) {
        usuarioRepository.save(alimento);
    }

    @Override
    public void delete(Integer id)  { usuarioRepository.deleteById(id); }

    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

}
