package com.bryan.eventos.service.impl;

import com.bryan.eventos.entity.Participante;
import com.bryan.eventos.persistence.IParticipanteDAO;
import com.bryan.eventos.service.IParticipanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParticipanteServiceImpl implements IParticipanteService {
    //INYECCION
    @Autowired
    private IParticipanteDAO participanteDAO;
    @Override
    public List<Participante> findAll() {
        return participanteDAO.findAll();
    }

    @Override
    public Optional<Participante> findById(Long id) {
        return participanteDAO.findById(id);
    }

    @Override
    public void save(Participante participante) {
        participanteDAO.save(participante);
    }

    @Override
    public void deleteById(Long id) {
        participanteDAO.deleteById(id);
    }
}
