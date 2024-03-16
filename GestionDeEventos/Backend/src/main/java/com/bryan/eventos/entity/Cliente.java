package com.bryan.eventos.entity;

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
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long id;
    private String nombre;
    private String telefono;
    @Column(unique = true)
    private String correo;
    private String direccion;
    // New constructor to handle ID deserialization from JSON
    public Cliente(int id) {
        this.id = (long) id; // Cast to Long for compatibility with the field type
    }
}
