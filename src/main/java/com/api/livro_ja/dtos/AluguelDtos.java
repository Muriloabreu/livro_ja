package com.api.livro_ja.dtos;



import com.api.livro_ja.models.ClienteModel;
import com.api.livro_ja.models.LivroModel;

import jakarta.validation.constraints.NotBlank;


public class AluguelDtos {
	
	@NotBlank
	private LivroModel livro;
	@NotBlank
	private ClienteModel cliente;
	@NotBlank
	private String dataFim;

	
	public AluguelDtos() {
		super();
	}
	
	
	
	public AluguelDtos(LivroModel livro, ClienteModel cliente, @NotBlank String dataFim) {
		super();
		this.livro = livro;
		this.cliente = cliente;
		this.dataFim = dataFim;
	}



	public LivroModel getLivro() {
		return livro;
	}
	public void setLivro(LivroModel livro) {
		this.livro = livro;
	}
	public ClienteModel getCliente() {
		return cliente;
	}
	public void setCliente(ClienteModel cliente) {
		this.cliente = cliente;
	}
	public String getDataFim() {
		return dataFim;
	}
	public void setDataFim(String dataFim) {
		this.dataFim = dataFim;
	}
	
	
	
	
	
	
	
	
	

}
