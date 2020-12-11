package com.hmaida.chaussures;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.hmaida.chaussures.entities.Chaussures;
import com.hmaida.chaussures.repos.ChaussuresRepository;
import com.hmaida.chaussures.service.ChaussuresService;
@SpringBootTest
class ProduitsApplicationTests {
	@Autowired
	private ChaussuresRepository chaussuresRepository;
	
	@Autowired
	private ChaussuresService chaussuresService;
	
	@Test
	public void testCreateChaussures() {
	Chaussures c = new Chaussures("Adidas",500.0,new Date());
	chaussuresRepository.save(c);
	}
	
	@Test
	public void testFindChaussures(){
	Chaussures c = chaussuresRepository.findById(3L).get();
	System.out.println(c);
	}
	
	@Test
	public void testUpdateChaussures(){
	Chaussures c = chaussuresRepository.findById(3L).get();
	c.setPrixChaussures(800.0);
	chaussuresRepository.save(c);
	}
	
	@Test
	public void testDeleteChaussures(){
	chaussuresRepository.deleteById(4L);
	}
	
	@Test
	public void testFindAllChaussures(){
		List<Chaussures> chaussures = chaussuresRepository.findAll();
		for (Chaussures c:chaussures )
			System.out.println(c);
	}
	
	@Test
	public void testFindByNomProduitContains()
	{
	Page<Chaussures> chauss = chaussuresService.getAllChaussuresParPage(0,2);
	System.out.println(chauss.getSize());
	System.out.println(chauss.getTotalElements());
	System.out.println(chauss.getTotalPages());
	chauss.getContent().forEach(p -> {System.out.println(p.toString());
	 });
	/*ou bien
	for (Chaussures p : chauss)
	{
	System.out.println(p);
	} */
	}

	
	

}
