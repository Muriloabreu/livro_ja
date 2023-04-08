package com.api.livro_ja.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.livro_ja.models.ClienteModel;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteModel, UUID>{

	boolean existsByCpf(String cpf);
}
