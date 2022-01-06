package com.macgarcia.github.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.macgarcia.github.model.Pais;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Long> {

}
