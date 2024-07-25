package com.cocot3ro.gestionhotel.core.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AlmacenEntity {

    @Id
    @GeneratedValue
    public Long id;
    public String nombre;
    public Integer cantidad;
    public Integer minimo;
    public Integer pack;

    public AlmacenEntity(String nombre, Integer cantidad, Integer minimo, Integer pack) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.minimo = minimo;
        this.pack = pack;
    }
}