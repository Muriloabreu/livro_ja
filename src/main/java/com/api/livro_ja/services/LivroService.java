package com.api.livro_ja.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.livro_ja.repositories.LivroRepository;

@Service
public class LivroService {

	@Autowired /* Ponto de injeção*/
	LivroRepository livroRepository;
}
