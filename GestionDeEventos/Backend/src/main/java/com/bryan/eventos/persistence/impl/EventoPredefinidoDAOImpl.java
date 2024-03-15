package com.bryan.eventos.persistence.impl;

import com.bryan.eventos.entity.EventoPredefinido;
import com.bryan.eventos.persistence.IEventoPredefinidoDAO;
import com.bryan.eventos.repository.EventoPredefinidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EventoPredefinidoDAOImpl implements IEventoPredefinidoDAO {
    //INYECCION
    @Autowired
    private EventoPredefinidoRepository eventoPredefinidoRepository;
    @Override
    public List<EventoPredefinido> findAll() {
        return (List<EventoPredefinido>) eventoPredefinidoRepository.findAll();
    }

    @Override
    public Optional<EventoPredefinido> findById(Long id) {
        return eventoPredefinidoRepository.findById(id);
    }

    @Override
    public void save(EventoPredefinido eventoPredefinido) {
        eventoPredefinidoRepository.save(eventoPredefinido);
    }

    @Override
    public void deleteById(Long id) {
        eventoPredefinidoRepository.deleteById(id);
    }
}
