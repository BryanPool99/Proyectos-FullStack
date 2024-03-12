package com.bryan.eventos.service.impl;

import com.bryan.eventos.entity.CostoEvento;
import com.bryan.eventos.persistence.ICostoEventoDAO;
import com.bryan.eventos.service.ICostoEventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CostoEventoServiceImpl implements ICostoEventoService {
    //INTECCION
    @Autowired
    private ICostoEventoDAO costoEventoDAO;
    @Override
    public List<CostoEvento> findAll() {
        return costoEventoDAO.findAll();
    }

    @Override
    public Optional<CostoEvento> findById(Long id) {
        return costoEventoDAO.findById(id);
    }

    @Override
    public void save(CostoEvento costoEvento) {
        costoEventoDAO.save(costoEvento);
    }

    @Override
    public void deleteById(Long id) {
        costoEventoDAO.deleteById(id);
    }
}
