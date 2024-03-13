package com.bryan.eventos.service;

import com.bryan.eventos.entity.Participante;

import java.util.List;
import java.util.Optional;

public interface IParticipanteService {
    List<Participante> findAll();
    Optional<Participante> findById(Long id);
    void save(Participante participante);
    void deleteById(Long id);
}
