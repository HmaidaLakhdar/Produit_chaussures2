package com.hmaida.chaussures.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.hmaida.chaussures.entities.Chaussures;
import com.hmaida.chaussures.repos.ChaussuresRepository;

@Service
public class ChaussuresServiceImpl implements ChaussuresService {
	
	@Autowired
	ChaussuresRepository chaussuresRepository;

	@Override
	public Chaussures saveChaussures(Chaussures c) {
		return chaussuresRepository.save(c);
	}

	@Override
	public Chaussures updateChaussures(Chaussures c) {
		return chaussuresRepository.save(c);
	}

	@Override
	public void deleteChaussures(Chaussures c) {
		chaussuresRepository.delete(c);
		
	}

	@Override
	public void deleteChaussuresById(Long id) {
		chaussuresRepository.deleteById(id);
		
	}

	@Override
	public Chaussures getChaussures(Long id) {
		return chaussuresRepository.findById(id).get();
	}

	@Override
	public List<Chaussures> getAllChaussures() {
		return chaussuresRepository.findAll();
	}

	@Override
	public Page<Chaussures> getAllChaussuresParPage(int page, int size) {
		return chaussuresRepository.findAll(PageRequest.of(page, size));

	}


}
