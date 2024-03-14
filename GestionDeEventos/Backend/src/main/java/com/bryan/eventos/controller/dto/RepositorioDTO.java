package com.bryan.eventos.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RepositorioDTO {
    private Long id;
    private String video;
    private String descripcion;
    private String archivos;
    private LocalDate fecha;
    //private List<Evento> eventos;
}
