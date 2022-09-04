package org.sreekanth.ngm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.sreekanth.ngm.service.ItemService;

@SpringBootApplication
public class NeighbourhoodGroceryMarket {

	public static void main(String[] args) {
		SpringApplication.run(NeighbourhoodGroceryMarket.class, args);
	}
}
