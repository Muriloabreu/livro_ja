package com.api.livro_ja.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.api.livro_ja.models.LivroModel;

public interface LivroService {
	
	List<LivroModel> findAll();
	Optional<LivroModel> findById(UUID id);
	LivroModel save(LivroModel livro);
	void deleteLivro(LivroModel livro);
	boolean existsBytitulo(String titulo);

}
