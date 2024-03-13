package com.bryan.eventos.controller.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ParticipanteDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private String dni;
    private String correo;
    private String telefono;
    //private List<Evento> eventos;
}
