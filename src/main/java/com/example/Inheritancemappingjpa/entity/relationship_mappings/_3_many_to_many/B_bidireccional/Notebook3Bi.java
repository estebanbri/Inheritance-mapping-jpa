package com.example.Inheritancemappingjpa.entity.relationship_mappings._3_many_to_many.B_bidireccional;

import com.example.Inheritancemappingjpa.entity.relationship_mappings._3_many_to_many.A_unidireccional.Alumno3Uni;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Notebook3Bi {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;

    @ManyToMany(mappedBy = "notebooks")
    private List<Alumno3Bi> alumnos = new ArrayList<>();

    public Notebook3Bi() {
    }

    public Notebook3Bi(String nombre) {
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

    public List<Alumno3Bi> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno3Bi> alumnos) {
        this.alumnos = alumnos;
    }

    @Override
    public String toString() {
        return "Notebook3Bi{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", alumnos=" + alumnos +
                '}';
    }
}
