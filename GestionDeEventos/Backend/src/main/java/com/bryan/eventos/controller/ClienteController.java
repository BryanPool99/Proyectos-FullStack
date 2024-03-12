package com.bryan.eventos.controller;

import com.bryan.eventos.controller.dto.ClienteDTO;
import com.bryan.eventos.entity.Cliente;
import com.bryan.eventos.service.IClienteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/cliente")
public class ClienteController {
    @Autowired
    private IClienteService clienteService;

    private final ModelMapper modelMapper = new ModelMapper();
    //encontrar un cliente segun su id
    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<Cliente> clienteOptional=clienteService.findById(id);
        if(clienteOptional.isPresent()){
            ClienteDTO clienteDTO=modelMapper.map(clienteOptional.get(),ClienteDTO.class);
            return ResponseEntity.ok(clienteDTO);
        }
        return ResponseEntity.badRequest().body("El id colocado es incorrecto");
    }
    //listar todos los clientes
    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){
        List<ClienteDTO> clienteDTOList=clienteService.findAll()
                .stream()
                .map(cliente -> modelMapper.map(cliente,ClienteDTO.class))
                .toList();
        return ResponseEntity.ok(clienteDTOList);
    }
    //registro de un nuevo cliente
    @PostMapping("/save")
    public ResponseEntity<?> saveCliente(@RequestBody ClienteDTO clienteDTO) throws URISyntaxException{
        if(clienteDTO.getNombre().isBlank()){
            return  ResponseEntity.badRequest().build();
        }
        Cliente cliente=modelMapper.map(clienteDTO,Cliente.class);
        clienteService.save(cliente);
        return ResponseEntity.created(new URI("/api/v1/cliente/save")).build();
    }
    //actualizar un cliente
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCliente(@PathVariable Long id,@RequestBody ClienteDTO clienteDTO){
        Optional<Cliente> clienteOptional=clienteService.findById(id);
        if(clienteOptional.isPresent()){
            Cliente cliente=clienteOptional.get();
            cliente.setNombre(clienteDTO.getNombre());
            cliente.setCorreo(clienteDTO.getCorreo());
            cliente.setTelefono(clienteDTO.getTelefono());
            cliente.setDireccion(clienteDTO.getDireccion());
            clienteService.save(cliente);
            return ResponseEntity.ok("Actualizacion de cliente exitoso");
        }
        return ResponseEntity.badRequest().body("El id colocado es incorrecto");
    }
    //eliminar un cliente
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCliente(@PathVariable Long id){
        if(id!=null){
            clienteService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.badRequest().body("El id colocado es incorrecto");
    }
}
