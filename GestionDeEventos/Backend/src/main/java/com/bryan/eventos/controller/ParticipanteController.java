package com.bryan.eventos.controller;

import com.bryan.eventos.controller.dto.ParticipanteDTO;
import com.bryan.eventos.controller.dto.UsuarioDTO;
import com.bryan.eventos.entity.Participante;
import com.bryan.eventos.entity.Usuario;
import com.bryan.eventos.service.IParticipanteService;
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
@RequestMapping("/api/v1/participante")
public class ParticipanteController {
    @Autowired
    private IParticipanteService participanteService;

    private final ModelMapper modelMapper = new ModelMapper();

    //encontrar un usuario segun su id
    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<Participante> participanteOptional=participanteService.findById(id);
        if(participanteOptional.isPresent()){
            ParticipanteDTO participanteDTO=modelMapper.map(participanteOptional.get(),ParticipanteDTO.class);
            return ResponseEntity.ok(participanteDTO);
        }
        return ResponseEntity.badRequest().body("El id colocado es incorrecto");
    }
    //listar usuarios
    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){
        List<ParticipanteDTO> participanteDTOList=participanteService.findAll()
                .stream()
                .map(participante -> modelMapper.map(participante,ParticipanteDTO.class))
                .toList();
        return ResponseEntity.ok(participanteDTOList);
    }
    //agregar un nuevo usuario
    @PostMapping("/save")
    public ResponseEntity<?> saveParticipante(@RequestBody ParticipanteDTO participanteDTO) throws URISyntaxException {
        if(participanteDTO.getNombre().isBlank()){
            return  ResponseEntity.badRequest().build();
        }
        Participante participante=modelMapper.map(participanteDTO,Participante.class);
        participanteService.save(participante);
        return ResponseEntity.created(new URI("/api/v1/participante/save")).build();
    }
    //actualizar un usuario
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateParticipante(@PathVariable Long id,@RequestBody ParticipanteDTO participanteDTO){
        Optional<Participante> participanteOptional=participanteService.findById(id);
        if(participanteOptional.isPresent()){
            Participante participante=participanteOptional.get();
            participante.setNombre(participanteDTO.getNombre());
            participante.setApellido(participanteDTO.getApellido());
            participante.setDni(participanteDTO.getDni());
            participante.setCorreo(participanteDTO.getCorreo());
            participante.setTelefono(participanteDTO.getTelefono());
            participanteService.save(participante);
            return ResponseEntity.ok("Actualizacion de usuario exitoso");
        }
        return ResponseEntity.badRequest().body("El id colocado es incorrecto");
    }
    //eliminar un usuario
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePaticipante(@PathVariable Long id){
        if(id!=null){
            participanteService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.badRequest().body("El id colocado es incorrecto");
    }
}
