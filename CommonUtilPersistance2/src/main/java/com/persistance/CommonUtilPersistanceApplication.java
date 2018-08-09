package com.persistance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@SpringBootApplication
@EnableJpaRepositories(namedQueriesLocation="classpath:reservation-sql.properties")
@EnableCaching
public class CommonUtilPersistanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommonUtilPersistanceApplication.class, args);
	}
}
