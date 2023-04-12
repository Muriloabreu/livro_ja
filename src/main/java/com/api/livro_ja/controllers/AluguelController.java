package com.api.livro_ja.controllers;

import java.time.LocalDateTime;
import java.time.ZoneId;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.api.livro_ja.dtos.AluguelDtos;
import com.api.livro_ja.models.AluguelModel;
import com.api.livro_ja.services.AluguelService;

import jakarta.validation.Valid;

@Controller
@CrossOrigin(originPatterns = "*", maxAge = 3600) /*Para permitir ser acessado de qualquer fonte*/
@RequestMapping("/livro-ja/aluguel") /*Mapeamento a nível de classe*/
public class AluguelController {
	
	@Autowired
	AluguelService aluguelService;
	
	@PostMapping
	public ResponseEntity<Object> saveAluguel(@RequestBody @Valid AluguelDtos aluguelDtos){
		
		AluguelModel aluguelModel = new AluguelModel();
		BeanUtils.copyProperties(aluguelDtos, aluguelModel);
		
		aluguelModel.setDataInicio(LocalDateTime.now(ZoneId.of("UTC")));
		return ResponseEntity.status(HttpStatus.CREATED).body(aluguelService.save(aluguelModel));
	}
	
	@GetMapping
	public ResponseEntity<List<AluguelModel>>getAllAlugueis(){
		
		return ResponseEntity.status(HttpStatus.OK).body(aluguelService.findAll());
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneAluguel(@PathVariable(value = "id") UUID id) {

		Optional<AluguelModel> aluguelOptional = aluguelService.findById(id);

		if (!aluguelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluguel não encontrado. "); /*Mensagem se o livro não for encontrado */
		}

		return ResponseEntity.status(HttpStatus.OK).body(aluguelOptional.get());

	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteAluguel(@PathVariable(value = "id") UUID id) {

		Optional<AluguelModel> aluguelOptional = aluguelService.findById(id);
		if (!aluguelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluguel não encontrado. "); /*Mensagem se o livro não for encontrado */
		}
		aluguelService.deleteAluguel(aluguelOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Aluguel deletado com sucesso!");

	}

}
