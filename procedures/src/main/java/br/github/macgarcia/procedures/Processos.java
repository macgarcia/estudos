package br.github.macgarcia.procedures;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Processos {

	@PersistenceContext
	private EntityManager manager;

//	@Bean
//	@Transactional
//	public void excuteProcedureA() {
//		try {
//			final Query query = this.manager.createNativeQuery("call processo_teste_a (?,?)");
//			query.setParameter(1, 1).setParameter(2, "Primeiro teste");
//			query.executeUpdate();
//		} catch (Exception e) {
//			e.getMessage();
//		}
//	}

	@Bean
	@Transactional
	public void executeFuncaoB() {
		try {
			final String sql = "select funcao_b(?,?) from dual ";
			final Query query = this.manager.createNativeQuery(sql);
			query.setParameter(1, 34).setParameter(2, 3);
			final BigDecimal result = (BigDecimal) query.getSingleResult();
			System.out.println("Resultado da função: " + result);
		} catch (Exception e) {
			e.getMessage();
		}
	}

}
