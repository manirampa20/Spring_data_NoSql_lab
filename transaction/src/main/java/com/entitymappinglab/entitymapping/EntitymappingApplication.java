package com.entitymappinglab.entitymapping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class EntitymappingApplication {

	public static void main(String[] args) {
		SpringApplication.run(EntitymappingApplication.class, args);
	}

}
