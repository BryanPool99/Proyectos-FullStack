package com.bryan.eventos.controller.dto;

import com.bryan.eventos.entity.Cliente;
import com.bryan.eventos.entity.CostoEvento;
import com.bryan.eventos.entity.Evento;
import com.bryan.eventos.entity.EventoPredefinido;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FacturacionDTO {
    private Long id;
    private LocalDate fecha;
    private Cliente cliente;
    private CostoEvento costoEvento;
    private Evento evento;
    private EventoPredefinido eventoPredefinido;
}
