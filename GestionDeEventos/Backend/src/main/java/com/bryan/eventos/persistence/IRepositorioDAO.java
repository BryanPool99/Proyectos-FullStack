package com.bryan.eventos.persistence;


import com.bryan.eventos.entity.Repositorio;

import java.util.List;
import java.util.Optional;

public interface IRepositorioDAO {
    List<Repositorio> findAll();
    Optional<Repositorio> findById(Long id);
    void save(Repositorio repositorio);
    void deleteById(Long id);
}
