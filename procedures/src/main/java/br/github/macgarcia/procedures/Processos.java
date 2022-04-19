package br.github.macgarcia.procedures;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Processos {
	
	private static final String PROCESSO_TESTE_A = "call processo_teste_a (?,?)";
	private static final String FUNCAO_A = "select funcao_b(?,?) from dual ";
	private static final String PROCESSO_TESTE_B = "call processo_teste_b(?)";
	

	@PersistenceContext
	private EntityManager manager;

	@Bean
	@Transactional
	public void excuteProcedureA() {
		try {
			final Query query = this.manager.createNativeQuery(PROCESSO_TESTE_A);
			query.setParameter(1, 1).setParameter(2, "Primeiro teste");
			query.executeUpdate();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	@Bean
	@Transactional
	public void executeFuncaoB() {
		try {
			final Query query = this.manager.createNativeQuery(FUNCAO_A);
			query.setParameter(1, 34).setParameter(2, 3);
			final BigDecimal result = (BigDecimal) query.getSingleResult();
			System.out.println("Resultado da função: " + result);
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	
	@Bean
	@Transactional
	public void executeProcessoB() {
		try {
			final Query query = this.manager.createNativeQuery(PROCESSO_TESTE_B);
			query.setParameter(1,LocalDate.now());
			query.executeUpdate();
		} catch (Exception e) {
			e.getMessage();
		}
	}

}
