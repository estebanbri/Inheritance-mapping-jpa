package com.example.Inheritancemappingjpa.dao;

import com.example.Inheritancemappingjpa.entity.inheritance_mapping_strategies._1_Table_Per_Hierarchy.single_table.Contract_Employee1;
import com.example.Inheritancemappingjpa.entity.inheritance_mapping_strategies._1_Table_Per_Hierarchy.single_table.Regular_Employee1;
import com.example.Inheritancemappingjpa.entity.inheritance_mapping_strategies._2_Table_Per_Concrete_class.table_per_class.Contract_Employee2;
import com.example.Inheritancemappingjpa.entity.inheritance_mapping_strategies._2_Table_Per_Concrete_class.table_per_class.Regular_Employee2;
import com.example.Inheritancemappingjpa.entity.inheritance_mapping_strategies._3_Table_Per_Subclass.joined.Contract_Employee3;
import com.example.Inheritancemappingjpa.entity.inheritance_mapping_strategies._3_Table_Per_Subclass.joined.Regular_Employee3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

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

        em.detach(contract);              // Detached State (cuando se ejecuta commit() se hace un flush() y el objeto pasa a estado detached)

        em.remove(contract);              // Removed State

    }
}
