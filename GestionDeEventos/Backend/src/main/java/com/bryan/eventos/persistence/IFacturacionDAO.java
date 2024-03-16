package com.bryan.eventos.persistence;

import com.bryan.eventos.entity.Facturacion;

import java.util.List;
import java.util.Optional;

public interface IFacturacionDAO {
    List<Facturacion> findAll();
    Optional<Facturacion> findById(Long id);
    void save(Facturacion facturacion);
    void deleteById(Long id);
}
