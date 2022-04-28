package br.com.github.macgarcia.rabbitmqconsumidor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.github.macgarcia.rabbitmqconsumidor.entity.LogInformativo;

@Repository
public interface LogInformativoRepository extends JpaRepository<LogInformativo, Long> {

}
