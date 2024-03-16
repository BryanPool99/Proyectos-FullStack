package com.bryan.eventos.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

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
    @Column(columnDefinition = "DATE")
    private LocalDate fecha;
    @ManyToOne(targetEntity = Cliente.class, fetch = FetchType.EAGER)
    @JsonIgnore
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "id_costo")
    private CostoEvento costoEvento;
    @OneToOne(targetEntity = Evento.class)
    @JsonIgnore
    @JoinColumn(name = "id_evento")
    private  Evento evento;
    @OneToOne(targetEntity = EventoPredefinido.class)
    @JsonIgnore
    @JoinColumn(name = "id_predefinido")
    private  EventoPredefinido eventoPredefinido;
    // New constructor to handle ID deserialization from JSON
    public Facturacion(int id) {
        this.id = (long) id; // Cast to Long for compatibility with the field type
    }
}
