package com.bryan.eventos.controller;

import com.bryan.eventos.controller.dto.ClienteDTO;
import com.bryan.eventos.controller.dto.EventoDTO;
import com.bryan.eventos.entity.Cliente;
import com.bryan.eventos.entity.Evento;
import com.bryan.eventos.service.IClienteService;
import com.bryan.eventos.service.IEventoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/evento")
public class EventoController {
    @Autowired
    private IEventoService eventoService;
    private final ModelMapper modelMapper = new ModelMapper();
    //encontrar un evento segun su id
    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<Evento> eventoOptional=eventoService.findById(id);
        if(eventoOptional.isPresent()){
            EventoDTO eventoDTO=modelMapper.map(eventoOptional.get(),EventoDTO.class);
            return ResponseEntity.ok(eventoDTO);
        }
        return ResponseEntity.badRequest().body("El id colocado es incorrecto");
    }
    //listar todos los eventos
    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){
        List<EventoDTO> eventoDTOList=eventoService.findAll()
                .stream()
                .map(evento -> modelMapper.map(evento,EventoDTO.class))
                .toList();
        return ResponseEntity.ok(eventoDTOList);
    }
    //registro de un nuevo evento
    @PostMapping("/save")
    public ResponseEntity<?> saveEvento(@RequestBody EventoDTO eventoDTO) throws URISyntaxException {
        if(eventoDTO.getTitulo().isBlank()){
            return  ResponseEntity.badRequest().build();
        }
        Evento evento=modelMapper.map(eventoDTO,Evento.class);
        eventoService.save(evento);
        return ResponseEntity.created(new URI("/api/v1/evento/save")).build();
    }
    //actualizar un evento
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateEvento(@PathVariable Long id,@RequestBody EventoDTO eventoDTO){
        Optional<Evento> eventoOptional=eventoService.findById(id);
        if(eventoOptional.isPresent()){
            Evento evento=eventoOptional.get();
            evento.setTitulo(eventoDTO.getTitulo());
            evento.setFechaInicio(eventoDTO.getFechaInicio());
            evento.setFechaFin(eventoDTO.getFechaFin());
            evento.setHoraInicio(eventoDTO.getHoraInicio());
            evento.setHoraFin(eventoDTO.getHoraFin());
            evento.setDescripcion(eventoDTO.getDescripcion());
            evento.setPoster(eventoDTO.getPoster());
            evento.setUsuario(eventoDTO.getUsuario());
            //evento.setParticipantes(eventoDTO.getParticipantes());
            evento.setRepositorio(eventoDTO.getRepositorio());
            eventoService.save(evento);
            return ResponseEntity.ok("Actualizacion de evento exitoso");
        }
        return ResponseEntity.badRequest().body("El id colocado es incorrecto");
    }
    //eliminar un evento
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEvento(@PathVariable Long id){
        if(id!=null){
            eventoService.deleteById(id);
            return ResponseEntity.ok("Registro eliminado exitosamente");
        }
        return ResponseEntity.badRequest().body("El id colocado es incorrecto");
    }
}
