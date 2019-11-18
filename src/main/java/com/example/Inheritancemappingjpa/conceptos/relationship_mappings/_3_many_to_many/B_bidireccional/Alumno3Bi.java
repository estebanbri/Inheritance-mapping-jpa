package com.example.Inheritancemappingjpa.conceptos.relationship_mappings._3_many_to_many.B_bidireccional;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//@Entity
public class Alumno3Bi {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "ALUMNO_NOTEBOOK",
            joinColumns = { @JoinColumn(name = "ALUMNO_ID") },
            inverseJoinColumns = { @JoinColumn(name = "NOTEBOOK_ID") })
    private List<Notebook3Bi> notebooks = new ArrayList<>();

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

    public List<Notebook3Bi> getNotebook() {
        return notebooks;
    }

    public void setNotebook(List<Notebook3Bi> notebooks) {
        this.notebooks = notebooks;
    }

    public void addNotebook(Notebook3Bi notebook) {
        notebooks.add(notebook);
        notebook.getAlumnos().add(this);
    }

    @Override
    public String toString() {
        return "Alumno1{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", notebooks=" + notebooks +
                '}';
    }
}
