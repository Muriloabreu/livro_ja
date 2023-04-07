package com.api.livro_ja.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.livro_ja.models.LivroModel;

@Repository
public interface LivroRepository extends JpaRepository<LivroModel, UUID>{
	
	boolean existsbytitulo(String titulo);
}
