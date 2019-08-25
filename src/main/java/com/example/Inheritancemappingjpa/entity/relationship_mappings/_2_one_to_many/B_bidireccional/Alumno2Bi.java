package com.example.Inheritancemappingjpa.entity.relationship_mappings._2_one_to_many.B_bidireccional;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Alumno2Bi {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;

    @OneToMany(mappedBy = "alumno")
    private List<Notebook2Bi> notebooks = new ArrayList<>();

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

    public List<Notebook2Bi> getNotebook() {
        return notebooks;
    }

    public void setNotebook(List<Notebook2Bi> notebooks) {
        this.notebooks = notebooks;
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
