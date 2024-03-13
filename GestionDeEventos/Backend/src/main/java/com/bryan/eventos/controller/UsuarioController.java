package com.bryan.eventos.controller;

import com.bryan.eventos.controller.dto.UsuarioDTO;
import com.bryan.eventos.entity.Usuario;
import com.bryan.eventos.service.IUsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioController {
    @Autowired
    private IUsuarioService usuarioService;

    private final ModelMapper modelMapper = new ModelMapper();
    //encontrar un usuario segun su id
    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<Usuario> usuarioOptional=usuarioService.findById(id);
        if(usuarioOptional.isPresent()){
            UsuarioDTO usuarioDTO=modelMapper.map(usuarioOptional.get(),UsuarioDTO.class);
            return ResponseEntity.ok(usuarioDTO);
        }
        return ResponseEntity.badRequest().body("El id colocado es incorrecto");
    }
    //listar usuarios
    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){
        List<UsuarioDTO> usuarioDTOList=usuarioService.findAll()
                .stream()
                .map(usuario -> modelMapper.map(usuario,UsuarioDTO.class))
                .toList();
        return ResponseEntity.ok(usuarioDTOList);
    }
    //agregar un nuevo usuario
    @PostMapping("/save")
    public ResponseEntity<?> saveUsuario(@RequestBody UsuarioDTO usuarioDTO) throws URISyntaxException {
        if(usuarioDTO.getNombre().isBlank()){
            return  ResponseEntity.badRequest().build();
        }
        Usuario usuario=modelMapper.map(usuarioDTO,Usuario.class);
        usuarioService.save(usuario);
        return ResponseEntity.created(new URI("/api/v1/usuario/save")).build();
    }
    //actualizar un usuario
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateUsuario(@PathVariable Long id,@RequestBody UsuarioDTO usuarioDTO){
        Optional<Usuario> usuarioOptional=usuarioService.findById(id);
        if(usuarioOptional.isPresent()){
            Usuario usuario=usuarioOptional.get();
            usuario.setNombre(usuarioDTO.getNombre());
            usuario.setApellidos(usuarioDTO.getApellidos());
            usuario.setClave(usuarioDTO.getClave());
            usuarioService.save(usuario);
            return ResponseEntity.ok("Actualizacion de usuario exitoso");
        }
        return ResponseEntity.badRequest().body("El id colocado es incorrecto");
    }
    //eliminar un usuario
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUsuario(@PathVariable Long id){
        if(id!=null){
            usuarioService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.badRequest().body("El id colocado es incorrecto");
    }
}
