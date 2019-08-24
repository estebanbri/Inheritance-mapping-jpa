package com.example.Inheritancemappingjpa;

import com.example.Inheritancemappingjpa.dao.Dao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class InheritanceMappingJpaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(InheritanceMappingJpaApplication.class, args);
		Dao dao = context.getBean("dao", Dao.class);
		dao.test_inheritance_mapping_strategy_TABLE_PER_HIERARCHY(); // SINGLE_TABLE
		dao.test_inheritance_mapping_strategy_TABLE_PER_CONCRETE_CLASS(); // TABLE_PER_CLASS
		dao.test_inheritance_mapping_strategy_TABLE_PER_SUBCLASES(); // JOINED
	}
}

