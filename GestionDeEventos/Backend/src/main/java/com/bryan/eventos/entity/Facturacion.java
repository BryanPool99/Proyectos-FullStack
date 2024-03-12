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
public class Facturacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "DATETIME")
    private LocalDateTime fecha;
    @ManyToOne(targetEntity = Cliente.class, fetch = FetchType.EAGER)
    @JsonIgnore
    private Cliente cliente;
    @OneToMany(targetEntity = CostoEvento.class, fetch = FetchType.LAZY,mappedBy = "facturacion")
    private List<CostoEvento> costoEventos;
    @OneToOne(targetEntity = Evento.class,cascade = CascadeType.PERSIST)
    @JsonIgnore
    private  Evento evento;
    @OneToOne(targetEntity = EventoPredefinido.class,cascade = CascadeType.PERSIST)
    @JsonIgnore
    private  EventoPredefinido eventoPredefinido;
}
