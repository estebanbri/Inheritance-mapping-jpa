package com.example.Inheritancemappingjpa.conceptos.relationship_mappings._1_one_to_one.B_bidireccional;

import javax.persistence.*;
import java.io.Serializable;

//@Entity
public class Alumno1Bi  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "alumno")
    @JoinColumn(name = "NOTEBOOK_ID")
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
        if (notebook == null) {
            if (this.notebook != null) {
                this.notebook.setAlumno(null);
            }
        }
        else {
            notebook.setAlumno(this);
        }
        this.notebook = notebook;
    }

    @Override
    public String toString() {
        return "Alumno1Bi{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", notebook=" + notebook +
                '}';
    }
}
