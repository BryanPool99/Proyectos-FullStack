package com.bryan.eventos.controller;

import com.bryan.eventos.controller.dto.EventoPredefinidoDTO;
import com.bryan.eventos.entity.EventoPredefinido;
import com.bryan.eventos.service.IEventoPredefinidoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/eventoPredefinido")
public class EventoPredefinidoController {
    @Autowired
    private IEventoPredefinidoService eventoPredefinidoService;

    private final ModelMapper modelMapper = new ModelMapper();

    //encontrar un evento predefinido segun su id
    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<EventoPredefinido> eventoPredefinidoOptional=eventoPredefinidoService.findById(id);
        if(eventoPredefinidoOptional.isPresent()){
            EventoPredefinidoDTO eventoPredefinidoDTO=modelMapper.map(eventoPredefinidoOptional.get(),EventoPredefinidoDTO.class);
            return ResponseEntity.ok(eventoPredefinidoDTO);
        }
        return ResponseEntity.badRequest().body("El id colocado es incorrecto");
    }
    //listar eventos predefinidos
    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){
        List<EventoPredefinidoDTO> eventoPredefinidoDTOList=eventoPredefinidoService.findAll()
                .stream()
                .map(eventoPredefinido -> modelMapper.map(eventoPredefinido,EventoPredefinidoDTO.class))
                .toList();
        return ResponseEntity.ok(eventoPredefinidoDTOList);
    }
    //agregar un nuevo evento predefinido
    @PostMapping("/save")
    public ResponseEntity<?> saveEventoPredefinido(@RequestBody EventoPredefinidoDTO eventoPredefinidoDTO) throws URISyntaxException {
        if(eventoPredefinidoDTO.getTitulo().isBlank()){
            return  ResponseEntity.badRequest().build();
        }
        EventoPredefinido eventoPredefinido=modelMapper.map(eventoPredefinidoDTO,EventoPredefinido.class);
        eventoPredefinidoService.save(eventoPredefinido);
        return ResponseEntity.created(new URI("/api/v1/eventoPredefinido/save")).build();
    }
    //actualizar un evento predefinido
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateEventoPredefinido(@PathVariable Long id,@RequestBody EventoPredefinidoDTO eventoPredefinidoDTO){
        Optional<EventoPredefinido> eventoPredefinidoOptional=eventoPredefinidoService.findById(id);
        if(eventoPredefinidoOptional.isPresent()){
            EventoPredefinido eventoPredefinido=eventoPredefinidoOptional.get();
            eventoPredefinido.setTitulo(eventoPredefinidoDTO.getTitulo());
            eventoPredefinido.setHoraInicio(eventoPredefinidoDTO.getHoraInicio());
            eventoPredefinido.setHoraFin(eventoPredefinidoDTO.getHoraFin());
            eventoPredefinido.setColorTexto(eventoPredefinidoDTO.getColorTexto());
            eventoPredefinido.setColorFondo(eventoPredefinidoDTO.getColorFondo());
            eventoPredefinido.setUsuario(eventoPredefinidoDTO.getUsuario());
            eventoPredefinidoService.save(eventoPredefinido);
            return ResponseEntity.ok("Actualizacion de evento predefinido exitoso");
        }
        return ResponseEntity.badRequest().body("El id colocado es incorrecto");
    }
    //eliminar un evento predefinido
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEventoPredefinido(@PathVariable Long id){
        if(id!=null){
            eventoPredefinidoService.deleteById(id);
            return ResponseEntity.ok("Registro eliminado exitosamente");
        }
        return ResponseEntity.badRequest().body("El id colocado es incorrecto");
    }
}
