package com.bryan.eventos.persistence;

import com.bryan.eventos.entity.Evento;

import java.util.List;
import java.util.Optional;

public interface IEventoDAO {
    List<Evento> findAll();
    Optional<Evento> findById(Long id);
    void save(Evento evento);
    void deleteById(Long id);
}
