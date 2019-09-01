package com.example.Inheritancemappingjpa.entity.relationship_mappings._2_one_to_many.A_unidireccional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

//@Entity
public class Notebook2Uni implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;

    public Notebook2Uni() {
    }

    public Notebook2Uni(String nombre) {
        this.nombre = nombre;
    }

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
