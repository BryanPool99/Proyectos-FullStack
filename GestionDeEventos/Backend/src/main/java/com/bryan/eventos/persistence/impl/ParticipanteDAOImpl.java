package com.bryan.eventos.persistence.impl;

import com.bryan.eventos.entity.Participante;
import com.bryan.eventos.persistence.IParticipanteDAO;
import com.bryan.eventos.repository.ParticipanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ParticipanteDAOImpl implements IParticipanteDAO {
    //INYECCION
    @Autowired
    private ParticipanteRepository participanteRepository;

    @Override
    public List<Participante> findAll() {
        return (List<Participante>) participanteRepository.findAll();
    }

    @Override
    public Optional<Participante> findById(Long id) {
        return participanteRepository.findById(id);
    }

    @Override
    public void save(Participante participante) {
        participanteRepository.save(participante);
    }

    @Override
    public void deleteById(Long id) {
        participanteRepository.deleteById(id);
    }
}
