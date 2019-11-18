package com.example.Inheritancemappingjpa.dao;

import com.example.Inheritancemappingjpa.conceptos.inheritance_mapping_strategies._1_Table_Per_Hierarchy.single_table.Contract_Employee1;
import com.example.Inheritancemappingjpa.conceptos.inheritance_mapping_strategies._1_Table_Per_Hierarchy.single_table.Regular_Employee1;
import com.example.Inheritancemappingjpa.conceptos.inheritance_mapping_strategies._2_Table_Per_Concrete_class.table_per_class.Contract_Employee2;
import com.example.Inheritancemappingjpa.conceptos.inheritance_mapping_strategies._2_Table_Per_Concrete_class.table_per_class.Regular_Employee2;
import com.example.Inheritancemappingjpa.conceptos.inheritance_mapping_strategies._3_Table_Per_Subclass.joined.Contract_Employee3;
import com.example.Inheritancemappingjpa.conceptos.inheritance_mapping_strategies._3_Table_Per_Subclass.joined.Regular_Employee3;
import com.example.Inheritancemappingjpa.conceptos.pk_generation.entity.secuence.default_secuence.Alumno;
import com.example.Inheritancemappingjpa.conceptos.relationship_mappings._1_one_to_one.A_unidireccional.Alumno1Uni;
import com.example.Inheritancemappingjpa.conceptos.relationship_mappings._1_one_to_one.A_unidireccional.Notebook1Uni;
import com.example.Inheritancemappingjpa.conceptos.relationship_mappings._1_one_to_one.B_bidireccional.Alumno1Bi;
import com.example.Inheritancemappingjpa.conceptos.relationship_mappings._1_one_to_one.B_bidireccional.Notebook1Bi;
import com.example.Inheritancemappingjpa.conceptos.relationship_mappings._2_one_to_many.B_bidireccional.Alumno2Bi;
import com.example.Inheritancemappingjpa.conceptos.relationship_mappings._2_one_to_many.B_bidireccional.Notebook2Bi;
import com.example.Inheritancemappingjpa.conceptos.relationship_mappings._3_many_to_many.A_unidireccional.Alumno3Uni;
import com.example.Inheritancemappingjpa.conceptos.relationship_mappings._3_many_to_many.A_unidireccional.Notebook3Uni;
import com.example.Inheritancemappingjpa.conceptos.relationship_mappings._3_many_to_many.B_bidireccional.Alumno3Bi;
import com.example.Inheritancemappingjpa.conceptos.relationship_mappings._3_many_to_many.B_bidireccional.Notebook3Bi;
import com.example.Inheritancemappingjpa.conceptos.relationship_mappings._2_one_to_many.A_unidireccional.Alumno2Uni;
import com.example.Inheritancemappingjpa.conceptos.relationship_mappings._2_one_to_many.A_unidireccional.Notebook2Uni;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Arrays;
import java.util.List;

@Component
public class Dao {

    @Autowired
    EntityManager em;


    @Transactional
    public void test_inheritance_mapping_strategy_TABLE_PER_HIERARCHY(){
        Regular_Employee1 regular = new Regular_Employee1();
        regular.setName("Esteban");
        regular.setBonus(100);
        regular.setSalary(500F);

        Contract_Employee1 contract = new Contract_Employee1();
        contract.setName("Andres");
        contract.setContract_duration("12 meses");
        contract.setPay_per_hour(15F);

        em.persist(regular);
        em.persist(contract);
    }

    @Transactional
    public void test_inheritance_mapping_strategy_TABLE_PER_CONCRETE_CLASS(){
        Regular_Employee2 regular = new Regular_Employee2();
        regular.setName("Esteban");
        regular.setBonus(100);
        regular.setSalary(500F);

        Contract_Employee2 contract = new Contract_Employee2();
        contract.setName("Andres");
        contract.setContract_duration("12 meses");
        contract.setPay_per_hour(15F);

        em.persist(regular);
        em.persist(contract);
    }


    @Transactional
    public void test_inheritance_mapping_strategy_TABLE_PER_SUBCLASES(){
        Regular_Employee3 regular = new Regular_Employee3();
        regular.setName("Esteban");
        regular.setBonus(100);
        regular.setSalary(500F);

        Contract_Employee3 contract = new Contract_Employee3();
        contract.setName("Andres");
        contract.setContract_duration("12 meses");
        contract.setPay_per_hour(15F);

        em.persist(regular);
        em.persist(contract);
    }

    @Transactional
    public void a(){

        Contract_Employee3 contract = new Contract_Employee3(); // Transient State
        contract.setName("Andres");                             // Transient State
        contract.setContract_duration("12 meses");              // Transient State
        contract.setPay_per_hour(15F);                          // Transient State


        em.persist(contract);             // Persistece State
        contract.setPay_per_hour(144F);   // Persistece State

        em.detach(contract);              // Detached State (session.close() hace que la entity pase a estado detached)

        em.remove(contract);              // Removed State

    }

    @Transactional
    public void test_ONE_TO_ONE_UNIDIRECCIONAL_PERSIST(){
        Alumno1Uni alumno = new Alumno1Uni();
        Notebook1Uni lenovo = new Notebook1Uni();
        lenovo.setNombre("Lenovo");

        alumno.setNombre("Esteban");
        alumno.setNotebook(lenovo);

        em.persist(alumno);
    }

    @Transactional
    public void test_ONE_TO_ONE_UNIDIRECCIONAL_SELECT(){
        Alumno1Uni alumno = em.find(Alumno1Uni.class, 1L);
        System.out.println(alumno.getId());
    }

    @Transactional
    public void test_ONE_TO_ONE_BIDIRECCIONAL_PERSIST(){
        Alumno1Bi alumno = new Alumno1Bi();
        Notebook1Bi lenovo = new Notebook1Bi();
        lenovo.setNombre("Lenovo");

        alumno.setNombre("Esteban");
        alumno.setNotebook(lenovo);

        em.persist(alumno);
    }

    @Transactional
    public void test_ONE_TO_ONE_BIDIRECCIONAL_SELECT(){
        Alumno1Bi alumno = em.find(Alumno1Bi.class, 1L);
        Notebook1Bi notebook = em.find(Notebook1Bi.class, 2L);

        System.out.println(alumno.getId());
        System.out.println(notebook.getAlumno().getNombre());
    }

    @Transactional
    public void test_ONE_TO_MANY_UNIDIRECCIONAL_PERSIST(){
        Alumno2Uni alumno = new Alumno2Uni();
        List<Notebook2Uni> notebooks = Arrays.asList(
                new Notebook2Uni("Lenovo"),
                new Notebook2Uni("Apple")
                );

        alumno.setNombre("Esteban");
        alumno.setNotebooks(notebooks);

        em.persist(alumno);
    }

    @Transactional
    public void test_ONE_TO_MANY_UNIDIRECCIONAL_SELECT(){
        Alumno2Uni alumno = em.find(Alumno2Uni.class, 1L);
        System.out.println(alumno.getNombre());
    }

    @Transactional
    public void test_ONE_TO_MANY_BIDIRECCIONAL_PERSIST(){
        Alumno2Bi alumno = new Alumno2Bi();

        alumno.setNombre("Esteban");
        alumno.addNotebook(new Notebook2Bi("Lenovo"));
        alumno.addNotebook(new Notebook2Bi("Apple"));

        em.persist(alumno);
    }

    @Transactional
    public void test_ONE_TO_MANY_BIDIRECCIONAL_SELECT(){
        Alumno2Bi alumno = em.find(Alumno2Bi.class, 1L);
        Notebook2Bi lenovo = em.find(Notebook2Bi.class, 2L);
        System.out.println(alumno.getNombre());
        System.out.println(lenovo.getAlumno().getNombre());
    }

    @Transactional
    public void test_MANY_TO_MANY_UNIDIRECCIONAL_PERSIST(){
        Alumno3Uni alumno = new Alumno3Uni();
        List<Notebook3Uni> notebooks = Arrays.asList(
                new Notebook3Uni("Lenovo"),
                new Notebook3Uni("Apple")
        );

        alumno.setNombre("Esteban");
        alumno.setNotebooks(notebooks);

        em.persist(alumno);
    }

    @Transactional
    public void test_MANY_TO_MANY_UNIDIRECCIONAL_SELECT(){
        Alumno3Uni alumno = em.find(Alumno3Uni.class, 1L);
        System.out.println(alumno.getNombre());
    }

    @Transactional
    public void test_MANY_TO_MANY_BIDIRECCIONAL_PERSIST(){
        Alumno3Bi alumno1 = new Alumno3Bi();
        Alumno3Bi alumno2 = new Alumno3Bi();
        Notebook3Bi lenovo = new Notebook3Bi("Lenovo");
        Notebook3Bi apple = new Notebook3Bi("Apple");

        alumno1.setNombre("Esteban");
        alumno2.setNombre("Andres");

        alumno1.addNotebook(lenovo);
        alumno1.addNotebook(apple);
        alumno2.addNotebook(lenovo);
        alumno2.addNotebook(apple);

        em.persist(alumno1);
        em.persist(alumno2);
    }

    @Transactional
    public void test_MANY_TO_MANY_BIDIRECCIONAL_SELECT(){
        Alumno3Bi alumno = em.find(Alumno3Bi.class, 1L);
        Notebook3Bi lenovo = em.find(Notebook3Bi.class, 2L);
        System.out.println(alumno.getNombre());
        lenovo.getAlumnos().forEach(alumn -> System.out.println(alumn.getNombre()));
    }

    @Transactional
    public void test_PK_GENERATION_TYPE_IDENTITY_PERSIST(){
        com.example.Inheritancemappingjpa.conceptos.pk_generation.entity.identity.Alumno alumno = new com.example.Inheritancemappingjpa.conceptos.pk_generation.entity.identity.Alumno();
        alumno.setNombre("Esteban");

        com.example.Inheritancemappingjpa.conceptos.pk_generation.entity.identity.Profesor profesor = new com.example.Inheritancemappingjpa.conceptos.pk_generation.entity.identity.Profesor();
        profesor.setNombre("Jose");

        em.persist(alumno);
        em.persist(profesor);
    }

    @Transactional
    public void test_PK_GENERATION_TYPE_DEFAULT_SECUENCE_PERSIST(){
        com.example.Inheritancemappingjpa.conceptos.pk_generation.entity.secuence.default_secuence.Alumno alumno = new com.example.Inheritancemappingjpa.conceptos.pk_generation.entity.secuence.default_secuence.Alumno();
        alumno.setNombre("Esteban");

        com.example.Inheritancemappingjpa.conceptos.pk_generation.entity.secuence.default_secuence.Profesor profesor = new com.example.Inheritancemappingjpa.conceptos.pk_generation.entity.secuence.default_secuence.Profesor();
        profesor.setNombre("Jose");

        em.persist(alumno); // call next value for hibernate_sequence (id = 1)
        em.persist(profesor); // call next value for hibernate_sequence (id = 2)
    }

    @Transactional
    public void test_PK_GENERATION_TYPE_CUSTOM_SECUENCE_PERSIST(){
        com.example.Inheritancemappingjpa.conceptos.pk_generation.entity.secuence.custom_sequence.Alumno alumno = new com.example.Inheritancemappingjpa.conceptos.pk_generation.entity.secuence.custom_sequence.Alumno();
        alumno.setNombre("Esteban");

        com.example.Inheritancemappingjpa.conceptos.pk_generation.entity.secuence.custom_sequence.Profesor profesor = new com.example.Inheritancemappingjpa.conceptos.pk_generation.entity.secuence.custom_sequence.Profesor();
        profesor.setNombre("Jose");

        em.persist(alumno); // 1° call next value for alumno_seq (1) y 2° call next value for alumno_seq (10) (id = 1)
        em.persist(profesor); // 1° call next value for profesor_seq (1) y 2° call next value for profesor_seq (10) (id = 1)
    }

    @Transactional
    public void test_PK_GENERATION_TYPE_TABLE_PERSIST(){
        com.example.Inheritancemappingjpa.conceptos.pk_generation.entity.table.Alumno alumno = new com.example.Inheritancemappingjpa.conceptos.pk_generation.entity.table.Alumno();
        alumno.setNombre("Esteban");

        com.example.Inheritancemappingjpa.conceptos.pk_generation.entity.table.Profesor profesor = new com.example.Inheritancemappingjpa.conceptos.pk_generation.entity.table.Profesor();
        profesor.setNombre("Jose");

        em.persist(alumno);
        // Paso 1 (obtener el valor actual): select next_val from hibernate_seq where sequence_name=? for update (0)
        // Paso 2 (actualizar el valor siguiente): : update hibernate_seq set next_val=?where next_val=? and sequence_name=? (1)
        // (id = 1)
        em.persist(profesor);
        // Paso 1 (obtener el valor actual): select next_val from hibernate_seq where sequence_name=? for update (0)
        // Paso 2 (actualizar el valor siguiente): : update hibernate_seq set next_val=?where next_val=? and sequence_name=? (1)
        // (id = 1)
    }

}
