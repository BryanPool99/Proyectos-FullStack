package com.bryan.eventos.persistence;

import com.bryan.eventos.entity.Cliente;

import java.util.List;
import java.util.Optional;

public interface  IClienteDAO {
    List<Cliente> findAll();
    Optional<Cliente> findById(Long id);
    void save(Cliente cliente);
    void deleteById(Long id);
}
