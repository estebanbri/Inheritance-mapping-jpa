package com.example.Inheritancemappingjpa.conceptos.inheritance_mapping_strategies._2_Table_Per_Concrete_class.table_per_class;

import javax.persistence.*;

//@Entity
@Table(name = "EMPLOYEE2")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Employee2 {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "ID")
    private int id;

    @Column(name = "NAME")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}