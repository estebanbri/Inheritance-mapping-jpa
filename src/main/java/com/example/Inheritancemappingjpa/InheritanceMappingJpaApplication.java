package com.example.Inheritancemappingjpa;

import com.example.Inheritancemappingjpa.dao.Dao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class InheritanceMappingJpaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(InheritanceMappingJpaApplication.class, args);
		Dao dao = context.getBean("dao", Dao.class);
		/**
		 *  Descomenta lo que queres probar
		 */
		//dao.test_inheritance_mapping_strategy_TABLE_PER_HIERARCHY(); // SINGLE_TABLE
		//dao.test_inheritance_mapping_strategy_TABLE_PER_CONCRETE_CLASS(); // TABLE_PER_CLASS
		//dao.test_inheritance_mapping_strategy_TABLE_PER_SUBCLASES(); // JOINED
		//dao.test_ONE_TO_ONE_UNIDIRECCIONAL_PERSIST();
		//dao.test_ONE_TO_ONE_UNIDIRECCIONAL_SELECT();
		//dao.test_ONE_TO_ONE_BIDIRECCIONAL_PERSIST();
		//dao.test_ONE_TO_ONE_BIDIRECCIONAL_SELECT();
		//dao.test_ONE_TO_MANY_UNIDIRECCIONAL_PERSIST();
		//dao.test_ONE_TO_MANY_UNIDIRECCIONAL_SELECT();
		//dao.test_ONE_TO_MANY_BIDIRECCIONAL_PERSIST();
		//dao.test_ONE_TO_MANY_BIDIRECCIONAL_SELECT();
		//dao.test_MANY_TO_MANY_UNIDIRECCIONAL_PERSIST();
		//dao.test_MANY_TO_MANY_UNIDIRECCIONAL_SELECT();
		//dao.test_MANY_TO_MANY_BIDIRECCIONAL_PERSIST();
		//dao.test_MANY_TO_MANY_BIDIRECCIONAL_SELECT();

		//dao.test_PK_GENERATION_TYPE_IDENTITY_PERSIST();
		///dao.test_PK_GENERATION_TYPE_DEFAULT_SECUENCE_PERSIST();
		//dao.test_PK_GENERATION_TYPE_CUSTOM_SECUENCE_PERSIST();
		dao.test_PK_GENERATION_TYPE_TABLE_PERSIST();
	}
}

