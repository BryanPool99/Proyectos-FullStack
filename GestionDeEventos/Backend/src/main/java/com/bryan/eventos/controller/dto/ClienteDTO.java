package com.bryan.eventos.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClienteDTO {
    private Long id;
    private String nombre;
    private String telefono;
    private String correo;
    private String direccion;
}
