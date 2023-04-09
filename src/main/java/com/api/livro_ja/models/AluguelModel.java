package com.api.livro_ja.models;



import java.time.LocalDateTime;
import java.util.UUID;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_ALUGUEL")
public class AluguelModel  {


	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;	
	@ManyToOne
	@JoinColumn(name = "livro_id")
	private LivroModel livro;	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
    private ClienteModel cliente;	
	@Column(nullable = false)
	private LocalDateTime dataInicio;
	@Column(nullable = false,  length = 10)
	private String dataFim;
	
	

	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
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
	
	public LocalDateTime getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(LocalDateTime dataInicio) {
		this.dataInicio = dataInicio;
	}
	public String getDataFim() {
		return dataFim;
	}
	public void setDataFim(String dataFim) {
		this.dataFim = dataFim;
	}
	
	public AluguelModel(LivroModel livro, ClienteModel cliente, LocalDateTime dataInicio, String dataFim) {
		super();
		this.livro = livro;
		this.cliente = cliente;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
	}
	public AluguelModel() {
		
	}
	
	
	
	
	
}
