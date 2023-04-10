package com.api.livro_ja.services;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.livro_ja.dtos.AluguelDtos;
import com.api.livro_ja.dtos.AluguelDtosResponse;
import com.api.livro_ja.models.AluguelModel;
import com.api.livro_ja.models.ClienteModel;
import com.api.livro_ja.models.LivroModel;
import com.api.livro_ja.repositories.AluguelRepository;
import com.api.livro_ja.repositories.ClienteRepository;
import com.api.livro_ja.repositories.LivroRepository;

import jakarta.transaction.Transactional;

@Service
public class AluguelServiceImpl implements AluguelService{
	
	@Autowired
	AluguelRepository aluguelRepository;
	@Autowired
	LivroRepository livroRepository;
	@Autowired
	ClienteRepository clienteRepository;

	@Override
	public List<AluguelModel> findAll() {
		
		return aluguelRepository.findAll();
	}

	@Override
	public Optional<AluguelModel> findById(UUID id) {
		
		return aluguelRepository.findById(id);
	}

	
	@Transactional
	public AluguelDtosResponse save( AluguelDtos aluguelDtos) {
		LivroModel livro = livroRepository.findById(aluguelDtos.getLivroId()).get();
		ClienteModel cliente = clienteRepository.findById(aluguelDtos.getClienteId()).get();
		
		AluguelModel aluguelLivro = new AluguelModel(livro, cliente, LocalDateTime.now(ZoneId.of("UTC")), aluguelDtos.getDataFim());
		aluguelRepository.save(aluguelLivro);
		
		
		return new AluguelDtosResponse(aluguelLivro);
	}

	@Override
	@Transactional
	public void deleteAluguel(AluguelModel aluguel) {
		
		aluguelRepository.delete(aluguel);
		
	}

	

}
