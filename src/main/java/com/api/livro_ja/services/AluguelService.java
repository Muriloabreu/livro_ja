package com.api.livro_ja.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.api.livro_ja.dtos.AluguelDtos;
import com.api.livro_ja.models.AluguelModel;
import com.api.livro_ja.models.ClienteModel;
import com.api.livro_ja.models.LivroModel;


public interface AluguelService {
	
	List<AluguelModel> findAll();
	Optional<AluguelModel> findById(UUID id);
	AluguelModel save( AluguelDtos aluguelDtos);
	void deleteAluguel(AluguelModel aluguel);
	
	

}
