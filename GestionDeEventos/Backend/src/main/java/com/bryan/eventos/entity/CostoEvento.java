package com.bryan.eventos.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class CostoEvento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_costo")
    private Long id;
    private String descripcion;
    private Double precio;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "facturacion_id")
    @JsonIgnore
    private Facturacion facturacion;
}
