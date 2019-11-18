package com.example.Inheritancemappingjpa.conceptos.spring_data_jpa_y_hql.controller;


import com.example.Inheritancemappingjpa.conceptos.relationship_mappings._2_one_to_many.A_unidireccional.Notebook2Uni;
import com.example.Inheritancemappingjpa.conceptos.spring_data_jpa_y_hql.dto.MiClaseNombresDTO;
import com.example.Inheritancemappingjpa.conceptos.spring_data_jpa_y_hql.repository.AlumnoRepository;
import com.example.Inheritancemappingjpa.conceptos.relationship_mappings._2_one_to_many.A_unidireccional.Alumno2Uni;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
public class AlumnoController {

    @Autowired
    private AlumnoRepository repository;

    @GetMapping("/findByNombre/{nombre}")
    @Transactional
    public List<Alumno2Uni> findByNombre(@PathVariable String nombre){
        List<Alumno2Uni> alumnos = repository.findByNombre(nombre);
        alumnos.forEach(alumno -> alumno.getNotebook().size()); // Esta sentencia es simplemente usada para forzar a hibernate que genere la query sql para que traiga la informacion de las notebook asociadas a los alumnos ya que esa info esta como lazyloading
        return alumnos;
    }

    @GetMapping("/getAlumnosByNombre/{nombre}")
    public List<Alumno2Uni> getAlumnosByNombre(@PathVariable String nombre){
        List<Alumno2Uni> alumnos = repository.getAlumnosByNombre(nombre);
        return alumnos;
    }

    @GetMapping("/getNotebooksVersionNoCompacta")
    public List<Notebook2Uni> findNotebookByAlumnoNombre(){
        List<Notebook2Uni> notebooks = repository.getNotebooksVersionNoCompacta();
        return notebooks;
    }

    @GetMapping("/getNotebooksVersionCompacta")
    public List<Notebook2Uni> getNotebooksVersionCompacta(){
        List<Notebook2Uni> notebooks = repository.getNotebooksVersionCompacta();
        return notebooks;
    }

    @GetMapping("/getNombreById/{id}")
    public String getNombreById(@PathVariable Long id){
        String nombre = repository.getNombreById(id);
        return nombre;
    }

    @GetMapping("/getAllAlumnoNombreYNotebookNombre")
    public Object[][] getAllAlumnoNombreYNotebookNombre(){
        Object[][] arrayOfArray = repository.getAllAlumnoNombreYNotebookNombre();
        return arrayOfArray;
    }

    @GetMapping("/getAllAlumnoNombreYNotebookNombreList")
    public List getAllAlumnoNombreYNotebookNombreList(){
        List list = repository.getAllAlumnoNombreYNotebookNombreList();
        return list;
    }

    @GetMapping("/getAllAlumnoNombreYNotebookNombreMap")
    public Map<String, Object> getAllAlumnoNombreYNotebookNombreMap(){
        Map<String, Object>  map = repository.getAllAlumnoNombreYNotebookNombreMap();
        return map;
    }

    @GetMapping("/getAllAlumnoNombreYNotebookNombre_MiClaseNombresDTO/{id}")
    public MiClaseNombresDTO getAllAlumnoNombreYNotebookNombre_MiClaseNombresDTO(@PathVariable Long id){
        MiClaseNombresDTO dto = repository.getAllAlumnoNombreYNotebookNombre_MiClaseNombresDTO(id);
        return dto;
    }





}
