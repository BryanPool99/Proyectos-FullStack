package com.bryan.eventos.controller;

import com.bryan.eventos.controller.dto.ClienteDTO;
import com.bryan.eventos.controller.dto.CostoEventoDTO;
import com.bryan.eventos.entity.Cliente;
import com.bryan.eventos.entity.CostoEvento;
import com.bryan.eventos.service.IClienteService;
import com.bryan.eventos.service.ICostoEventoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/costo")
public class CostoEventoController {
    @Autowired
    private ICostoEventoService costoEventoService;

    private final ModelMapper modelMapper = new ModelMapper();

    //encontrar un costo de evento segun su id
    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<CostoEvento> costoEventoOptional=costoEventoService.findById(id);
        if(costoEventoOptional.isPresent()){
            CostoEventoDTO costoEventoDTO=modelMapper.map(costoEventoOptional.get(),CostoEventoDTO.class);
            return ResponseEntity.ok(costoEventoDTO);
        }
        return ResponseEntity.badRequest().body("El id colocado es incorrecto");
    }
    //listar todos los costos de evento
    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){
        List<CostoEventoDTO> costoEventoDTOList=costoEventoService.findAll()
                .stream()
                .map(costoEvento -> modelMapper.map(costoEvento,CostoEventoDTO.class))
                .toList();
        return ResponseEntity.ok(costoEventoDTOList);
    }
    //registro de un nuevo costo de evento
    @PostMapping("/save")
    public ResponseEntity<?> saveCostoEvento(@RequestBody CostoEventoDTO costoEventoDTO) throws URISyntaxException {
        if(costoEventoDTO.getDescripcion().isBlank()){
            return  ResponseEntity.badRequest().build();
        }
        CostoEvento costoEvento=modelMapper.map(costoEventoDTO,CostoEvento.class);
        costoEventoService.save(costoEvento);
        return ResponseEntity.created(new URI("/api/v1/costo/save")).build();
    }
    //actualizar un costo de evento
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCostoEvento(@PathVariable Long id,@RequestBody CostoEventoDTO costoEventoDTO){
        Optional<CostoEvento> costoEventoOptional=costoEventoService.findById(id);
        if(costoEventoOptional.isPresent()){
            CostoEvento costoEvento=costoEventoOptional.get();
            costoEvento.setDescripcion(costoEventoDTO.getDescripcion());
            costoEvento.setPrecio(costoEventoDTO.getPrecio());
            costoEventoService.save(costoEvento);
            return ResponseEntity.ok("Actualizacion de costo del evento exitoso");
        }
        return ResponseEntity.badRequest().body("El id colocado es incorrecto");
    }
    //eliminar un costo de evento
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCostoEvento(@PathVariable Long id){
        if(id!=null){
            costoEventoService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.badRequest().body("El id colocado es incorrecto");
    }
}
