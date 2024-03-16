package com.bryan.eventos.service.impl;

import com.bryan.eventos.entity.Facturacion;
import com.bryan.eventos.persistence.IFacturacionDAO;
import com.bryan.eventos.service.IFacturacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacturacionServiceImpl implements IFacturacionService {
    //INYECCION
    @Autowired
    private IFacturacionDAO facturacionDAO;
    @Override
    public List<Facturacion> findAll() {
        return facturacionDAO.findAll();
    }

    @Override
    public Optional<Facturacion> findById(Long id) {
        return facturacionDAO.findById(id);
    }

    @Override
    public void save(Facturacion facturacion) {
        facturacionDAO.save(facturacion);
    }

    @Override
    public void deleteById(Long id) {
        facturacionDAO.deleteById(id);
    }
}
