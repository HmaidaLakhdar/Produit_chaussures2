package com.hmaida.chaussures.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.hmaida.chaussures.entities.Chaussures;

public interface ChaussuresService {
	
	Chaussures saveChaussures(Chaussures c);
	Chaussures updateChaussures(Chaussures c);
	void deleteChaussures(Chaussures c);
	void deleteChaussuresById(Long id);
	Chaussures getChaussures(Long id);
	List<Chaussures> getAllChaussures();
	
	Page<Chaussures> getAllChaussuresParPage(int page, int size);
	
}
