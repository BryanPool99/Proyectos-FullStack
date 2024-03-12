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
    @Column(name = "id_facturacion")
    private Long id;
    @Column(columnDefinition = "DATETIME")
    private LocalDateTime fecha;
    @ManyToOne(targetEntity = Cliente.class, fetch = FetchType.EAGER)
    @JsonIgnore
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "id_costo")
    private CostoEvento costoEvento;
    @OneToOne(targetEntity = Evento.class,cascade = CascadeType.PERSIST)
    @JsonIgnore
    @JoinColumn(name = "id_evento")
    private  Evento evento;
    @OneToOne(targetEntity = EventoPredefinido.class,cascade = CascadeType.PERSIST)
    @JsonIgnore
    @JoinColumn(name = "id_predefinido")
    private  EventoPredefinido eventoPredefinido;
}
