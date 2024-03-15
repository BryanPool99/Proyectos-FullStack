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
    @JsonIgnore
    private List<Evento> eventos;
    // New constructor to handle ID deserialization from JSON
    public Repositorio(int id) {
        this.id = (long) id; // Cast to Long for compatibility with the field type
    }
}
