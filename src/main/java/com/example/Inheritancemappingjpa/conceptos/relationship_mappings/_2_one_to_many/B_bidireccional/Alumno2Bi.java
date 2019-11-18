package com.example.Inheritancemappingjpa.conceptos.relationship_mappings._2_one_to_many.B_bidireccional;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//@Entity
public class Alumno2Bi implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;

    @OneToMany(mappedBy = "alumno", cascade = CascadeType.ALL)
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

    public void addNotebook(Notebook2Bi notebook) {
        notebooks.add(notebook);
        notebook.setAlumno(this);
    }

}
