package com.example.Inheritancemappingjpa.conceptos.relationship_mappings._2_one_to_many.A_unidireccional;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//@Entity
public class Alumno2Uni implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name= "ALUMNO_ID")
    private List<Notebook2Uni> notebooks = new ArrayList<>();

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

    public List<Notebook2Uni> getNotebook() {
        return notebooks;
    }

    public void setNotebooks(List<Notebook2Uni> notebooks) {
        this.notebooks = notebooks;
    }

    @Override
    public String toString() {
        return "Alumno2Uni{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", notebooks=" + notebooks +
                '}';
    }
}
