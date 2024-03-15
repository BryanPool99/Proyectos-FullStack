package com.bryan.eventos.service.impl;

import com.bryan.eventos.entity.Evento;
import com.bryan.eventos.persistence.IEventoDAO;
import com.bryan.eventos.service.IEventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventoServiceImpl implements IEventoService {
    //INYECCION
    @Autowired
    private IEventoDAO eventoDAO;
    @Override
    public List<Evento> findAll() {
        return eventoDAO.findAll();
    }

    @Override
    public Optional<Evento> findById(Long id) {
        return eventoDAO.findById(id);
    }

    @Override
    public void save(Evento evento) {
        eventoDAO.save(evento);
    }

    @Override
    public void deleteById(Long id) {
        eventoDAO.deleteById(id);
    }
}
