package com.bryan.eventos.repository;

import com.bryan.eventos.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente,Long> {
}
