package com.api.livro_ja.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.livro_ja.models.ClienteModel;
import com.api.livro_ja.repositories.ClienteRepository;

import jakarta.transaction.Transactional;

@Service
public class ClienteServiceImpl implements ClienteService{
	
	@Autowired
	ClienteRepository clienteRepository;

	@Override
	public List<ClienteModel> findAll() {
		
		return clienteRepository.findAll();
	}

	@Override
	public Optional<ClienteModel> findById(UUID id) {
		
		return clienteRepository.findById(id);
	}

	@Override
	@Transactional
	public ClienteModel save(ClienteModel cliente) {
		
		return clienteRepository.save(cliente);
	}

	@Override
	@Transactional
	public void deleteCliente(ClienteModel cliente) {
		
		clienteRepository.delete(cliente);
	}

	@Override
	public boolean existsByCpf(String cpf) {
		
		return clienteRepository.existsByCpf(cpf);
	}

}
