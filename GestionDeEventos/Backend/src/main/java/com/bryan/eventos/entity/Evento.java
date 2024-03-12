package com.bryan.eventos.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    @Column(name = "fecha_inicio",columnDefinition = "DATETIME")
    private LocalDateTime fechaInicio;
    @Column(name = "fecha_fin",columnDefinition = "DATETIME")
    private LocalDateTime fechaFin;
    @Column(name = "hora_inicio",columnDefinition = "DATETIME")
    private LocalDateTime horaInicio;
    @Column(name = "hora_fin",columnDefinition = "DATETIME")
    private LocalDateTime horaFin;
    private String descripcion;
    private String poster;
    @ManyToOne(targetEntity = Usuario.class, fetch = FetchType.EAGER)
    @JsonIgnore
    private Usuario usuario;
    @ManyToMany(targetEntity = Participante.class, fetch = FetchType.LAZY)
    @JoinTable(name = "detalle_participante",
            joinColumns = @JoinColumn(name = "evento_id"),
            inverseJoinColumns = @JoinColumn(name = "participante_id"))
    @JsonIgnore
    private List<Participante> participantes;
    @OneToMany(targetEntity = Repositorio.class, fetch = FetchType.LAZY, mappedBy = "evento")
    @JsonIgnore
    private List<Repositorio> repositorios;

}
