package com.bryan.eventos.service;


import com.bryan.eventos.entity.Usuario;

import java.util.List;
import java.util.Optional;

public interface IUsuarioService {
    List<Usuario> findAll();
    Optional<Usuario> findById(Long id);
    void save(Usuario usuario);
    void deleteById(Long id);
}
