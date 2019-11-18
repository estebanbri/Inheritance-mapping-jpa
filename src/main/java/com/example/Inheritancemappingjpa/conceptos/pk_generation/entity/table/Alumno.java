package com.example.Inheritancemappingjpa.conceptos.pk_generation.entity.table;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Alumno implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "hibernate_seq")
    @TableGenerator(name = "hibernate_seq",  initialValue = 0, allocationSize = 1)
    private Long id;

    // PASO 1: CREA LA TABLA "hibernate_seq" que la vamos a compartir por todas las entitys
    //  create table hibernate_seq (
    //       sequence_name varchar(255) not null,
    //        next_val bigint,
    //        primary key (sequence_name)
    //    )

    // Paso 2:
    // insert into hibernate_seq(sequence_name, next_val) values ('alumno',0)

    // create table alumno (
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
