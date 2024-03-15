package com.bryan.eventos.persistence.impl;

import com.bryan.eventos.entity.Evento;
import com.bryan.eventos.persistence.IEventoDAO;
import com.bryan.eventos.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EventoDAOImpl implements IEventoDAO {
    //INYECCION
    @Autowired
    private EventoRepository eventoRepository;
    @Override
    public List<Evento> findAll() {
        return (List<Evento>) eventoRepository.findAll();
    }

    @Override
    public Optional<Evento> findById(Long id) {
        return eventoRepository.findById(id);
    }

    @Override
    public void save(Evento evento) {
        eventoRepository.save(evento);
    }

    @Override
    public void deleteById(Long id) {
        eventoRepository.deleteById(id);
    }
}
