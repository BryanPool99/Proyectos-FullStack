package com.bryan.eventos.service;

import com.bryan.eventos.entity.Evento;

import java.util.List;
import java.util.Optional;

public interface IEventoService {
    List<Evento> findAll();
    Optional<Evento> findById(Long id);
    void save(Evento evento);
    void deleteById(Long id);
}
