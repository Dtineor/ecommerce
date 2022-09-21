package com.curso.ecommerce.service;

import com.curso.ecommerce.model.Alimento;
import com.curso.ecommerce.repository.AlimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AlimentoServiceImpl implements AlimentoService{

    @Autowired
    private AlimentoRepository alimentoRepository;

    @Override
    public Alimento save(Alimento alimento) {
        return alimentoRepository.save(alimento);
    }

    @Override
    public Optional<Alimento> get(Integer id) {
        return alimentoRepository.findById(id);
    }

    @Override
    public void update(Alimento alimento) {
        alimentoRepository.save(alimento);
    }

    @Override
    public void delete(Integer id) {
        alimentoRepository.deleteById(id);
    }

    @Override
    public List<Alimento> findAll() {
        return alimentoRepository.findAll();
    }
}
