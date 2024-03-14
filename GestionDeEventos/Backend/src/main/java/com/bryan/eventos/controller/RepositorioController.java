package com.bryan.eventos.controller;

import com.bryan.eventos.controller.dto.ParticipanteDTO;
import com.bryan.eventos.controller.dto.RepositorioDTO;
import com.bryan.eventos.entity.Participante;
import com.bryan.eventos.entity.Repositorio;
import com.bryan.eventos.service.IParticipanteService;
import com.bryan.eventos.service.IRepositorioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/repositorio")
public class RepositorioController {
    @Autowired
    private IRepositorioService repositorioService;

    private final ModelMapper modelMapper = new ModelMapper();

    //encontrar un repositorio segun su id
    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<Repositorio> repositorioOptional=repositorioService.findById(id);
        if(repositorioOptional.isPresent()){
            RepositorioDTO repositorioDTO=modelMapper.map(repositorioOptional.get(),RepositorioDTO.class);
            return ResponseEntity.ok(repositorioDTO);
        }
        return ResponseEntity.badRequest().body("El id colocado es incorrecto");
    }
    //listar repositorios
    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){
        List<RepositorioDTO> repositorioDTOList=repositorioService.findAll()
                .stream()
                .map(repositorio -> modelMapper.map(repositorio,RepositorioDTO.class))
                .toList();
        return ResponseEntity.ok(repositorioDTOList);
    }
    //agregar un nuevo repositorio
    @PostMapping("/save")
    public ResponseEntity<?> saveRepositorio(@RequestBody RepositorioDTO repositorioDTO) throws URISyntaxException {
        if(repositorioDTO.getDescripcion().isBlank()){
            return  ResponseEntity.badRequest().build();
        }
        Repositorio repositorio=modelMapper.map(repositorioDTO,Repositorio.class);
        repositorioService.save(repositorio);
        return ResponseEntity.created(new URI("/api/v1/repositorio/save")).build();
    }
    //actualizar un repositorio
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateRepositorio(@PathVariable Long id,@RequestBody RepositorioDTO repositorioDTO){
        Optional<Repositorio> repositorioOptional=repositorioService.findById(id);
        if(repositorioOptional.isPresent()){
            Repositorio repositorio=repositorioOptional.get();
            repositorio.setVideo(repositorioDTO.getVideo());
            repositorio.setDescripcion(repositorioDTO.getDescripcion());
            repositorio.setArchivos(repositorioDTO.getArchivos());
            repositorio.setFecha(repositorioDTO.getFecha());
            repositorioService.save(repositorio);
            return ResponseEntity.ok("Actualizacion de repositorio exitoso");
        }
        return ResponseEntity.badRequest().body("El id colocado es incorrecto");
    }
    //eliminar un usuario
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteRepositorio(@PathVariable Long id){
        if(id!=null){
            repositorioService.deleteById(id);
            return ResponseEntity.ok("Registro eliminado exitosamente");
        }
        return ResponseEntity.badRequest().body("El id colocado es incorrecto");
    }
}
