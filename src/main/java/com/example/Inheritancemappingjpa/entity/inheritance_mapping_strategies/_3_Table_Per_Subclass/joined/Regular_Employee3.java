package com.example.Inheritancemappingjpa.entity.inheritance_mapping_strategies._3_Table_Per_Subclass.joined;

import javax.persistence.*;

@Entity
@Table(name="REGULAR_EMPLOYEE3")
public class Regular_Employee3 extends Employee3 {

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
