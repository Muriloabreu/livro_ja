package com.api.livro_ja.repositories;


import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.livro_ja.models.AluguelModel;


public interface AluguelRepository extends JpaRepository<AluguelModel, UUID> {
	

}
