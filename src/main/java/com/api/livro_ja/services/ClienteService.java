package com.api.livro_ja.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.api.livro_ja.models.ClienteModel;


public interface ClienteService {
	
	List<ClienteModel> findAll();
	Optional<ClienteModel> findById(UUID id);
	ClienteModel save(ClienteModel cliente);
	void deleteCliente(ClienteModel cliente);
	boolean existsByCpf(String titulo);

}
