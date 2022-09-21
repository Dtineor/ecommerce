package com.curso.ecommerce.service;

import com.curso.ecommerce.model.Alimento;

import java.util.List;
import java.util.Optional;

public interface AlimentoService {
    public Alimento save(Alimento alimento);
    public Optional<Alimento> get(Integer id);
    public void update(Alimento alimento);
    public void delete(Integer id );

    public List<Alimento> findAll();


}
