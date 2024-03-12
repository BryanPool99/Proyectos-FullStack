package com.bryan.eventos.persistence;

import com.bryan.eventos.entity.Cliente;
import com.bryan.eventos.entity.CostoEvento;

import java.util.List;
import java.util.Optional;

public interface ICostoEventoDAO {
    List<CostoEvento> findAll();
    Optional<CostoEvento> findById(Long id);
    void save(CostoEvento costoEvento);
    void deleteById(Long id);
}
