package com.bryan.eventos.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
    @OneToMany(mappedBy = "costoEvento", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Facturacion> facturaciones;
    // New constructor to handle ID deserialization from JSON
    public CostoEvento(int id) {
        this.id = (long) id; // Cast to Long for compatibility with the field type
    }
}
