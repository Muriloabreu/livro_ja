package com.api.livro_ja.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.api.livro_ja.dtos.LivroDtos;
import com.api.livro_ja.models.LivroModel;
import com.api.livro_ja.services.LivroService;

import jakarta.validation.Valid;

@Controller
@CrossOrigin(originPatterns = "*", maxAge = 3600) /*Para permitir ser acessado de qualquer fonte*/
@RequestMapping("/livro-ja") /*Mapeamento a nível de classe*/
public class LivroController {
	
	@Autowired
	LivroService livroService;
	
	@PostMapping
	public ResponseEntity<Object> saveLivro(@RequestBody @Valid LivroDtos livroDtos){
		if (livroService.existsBytitulo(livroDtos.getTitulo())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Livro já está cadastrado!"); /* Check se livro já está cadastrada */
		}
		LivroModel livroModel = new LivroModel();
		BeanUtils.copyProperties(livroDtos, livroModel);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(livroService.save(livroModel));
	}
	
	

}
