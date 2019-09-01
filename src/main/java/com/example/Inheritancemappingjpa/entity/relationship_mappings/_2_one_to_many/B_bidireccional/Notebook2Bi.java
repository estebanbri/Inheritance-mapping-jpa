package com.example.Inheritancemappingjpa.entity.relationship_mappings._2_one_to_many.B_bidireccional;

import javax.persistence.*;
import java.io.Serializable;

//@Entity
public class Notebook2Bi implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "ALUMNO_ID")
    private Alumno2Bi alumno;

    public Notebook2Bi() {
    }

    public Notebook2Bi(String nombre) {
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

    public Alumno2Bi getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno2Bi alumno) {
        this.alumno = alumno;
    }

    @Override
    public String toString() {
        return "Notebook1Bi{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", alumno=" + alumno +
                '}';
    }
}
