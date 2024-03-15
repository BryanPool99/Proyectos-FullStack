package com.bryan.eventos.controller.dto;

import com.bryan.eventos.entity.Usuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EventoPredefinidoDTO {
    private Long id;
    private String titulo;
    private LocalDateTime horaInicio;
    private LocalDateTime horaFin;
    private String colorTexto;
    private String colorFondo;
    private Usuario usuario;
}
