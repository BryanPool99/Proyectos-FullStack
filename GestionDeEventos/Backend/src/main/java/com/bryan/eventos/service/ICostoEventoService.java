package com.bryan.eventos.service;

import com.bryan.eventos.entity.CostoEvento;

import java.util.List;
import java.util.Optional;

public interface ICostoEventoService {
    List<CostoEvento> findAll();
    Optional<CostoEvento> findById(Long id);
    void save(CostoEvento costoEvento);
    void deleteById(Long id);
}
