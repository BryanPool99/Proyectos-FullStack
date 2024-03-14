package com.bryan.eventos.persistence.impl;

import com.bryan.eventos.entity.Repositorio;
import com.bryan.eventos.persistence.IRepositorioDAO;
import com.bryan.eventos.repository.RepositorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class RepositorioDAOImpl implements IRepositorioDAO {
    //INYECCION
    @Autowired
    private RepositorioRepository repositorioRepository;
    @Override
    public List<Repositorio> findAll() {
        return (List<Repositorio>) repositorioRepository.findAll();
    }

    @Override
    public Optional<Repositorio> findById(Long id) {
        return repositorioRepository.findById(id);
    }

    @Override
    public void save(Repositorio repositorio) {
        repositorioRepository.save(repositorio);
    }

    @Override
    public void deleteById(Long id) {
        repositorioRepository.deleteById(id);
    }
}
