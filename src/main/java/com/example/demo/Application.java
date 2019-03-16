package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;

@EnableAutoConfiguration
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	// @Bean
	// public CommandLineRunner demo(CustomerRepository repository){
	// 	return (args) -> {
	// 		repository.save(new Customer("Jack", "Bauer", 1));
	// 		repository.save(new Customer("Chloe", "O' Brian",3));
	// 		repository.save(new Customer("Kim", "Bauer",2));
	// 		repository.save(new Customer("David", "Palmer",2));
	// 		repository.save(new Customer("Chloe", "Dessler", 4));

	// 		// log.info("customer found with findAll()");o
	// 		// log.info("-----------------");
	// 		// repository.findAll().forEach(i -> log.info(i.toString()));
	// 		// log.info("");

	// 		// repository.findById(4L)
	// 		// 					.ifPresent(customer -> {
	// 		// 						log.info("customer found with findById(1L)");
	// 		// 						log.info("------------");
	// 		// 						log.info(customer.toString());
	// 		// 						log.info("");
	// 		// 					});

	// 		log.info("----- findbylastname('bau') ------------");
	// 		repository.findByLastName("Palmer").forEach(bauer -> {
	// 			log.info(bauer.toString());
	// 		});
	// 		// log.info("------ find chloe -----------");
	// 		// repository.findByFirstName("Chloe").forEach(i -> log.info(i.toString()));
			
	// 		// log.info("---- find price ------");
	// 		// repository.findByPrice(2).forEach(i -> log.info(i.toString()));

	// 	};
	// }

	// @Bean
	// public CommandLineRunner demo2(){
	// 	return (args) -> {
	// 		log.info("I am demo2!");
	// 	};
	// }
		
	// @Bean
	// public CommandLineRunner demo3(){
	// 	return (args) -> {
	// 		log.info("I am demo3 xxx");
	// 	};
	// }
		
	
}










