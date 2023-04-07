package com.api.livro_ja.services;

import java.util.List;
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
	public LivroModel findById(UUID id) {
		
		return livroRepository.findById(id).get();
	}

	@Override
	@Transactional
	public LivroModel save(LivroModel livro) {
		
		return livroRepository.save(livro);
	}

	@Override
	public void deleteLivro(LivroModel livro) {
		
		livroRepository.delete(null);
		
	}

	@Override
	public boolean existsBytitulo(String titulo) {
		
		return livroRepository.existsBytitulo(titulo);
	}

}
