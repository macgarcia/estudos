package br.com.github.macgarcia.rabbitmqconsumidor.service;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.github.macgarcia.rabbitmqconsumidor.entity.LogInformativo;
import br.com.github.macgarcia.rabbitmqconsumidor.repository.LogInformativoRepository;

@Service
public class LogService {

	private final ObjectMapper mapper;
	private final LogInformativoRepository dao;
	
	@Autowired
	public LogService(final ObjectMapper mapper, final LogInformativoRepository dao) {
		this.mapper = mapper;
		this.dao = dao;
	}
	
	@Transactional
	public void processarMensagem(final String msg) {
		try {
			LogInformativo novoLog = this.mapper.readValue(msg, LogInformativo.class);
			this.dao.saveAndFlush(novoLog);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}

}
