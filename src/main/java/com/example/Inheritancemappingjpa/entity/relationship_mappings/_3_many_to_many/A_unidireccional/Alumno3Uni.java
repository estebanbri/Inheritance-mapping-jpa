package com.example.Inheritancemappingjpa.entity.relationship_mappings._3_many_to_many.A_unidireccional;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//@Entity
public class Alumno3Uni implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "ALUMNO_NOTEBOOK",
            joinColumns = { @JoinColumn(name = "ALUMNO_ID") },
            inverseJoinColumns = { @JoinColumn(name = "NOTEBOOK_ID") })
    private List<Notebook3Uni> notebooks = new ArrayList<>();

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

    public List<Notebook3Uni> getNotebook() {
        return notebooks;
    }

    public void setNotebooks(List<Notebook3Uni> notebook) {
        this.notebooks = notebook;
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
