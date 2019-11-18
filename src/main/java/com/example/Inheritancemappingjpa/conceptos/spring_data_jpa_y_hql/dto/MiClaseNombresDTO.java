package com.example.Inheritancemappingjpa.conceptos.spring_data_jpa_y_hql.dto;

public class MiClaseNombresDTO {
    private String alumnoNombre;
    private String notebookNombre;

    public MiClaseNombresDTO(String alumnoNombre, String notebookNombre) {
        this.alumnoNombre = alumnoNombre;
        this.notebookNombre = notebookNombre;
    }

    public String getAlumnoNombre() {
        return alumnoNombre;
    }

    public void setAlumnoNombre(String alumnoNombre) {
        this.alumnoNombre = alumnoNombre;
    }

    public String getNotebookNombre() {
        return notebookNombre;
    }

    public void setNotebookNombre(String notebookNombre) {
        this.notebookNombre = notebookNombre;
    }
}
