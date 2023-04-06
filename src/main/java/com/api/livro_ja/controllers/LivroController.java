package com.api.livro_ja.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.api.livro_ja.services.LivroService;

@Controller
public class LivroController {
	
	@Autowired
	LivroService livroService;

}
