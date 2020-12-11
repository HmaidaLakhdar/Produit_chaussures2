package com.hmaida.chaussures;


import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hmaida.chaussures.entities.Chaussures;
import com.hmaida.chaussures.service.ChaussuresService;

@SpringBootApplication
public class ChaussuresApplication implements CommandLineRunner {

	@Autowired
ChaussuresService chaussuresService;
	
public static void main(String[] args) {
SpringApplication.run(ChaussuresApplication.class, args);
}
@Override
public void run(String... args) throws Exception {
chaussuresService.saveChaussures(new Chaussures("Adidas", 500.0, new Date()));
chaussuresService.saveChaussures(new Chaussures("Reebok", 300.0, new Date()));
chaussuresService.saveChaussures(new Chaussures("Puma", 300.0, new Date()));
}
}