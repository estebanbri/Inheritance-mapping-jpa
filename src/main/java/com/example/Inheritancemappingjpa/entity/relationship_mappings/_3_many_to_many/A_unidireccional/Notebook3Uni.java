package com.example.Inheritancemappingjpa.entity.relationship_mappings._3_many_to_many.A_unidireccional;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Notebook3Uni {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

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
        return "Notebook1{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
