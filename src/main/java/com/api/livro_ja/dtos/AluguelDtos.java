package com.api.livro_ja.dtos;

import java.util.UUID;

import com.api.livro_ja.models.ClienteModel;
import com.api.livro_ja.models.LivroModel;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class AluguelDtos {
	
	
	private UUID livroId;
	
	private UUID clienteId;
	
	private String dataFim;
	
	
	public UUID getLivroId() {
		return livroId;
	}
	public void setLivroId(UUID livroId) {
		this.livroId = livroId;
	}
	public UUID getClienteId() {
		return clienteId;
	}
	public void setClienteId(UUID clienteId) {
		this.clienteId = clienteId;
	}
	public String getDataFim() {
		return dataFim;
	}
	public void setDataFim(String dataFim) {
		this.dataFim = dataFim;
	}
	
	public AluguelDtos( ) {
		
	}
	
	public AluguelDtos( UUID livro_id,  UUID cliente_id,  String dataFim) {
		super();
		this.livroId = livro_id;
		this.clienteId = cliente_id;
		this.dataFim = dataFim;
	}
	@Override
	public String toString() {
		return "AluguelDtos [livro_id=" + livroId + ", cliente_id=" + clienteId + ", dataFim=" + dataFim + "]";
	}
	
	
	
	
	

}
