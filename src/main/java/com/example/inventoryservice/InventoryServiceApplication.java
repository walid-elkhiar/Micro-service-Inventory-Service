package com.example.inventoryservice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner start(ProduitRepository produitRepository) {
		return args -> {
			produitRepository.save(new Product(null,"HP EliteBook",700,3));
			produitRepository.save(new Product(null,"Iphone 8 Plus",999,5));
			produitRepository.save(new Product(null,"Lenovo LP40",199,8));
			produitRepository.findAll().forEach(p->{
				System.out.println(p.toString());
			});
		};
	}

}

@Entity @Data @NoArgsConstructor @AllArgsConstructor 
class Product{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private double price;
	private double quantity;
	
}
@RepositoryRestResource 
interface ProduitRepository extends JpaRepository<Product, Long>{
	
}