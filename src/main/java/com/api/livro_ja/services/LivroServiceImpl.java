package com.api.livro_ja.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.livro_ja.models.LivroModel;
import com.api.livro_ja.repositories.LivroRepository;

import jakarta.transaction.Transactional;

@Service
public class LivroServiceImpl implements LivroService{

	@Autowired
	LivroRepository livroRepository;
	
	@Override
	public List<LivroModel> findAll() {
		
		return livroRepository.findAll();
	}

	@Override
	public Optional<LivroModel> findById(UUID id) {
		
		return livroRepository.findById(id);
	}

	@Override
	@Transactional
	public LivroModel save(LivroModel livro) {
		
		return livroRepository.save(livro);
	}

	@Override
	@Transactional
	public void deleteLivro(LivroModel livro) {
		
		livroRepository.delete(livro);
		
	}

	@Override
	public boolean existsBytitulo(String titulo) {
		
		return livroRepository.existsBytitulo(titulo);
	}

}
