package com.bryan.eventos.service.impl;

import com.bryan.eventos.entity.EventoPredefinido;
import com.bryan.eventos.persistence.IEventoPredefinidoDAO;
import com.bryan.eventos.service.IEventoPredefinidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventoPredefinidoServiceImpl implements IEventoPredefinidoService {
    //INYECCION
    @Autowired
    private IEventoPredefinidoDAO eventoPredefinidoDAO;
    @Override
    public List<EventoPredefinido> findAll() {
        return eventoPredefinidoDAO.findAll();
    }

    @Override
    public Optional<EventoPredefinido> findById(Long id) {
        return eventoPredefinidoDAO.findById(id);
    }

    @Override
    public void save(EventoPredefinido eventoPredefinido) {
        eventoPredefinidoDAO.save(eventoPredefinido);
    }

    @Override
    public void deleteById(Long id) {
        eventoPredefinidoDAO.deleteById(id);
    }
}
