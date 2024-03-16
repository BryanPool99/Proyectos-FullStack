package com.bryan.eventos.controller;

import com.bryan.eventos.controller.dto.FacturacionDTO;
import com.bryan.eventos.controller.dto.ParticipanteDTO;
import com.bryan.eventos.entity.Facturacion;
import com.bryan.eventos.entity.Participante;
import com.bryan.eventos.service.IFacturacionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/facturacion")
public class FacturacionController {
    //INYECCION
    @Autowired
    private IFacturacionService facturacionService;
    private final ModelMapper modelMapper = new ModelMapper();
    //encontrar una facturacion segun su id
    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<Facturacion> facturacionOptional=facturacionService.findById(id);
        if(facturacionOptional.isPresent()){
            FacturacionDTO facturacionDTO=modelMapper.map(facturacionOptional.get(),FacturacionDTO.class);
            return ResponseEntity.ok(facturacionDTO);
        }
        return ResponseEntity.badRequest().body("El id colocado es incorrecto");
    }
    //listar facturaciones
    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){
        List<FacturacionDTO> facturacionDTOList=facturacionService.findAll()
                .stream()
                .map(facturacion -> modelMapper.map(facturacion,FacturacionDTO.class))
                .toList();
        return ResponseEntity.ok(facturacionDTOList);
    }
    //agregar una nueva facturacion
    @PostMapping("/save")
    public ResponseEntity<?> saveFacturacion(@RequestBody FacturacionDTO facturacionDTO) throws URISyntaxException {
        if(facturacionDTO.getEvento().equals(null)){
            return  ResponseEntity.badRequest().build();
        }
        Facturacion facturacion=modelMapper.map(facturacionDTO,Facturacion.class);
        facturacionService.save(facturacion);
        return ResponseEntity.created(new URI("/api/v1/facturacion/save")).build();
    }
    //actualizar una facturacion
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateFacturacion(@PathVariable Long id,@RequestBody FacturacionDTO facturacionDTO){
        Optional<Facturacion> facturacionOptional=facturacionService.findById(id);
        if(facturacionOptional.isPresent()){
            Facturacion facturacion=facturacionOptional.get();
            facturacion.setFecha(facturacionDTO.getFecha());
            facturacion.setCliente(facturacionDTO.getCliente());
            facturacion.setCostoEvento(facturacionDTO.getCostoEvento());
            facturacion.setEvento(facturacionDTO.getEvento());
            facturacion.setEventoPredefinido(facturacionDTO.getEventoPredefinido());
            facturacionService.save(facturacion);
            return ResponseEntity.ok("Actualizacion de facturacion exitoso");
        }
        return ResponseEntity.badRequest().body("El id colocado es incorrecto");
    }
    //eliminar una facturacion
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteFacturacion(@PathVariable Long id){
        if(id!=null){
            facturacionService.deleteById(id);
            return ResponseEntity.ok("Registro eliminado exitosamente");
        }
        return ResponseEntity.badRequest().body("El id colocado es incorrecto");
    }
}
