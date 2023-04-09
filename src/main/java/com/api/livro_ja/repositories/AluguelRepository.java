package com.api.livro_ja.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.livro_ja.models.AluguelModel;
import com.api.livro_ja.models.ClienteModel;
import com.api.livro_ja.models.LivroModel;

public interface AluguelRepository extends JpaRepository<AluguelModel, UUID> {
	

}
