package com.bryan.eventos.service;

import com.bryan.eventos.entity.Repositorio;

import java.util.List;
import java.util.Optional;

public interface IRepositorioService {
    List<Repositorio> findAll();
    Optional<Repositorio> findById(Long id);
    void save(Repositorio repositorio);
    void deleteById(Long id);
}
