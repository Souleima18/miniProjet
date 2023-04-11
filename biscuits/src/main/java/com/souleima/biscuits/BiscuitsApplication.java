package com.souleima.biscuits;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.souleima.biscuits.entities.Biscuit;
import com.souleima.biscuits.service.BiscuitService;
@SpringBootApplication
public class BiscuitsApplication implements CommandLineRunner {
@Autowired
BiscuitService biscuitService;
public static void main(String[] args) {
SpringApplication.run(BiscuitsApplication.class, args);
}
@Override
public void run(String... args) throws Exception {
//produitService.saveProduit(new Produit("PC Dell", 2600.0, new Date()));
//produitService.saveProduit(new Produit("PC Asus", 2800.0, new Date()));
//produitService.saveProduit(new Produit("Imprimante Epson", 900.0, new Date()));
}
}
