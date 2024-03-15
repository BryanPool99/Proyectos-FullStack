package com.bryan.eventos.entity;

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
@Entity
@Builder
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_evento")
    private Long id;
    private String titulo;
    @Column(name = "fecha_inicio",columnDefinition = "DATE")
    private LocalDate fechaInicio;
    @Column(name = "fecha_fin",columnDefinition = "DATE")
    private LocalDate fechaFin;
    @Column(name = "hora_inicio",columnDefinition = "DATETIME")
    private LocalDateTime horaInicio;
    @Column(name = "hora_fin",columnDefinition = "DATETIME")
    private LocalDateTime horaFin;
    private String descripcion;
    private String poster;
    @ManyToOne(targetEntity = Usuario.class, fetch = FetchType.EAGER)
    @JsonIgnore
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    @ManyToMany(targetEntity = Participante.class, fetch = FetchType.LAZY)
    @JoinTable(name = "detalle_participante",
            joinColumns = @JoinColumn(name = "id_evento"),
            inverseJoinColumns = @JoinColumn(name = "id_participante"))
    @JsonIgnore
    private List<Participante> participantes;
    @ManyToOne(targetEntity = Repositorio.class, fetch = FetchType.EAGER)
    @JsonIgnore
    @JoinColumn(name = "id_repositorio")
    private Repositorio repositorio;

}
