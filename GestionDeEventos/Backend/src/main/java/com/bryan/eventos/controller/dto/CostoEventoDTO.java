package com.bryan.eventos.controller.dto;

import com.bryan.eventos.entity.Facturacion;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CostoEventoDTO {
    private Long id;
    private String descripcion;
    private Double precio;
}
