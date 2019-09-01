package com.example.Inheritancemappingjpa.entity.inheritance_mapping_strategies._1_Table_Per_Hierarchy.single_table;

import javax.persistence.*;

//@Entity
@Table(name = "EMPLOYEE1")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public abstract class Employee1 {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
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