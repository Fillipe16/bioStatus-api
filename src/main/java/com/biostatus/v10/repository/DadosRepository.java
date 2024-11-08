package com.biostatus.v10.repository;

import com.biostatus.v10.model.entity.Dados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DadosRepository extends JpaRepository<Dados,Long> {
}
