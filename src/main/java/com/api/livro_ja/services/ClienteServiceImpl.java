package com.api.livro_ja.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.livro_ja.models.ClienteModel;

import jakarta.transaction.Transactional;

@Service
public class ClienteServiceImpl implements ClienteService{
	
	@Autowired
	ClienteService clienteService;

	@Override
	public List<ClienteModel> findAll() {
		
		return clienteService.findAll();
	}

	@Override
	public Optional<ClienteModel> findById(UUID id) {
		
		return clienteService.findById(id);
	}

	@Override
	@Transactional
	public ClienteModel save(ClienteModel cliente) {
		
		return clienteService.save(cliente);
	}

	@Override
	@Transactional
	public void deleteCliente(ClienteModel cliente) {
		
		clienteService.deleteCliente(cliente);
	}

	@Override
	public boolean existsByCpf(String cpf) {
		
		return clienteService.existsByCpf(cpf);
	}

}
