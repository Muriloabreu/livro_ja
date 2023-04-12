package com.api.livro_ja.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


import com.api.livro_ja.models.AluguelModel;



public interface AluguelService {
	
	List<AluguelModel> findAll();
	Optional<AluguelModel> findById(UUID id);
	AluguelModel save( AluguelModel aluguelModel);
	void deleteAluguel(AluguelModel aluguel);
	
	

}
