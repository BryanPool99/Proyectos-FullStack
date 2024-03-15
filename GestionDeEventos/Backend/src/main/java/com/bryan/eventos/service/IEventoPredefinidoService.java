package com.bryan.eventos.service;

import com.bryan.eventos.entity.EventoPredefinido;

import java.util.List;
import java.util.Optional;

public interface IEventoPredefinidoService {
    List<EventoPredefinido> findAll();
    Optional<EventoPredefinido> findById(Long id);
    void save(EventoPredefinido eventoPredefinido);
    void deleteById(Long id);
}
