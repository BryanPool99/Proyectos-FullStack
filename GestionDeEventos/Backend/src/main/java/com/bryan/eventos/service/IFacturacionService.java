package com.bryan.eventos.service;

import com.bryan.eventos.entity.Facturacion;

import java.util.List;
import java.util.Optional;

public interface IFacturacionService {
    List<Facturacion> findAll();
    Optional<Facturacion> findById(Long id);
    void save(Facturacion facturacion);
    void deleteById(Long id);
}
