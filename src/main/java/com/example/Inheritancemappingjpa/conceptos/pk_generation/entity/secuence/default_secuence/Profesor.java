package com.example.Inheritancemappingjpa.conceptos.pk_generation.entity.secuence.default_secuence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

//@Entity
public class Profesor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    // PASO 1: Usa la secuencia creada por hibernate llamada "HIBERNATE_SECUENCE" que es compartida por todas las entidades

    // PASO 2: CREA LA TABLA
    //    create table profesor (
    //       id bigint not null,
    //        nombre varchar(255),
    //        primary key (id)
    //    )

    private String nombre;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Alumno1{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
