package com.example.Inheritancemappingjpa.entity.inheritance_mapping_strategies._3_Table_Per_Subclass.joined;

import javax.persistence.*;

@Entity
@Table(name = "EMPLOYEE3")
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Employee3 {

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