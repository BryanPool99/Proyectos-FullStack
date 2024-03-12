package com.bryan.eventos.persistence.impl;

import com.bryan.eventos.entity.Cliente;
import com.bryan.eventos.entity.CostoEvento;
import com.bryan.eventos.persistence.ICostoEventoDAO;
import com.bryan.eventos.repository.ClienteRepository;
import com.bryan.eventos.repository.CostoEventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CostoEventoDAOImpl implements ICostoEventoDAO {
    //INYECCION
    @Autowired
    private CostoEventoRepository costoEventoRepository;
    @Override
    public List<CostoEvento> findAll() {
        return (List<CostoEvento>) costoEventoRepository.findAll();
    }

    @Override
    public Optional<CostoEvento> findById(Long id) {
        return costoEventoRepository.findById(id);
    }

    @Override
    public void save(CostoEvento costoEvento) {
        costoEventoRepository.save(costoEvento);
    }

    @Override
    public void deleteById(Long id) {
        costoEventoRepository.deleteById(id);
    }
}
