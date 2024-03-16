package com.bryan.eventos.persistence.impl;

import com.bryan.eventos.entity.Facturacion;
import com.bryan.eventos.persistence.IFacturacionDAO;
import com.bryan.eventos.repository.FacturacionRepository;
import com.bryan.eventos.service.IRepositorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class FacturacionDAOImpl implements IFacturacionDAO {
    //INYECCION
    @Autowired
    private FacturacionRepository facturacionRepository;
    @Override
    public List<Facturacion> findAll() {
        return (List<Facturacion>) facturacionRepository.findAll();
    }

    @Override
    public Optional<Facturacion> findById(Long id) {
        return facturacionRepository.findById(id);
    }

    @Override
    public void save(Facturacion facturacion) {
        facturacionRepository.save(facturacion);
    }

    @Override
    public void deleteById(Long id) {
        facturacionRepository.deleteById(id);
    }
}
