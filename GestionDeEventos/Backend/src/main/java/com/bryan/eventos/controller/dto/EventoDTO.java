package com.bryan.eventos.controller.dto;

import com.bryan.eventos.entity.Participante;
import com.bryan.eventos.entity.Repositorio;
import com.bryan.eventos.entity.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EventoDTO {
    private Long id;
    private String titulo;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private LocalDateTime horaInicio;
    private LocalDateTime horaFin;
    private String descripcion;
    private String poster;
    private Usuario usuario;
    //private List<Participante> participantes;
    private Repositorio repositorio;
}
