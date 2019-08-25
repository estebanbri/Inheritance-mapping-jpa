package com.example.Inheritancemappingjpa.entity.relationship_mappings._2_one_to_many.B_bidireccional;

import javax.persistence.*;

@Entity
public class Notebook2Bi {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;

    @ManyToOne
    private Alumno2Bi alumno;

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
