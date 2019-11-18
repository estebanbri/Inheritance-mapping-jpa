package com.example.Inheritancemappingjpa.conceptos.spring_data_jpa_y_hql.repository;



import com.example.Inheritancemappingjpa.conceptos.relationship_mappings._2_one_to_many.A_unidireccional.Alumno2Uni;
import com.example.Inheritancemappingjpa.conceptos.relationship_mappings._2_one_to_many.A_unidireccional.Notebook2Uni;
import com.example.Inheritancemappingjpa.conceptos.spring_data_jpa_y_hql.dto.MiClaseNombresDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno2Uni, Long> {

    List<Alumno2Uni> findByNombre(String nombre);

    @Query("SELECT DISTINCT alumno "
            + " FROM Alumno2Uni alumno"
            + " JOIN FETCH alumno.notebooks"
            + " WHERE alumno.nombre = :nombre")
    List<Alumno2Uni> getAlumnosByNombre(@Param("nombre") String nombre);

    @Query("SELECT DISTINCT notebooks "
            + " FROM Alumno2Uni alumno"
            + " JOIN alumno.notebooks as notebooks")
    List<Notebook2Uni> getNotebooksVersionNoCompacta();

    @Query("SELECT DISTINCT alumno.notebooks "
            + " FROM Alumno2Uni alumno")
    List<Notebook2Uni> getNotebooksVersionCompacta();

    @Query("SELECT alumno.nombre "
            + " FROM Alumno2Uni alumno"
            + " WHERE alumno.id = :id")
    String getNombreById(@Param("id") Long id);

    @Query("SELECT DISTINCT alumno.nombre, notebook.nombre "
            + " FROM Alumno2Uni alumno"
            + " JOIN alumno.notebooks as notebook")
    Object[][] getAllAlumnoNombreYNotebookNombre();

    @Query("SELECT DISTINCT new list(alumno.nombre, notebook.nombre) "
            + " FROM Alumno2Uni alumno"
            + " JOIN alumno.notebooks as notebook")
    List getAllAlumnoNombreYNotebookNombreList();

    // los alias van a ser las key de cada entry del map
    @Query("SELECT DISTINCT new map(alumno.nombre as key_alumno, notebook.nombre as key_notebook) "
            + " FROM Alumno2Uni alumno"
            + " JOIN alumno.notebooks as notebook"
            + " WHERE notebook.nombre = 'Apple'")
    Map<String, Object> getAllAlumnoNombreYNotebookNombreMap();

    // new com.example.MiClase(var1, var2)  BY CONSTRUCTOR
    @Query("SELECT new com.example.Inheritancemappingjpa.conceptos.spring_data_jpa_y_hql.dto.MiClaseNombresDTO(alumno.nombre, notebook.nombre) "
            + " FROM Alumno2Uni alumno"
            + " JOIN alumno.notebooks as notebook"
            + " WHERE alumno.id = :id"
            + " AND notebook.nombre = 'Apple'")
    MiClaseNombresDTO getAllAlumnoNombreYNotebookNombre_MiClaseNombresDTO(@Param("id") Long id);

}
