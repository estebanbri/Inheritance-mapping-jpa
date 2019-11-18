package com.example.Inheritancemappingjpa.conceptos.relationship_mappings._1_one_to_one.B_bidireccional;

import javax.persistence.*;
import java.io.Serializable;

//@Entity
public class Notebook1Bi implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;

    @OneToOne
    @JoinColumn(name = "ALUMNO_ID")
    private Alumno1Bi alumno;

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

    public Alumno1Bi getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno1Bi alumno) {
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
