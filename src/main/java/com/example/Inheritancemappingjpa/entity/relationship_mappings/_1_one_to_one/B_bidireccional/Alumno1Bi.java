package com.example.Inheritancemappingjpa.entity.relationship_mappings._1_one_to_one.B_bidireccional;

import javax.persistence.*;

@Entity
public class Alumno1Bi {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;

    @OneToOne
    private Notebook1Bi notebook;

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
    public Notebook1Bi getNotebook() {
        return notebook;
    }
    public void setNotebook(Notebook1Bi notebook) {
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
