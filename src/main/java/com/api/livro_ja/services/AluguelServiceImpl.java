package com.api.livro_ja.services;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.api.livro_ja.models.AluguelModel;

import com.api.livro_ja.repositories.AluguelRepository;


import jakarta.transaction.Transactional;

@Service
public class AluguelServiceImpl implements AluguelService{
	
	@Autowired
	AluguelRepository aluguelRepository;
	

	@Override
	public List<AluguelModel> findAll() {
		
		return aluguelRepository.findAll();
	}

	@Override
	public Optional<AluguelModel> findById(UUID id) {
		
		return aluguelRepository.findById(id);
	}

	@Override
	@Transactional
	public void deleteAluguel(AluguelModel aluguel) {
		
		aluguelRepository.delete(aluguel);
		
	}

	@Override
	public AluguelModel save(AluguelModel aluguelModel) {
		
		return aluguelRepository.save(aluguelModel);
	}

	

}
