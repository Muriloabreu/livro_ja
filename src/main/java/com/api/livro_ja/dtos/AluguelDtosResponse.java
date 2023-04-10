package com.api.livro_ja.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

import com.api.livro_ja.models.AluguelModel;




public class AluguelDtosResponse {
	
	
	private UUID id;	
	
	private String nomeLivro;	
	
    private String clienteNome;	

	private LocalDateTime dataInicio;
	
	private String dataFim;

	public AluguelDtosResponse() {
		super();
	}
	public AluguelDtosResponse(AluguelModel model) {
		
		id = model.getId();
		nomeLivro = model.getLivro().getTitulo();
		clienteNome = model.getCliente().getNome();
		dataInicio = model.getDataInicio();
		dataFim = model.getDataFim();
	}

	public AluguelDtosResponse(UUID id, String livro, String cliente, LocalDateTime dataInicio,
			String dataFim) {
		super();
		this.id = id;
		this.nomeLivro = livro;
		this.clienteNome = cliente;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
	}

	public UUID getId() {
		return id;
	}

	public LocalDateTime getDataInicio() {
		return dataInicio;
	}

	public String getDataFim() {
		return dataFim;
	}
	public String getNomeLivro() {
		return nomeLivro;
	}
	public String getClienteNome() {
		return clienteNome;
	}
	
	
	
	
	

}
