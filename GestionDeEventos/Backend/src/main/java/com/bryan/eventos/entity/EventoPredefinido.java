package com.bryan.eventos.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class EventoPredefinido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_predefinido")
    private Long id;
    private String titulo;
    @Column(name = "hora_inicio",columnDefinition = "DATETIME")
    private LocalDateTime horaInicio;
    @Column(name = "hora_fin",columnDefinition = "DATETIME")
    private LocalDateTime horaFin;
    @Column(name = "color_texto")
    private String colorTexto;
    @Column(name = "color_fondo")
    private String colorFondo;
    @ManyToOne(targetEntity = Usuario.class)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    // New constructor to handle ID deserialization from JSON
    public EventoPredefinido(int id) {
        this.id = (long) id; // Cast to Long for compatibility with the field type
    }
}
