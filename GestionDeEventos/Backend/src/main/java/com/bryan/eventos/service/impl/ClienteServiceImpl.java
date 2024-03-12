package com.bryan.eventos.service.impl;

import com.bryan.eventos.entity.Cliente;
import com.bryan.eventos.persistence.IClienteDAO;
import com.bryan.eventos.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements IClienteService {
    //inyeccion
    @Autowired
    private IClienteDAO clienteDAO;
    @Override
    public List<Cliente> findAll() {
        return clienteDAO.findAll();
    }

    @Override
    public Optional<Cliente> findById(Long id) {
        return clienteDAO.findById(id);
    }

    @Override
    public void save(Cliente cliente) {
        clienteDAO.save(cliente);
    }

    @Override
    public void deleteById(Long id) {
        clienteDAO.deleteById(id);
    }
}
