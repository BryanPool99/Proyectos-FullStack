package com.bryan.eventos.repository;

import com.bryan.eventos.entity.Evento;
import org.springframework.data.repository.CrudRepository;

public interface EventoRepository extends CrudRepository<Evento,Long> {
}
