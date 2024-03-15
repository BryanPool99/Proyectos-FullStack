package com.bryan.eventos.persistence;


import com.bryan.eventos.entity.EventoPredefinido;

import java.util.List;
import java.util.Optional;

public interface IEventoPredefinidoDAO {
    List<EventoPredefinido> findAll();
    Optional<EventoPredefinido> findById(Long id);
    void save(EventoPredefinido eventoPredefinido);
    void deleteById(Long id);
}
