package com.ziojio.javaweb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.ziojio.javaweb.repository.Account;
import com.ziojio.javaweb.repository.AccountRepository;

@SpringBootApplication
public class JavawebApplication {
	private static final Logger log = LoggerFactory.getLogger(JavawebApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(JavawebApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(AccountRepository repository) {
		return (args) -> {
			// save a few customers
			repository.save(new Account("Jack", "Bauer"));
			repository.save(new Account("Chloe", "O'Brian"));
			repository.save(new Account("Kim", "Bauer"));
			repository.save(new Account("David", "Palmer"));
			repository.save(new Account("Michelle", "Dessler"));

			// fetch all customers
			log.info("Accounts found with findAll():");
			log.info("-------------------------------");
			for (Account customer : repository.findAll()) {
				log.info(customer.toString());
			}
			log.info("");

			// fetch an individual Account by ID
			Account customer = repository.findById(1);
			log.info("Account found with findById(1L):");
			log.info("--------------------------------");
			log.info(customer.toString());
			log.info("");

			// fetch customers by last name
			log.info("Account found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			repository.findByLastName("Bauer").forEach(bauer -> {
				log.info(bauer.toString());
			});
			// for (Account bauer : repository.findByLastName("Bauer")) {
			//  log.info(bauer.toString());
			// }
			log.info("");
		};
	}
}
