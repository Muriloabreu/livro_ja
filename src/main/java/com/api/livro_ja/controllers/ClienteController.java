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

import com.api.livro_ja.dtos.ClienteDtos;
import com.api.livro_ja.models.ClienteModel;
import com.api.livro_ja.services.ClienteService;
import jakarta.validation.Valid;

@Controller
@CrossOrigin(originPatterns = "*", maxAge = 3600) /*Para permitir ser acessado de qualquer fonte*/
@RequestMapping("/livro-ja/cliente") /*Mapeamento a nível de classe*/
public class ClienteController {
	
	@Autowired
	ClienteService clienteService;
	
	
	@PostMapping
	public ResponseEntity<Object> saveCliente(@RequestBody @Valid ClienteDtos clienteDtos){
		if (clienteService.existsByCpf(clienteDtos.getCpf())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: CPF já cadastrado!"); /* Check se livro já está cadastrada */
		}
		ClienteModel clienteModel = new ClienteModel();
		BeanUtils.copyProperties(clienteDtos, clienteModel); /*Coverte Dtos para Model*/
		
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(clienteModel));
	}
	
	@GetMapping
	public ResponseEntity<List<ClienteModel>>getAllClientes(){
		return ResponseEntity.status(HttpStatus.OK).body(clienteService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneCliente(@PathVariable(value = "id") UUID id) {

		Optional<ClienteModel> clienteOptional = clienteService.findById(id);

		if (!clienteOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado. "); /*Mensagem se o cliente não for encontrado */
		}

		return ResponseEntity.status(HttpStatus.OK).body(clienteOptional.get());

	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteCliente(@PathVariable(value = "id") UUID id) {

		Optional<ClienteModel> livroOptional = clienteService.findById(id);
		if (!livroOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Livro não encontrado. "); /*Mensagem se o Cliente não for encontrado */
		}
		clienteService.deleteCliente(livroOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Cliente deletado com sucesso!");

	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateCliente(@PathVariable(value = "id") UUID id,
			                                        @RequestBody @Valid ClienteDtos clienteDto) {

		Optional<ClienteModel> clienteModelOptional = clienteService.findById(id);
		if (!clienteModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Livro não encontrado. ");
		}
		
		var clienteModel = clienteModelOptional.get();
		clienteModel.setNome(clienteDto.getNome());
		clienteModel.setSobreNome(clienteDto.getSobreNome());
		clienteModel.setCpf(clienteDto.getCpf());
		clienteModel.setTelefone(clienteDto.getTelefone());
		
				
		return ResponseEntity.status(HttpStatus.OK).body(clienteService.save(clienteModel));

	}

}
