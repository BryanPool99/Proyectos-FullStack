package com.bryan.eventos.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Repositorio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_repositorio")
    private Long id;
    private String video;
    private String descripcion;
    private String archivos;
    @Column(columnDefinition = "DATE")
    private LocalDate fecha;
    @OneToMany(mappedBy = "repositorio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Evento> eventos;
}
