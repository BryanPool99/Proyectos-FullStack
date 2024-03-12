package com.bryan.eventos.persistence.impl;

import com.bryan.eventos.entity.Cliente;
import com.bryan.eventos.persistence.IClienteDAO;
import com.bryan.eventos.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ClienteDAOImpl implements IClienteDAO {
    //inyeccion
    @Autowired
    private ClienteRepository clienteRepository;
    @Override
    public List<Cliente> findAll() {
        return (List<Cliente>) clienteRepository.findAll();
    }

    @Override
    public Optional<Cliente> findById(Long id) {
        return clienteRepository.findById(id);
    }

    @Override
    public void save(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    @Override
    public void deleteById(Long id) {
        clienteRepository.deleteById(id);
    }
}
