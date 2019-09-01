package com.example.Inheritancemappingjpa.entity.inheritance_mapping_strategies._2_Table_Per_Concrete_class.table_per_class;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

//@Entity
@Table(name="REGULAR_EMPLOYEE2")
public class Regular_Employee2 extends Employee2 {

    @Column(name="SALARY")
    private float salary;

    @Column(name="BONUS")
    private int bonus;

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }
}
