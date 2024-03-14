package com.bryan.eventos.service.impl;

import com.bryan.eventos.entity.Repositorio;
import com.bryan.eventos.persistence.IRepositorioDAO;
import com.bryan.eventos.service.IRepositorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RepositorioServiceImpl implements IRepositorioService {
    //INYECCION
    @Autowired
    private IRepositorioDAO repositorioDAO;

    @Override
    public List<Repositorio> findAll() {
        return repositorioDAO.findAll();
    }

    @Override
    public Optional<Repositorio> findById(Long id) {
        return repositorioDAO.findById(id);
    }

    @Override
    public void save(Repositorio repositorio) {
        repositorioDAO.save(repositorio);
    }

    @Override
    public void deleteById(Long id) {
        repositorioDAO.deleteById(id);
    }
}
