package com.example.Inheritancemappingjpa.conceptos.relationship_mappings._1_one_to_one.A_unidireccional;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

//@Entity
public class Notebook1Uni implements Serializable {

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
