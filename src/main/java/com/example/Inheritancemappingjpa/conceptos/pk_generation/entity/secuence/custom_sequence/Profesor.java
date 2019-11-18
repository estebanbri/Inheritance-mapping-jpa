package com.example.Inheritancemappingjpa.conceptos.pk_generation.entity.secuence.custom_sequence;

import javax.persistence.*;
import java.io.Serializable;

//@Entity
public class Profesor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "profesor_gen")
    @SequenceGenerator(name = "profesor_gen", sequenceName = "profesor_seq", allocationSize = 10)
    private Long id;

    // PASO 1: CREA UNA LA SECUENCIA "profesor_seq":
    // create sequence profesor_seq start with 1 increment by 10

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
