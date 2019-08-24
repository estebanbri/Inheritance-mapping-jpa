package com.example.Inheritancemappingjpa.entity.inheritance_mapping_strategies._2_Table_Per_Concrete_class.table_per_class;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="CONTRACT_EMPLOYEE2")
public class Contract_Employee2 extends Employee2 {

    @Column(name="PAY_PER_HOUR")
    private float pay_per_hour;

    @Column(name="CONTRACT_DURATION")
    private String contract_duration;

    public float getPay_per_hour() {
        return pay_per_hour;
    }

    public void setPay_per_hour(float pay_per_hour) {
        this.pay_per_hour = pay_per_hour;
    }

    public String getContract_duration() {
        return contract_duration;
    }

    public void setContract_duration(String contract_duration) {
        this.contract_duration = contract_duration;
    }
}
