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
public class Participante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_participante")
    private Long id;
    private String nombre;
    private String apellido;
    private String dni;
    private String correo;
    private String telefono;
    @ManyToMany(targetEntity = Evento.class, fetch = FetchType.LAZY)
    @JoinTable(name = "detalle_participante",
            joinColumns = @JoinColumn(name = "id_participante"),
            inverseJoinColumns = @JoinColumn(name = "id_evento"))
    @JsonIgnore
    private List<Evento> eventos;
    // New constructor to handle ID deserialization from JSON
    public Participante(int id) {
        this.id = (long) id; // Cast to Long for compatibility with the field type
    }
}
