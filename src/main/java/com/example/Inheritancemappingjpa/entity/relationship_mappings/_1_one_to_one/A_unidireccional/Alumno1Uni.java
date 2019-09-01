package com.example.Inheritancemappingjpa.entity.relationship_mappings._1_one_to_one.A_unidireccional;

import javax.persistence.*;
import java.io.Serializable;

//@Entity
public class Alumno1Uni implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "NOTEBOOK_ID")
    private Notebook1Uni notebook;

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

    public Notebook1Uni getNotebook() {
        return notebook;
    }

    public void setNotebook(Notebook1Uni notebook) {
        this.notebook = notebook;
    }

    @Override
    public String toString() {
        return "Alumno1{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", notebook=" + notebook +
                '}';
    }
}
