package com.api.livro_ja.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.api.livro_ja.dtos.LivroDtos;
import com.api.livro_ja.models.LivroModel;
import com.api.livro_ja.services.LivroService;


import jakarta.validation.Valid;

@Controller
@CrossOrigin(originPatterns = "*", maxAge = 3600) /*Para permitir ser acessado de qualquer fonte*/
@RequestMapping("/livro-ja/livros") /*Mapeamento a nível de classe*/
public class LivroController {
	
	@Autowired
	LivroService livroService;
	
	@PostMapping
	public ResponseEntity<Object> saveLivro(@RequestBody @Valid LivroDtos livroDtos){
		if (livroService.existsBytitulo(livroDtos.getTitulo())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Livro já está cadastrado!"); /* Check se livro já está cadastrada */
		}
		LivroModel livroModel = new LivroModel();
		BeanUtils.copyProperties(livroDtos, livroModel); /*Coverte Dtos para Model*/
		
		return ResponseEntity.status(HttpStatus.CREATED).body(livroService.save(livroModel));
	}
	
	@GetMapping
	public ResponseEntity<List<LivroModel>>getAllLivros(){
		return ResponseEntity.status(HttpStatus.OK).body(livroService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneLivro(@PathVariable(value = "id") UUID id) {

		Optional<LivroModel> livroOptional = livroService.findById(id);

		if (!livroOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Livro não encontrado. "); /*Mensagem se o livro não for encontrado */
		}

		return ResponseEntity.status(HttpStatus.OK).body(livroOptional.get());

	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteLivro(@PathVariable(value = "id") UUID id) {

		Optional<LivroModel> livroOptional = livroService.findById(id);
		if (!livroOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Livro não encontrado. "); /*Mensagem se o livro não for encontrado */
		}
		livroService.deleteLivro(livroOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Livro deletado com sucesso!");

	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateLivro(@PathVariable(value = "id") UUID id,
			                                        @RequestBody @Valid LivroDtos livroDto) {

		Optional<LivroModel> livroModelOptional = livroService.findById(id);
		if (!livroModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Livro não encontrado. ");
		}
		
		var livroModel = livroModelOptional.get();
		livroModel.setTitulo(livroDto.getTitulo());
		livroModel.setAutor(livroDto.getAutor());
		livroModel.setLingua(livroDto.getLingua());
		livroModel.setEditora(livroDto.getEditora());
		livroModel.setPaginas(livroDto.getPaginas());
		livroModel.setGenero(livroDto.getGenero());
				
		return ResponseEntity.status(HttpStatus.OK).body(livroService.save(livroModel));

	}
	
	
	
	
	
}
