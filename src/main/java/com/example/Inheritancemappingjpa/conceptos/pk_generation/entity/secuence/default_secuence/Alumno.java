package com.example.Inheritancemappingjpa.conceptos.pk_generation.entity.secuence.default_secuence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

//@Entity
public class Alumno implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    // PASO 1: CREA UNA UNICA SECUENCIA (llamada "HIBERNATE_SECUENCE") POR DEFECTO que sera compartida por todas las entidades:
    // create sequence hibernate_sequence start with 1 increment by 1

    // PASO 2: CREA LA TABLA
    //   create table alumno (
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
