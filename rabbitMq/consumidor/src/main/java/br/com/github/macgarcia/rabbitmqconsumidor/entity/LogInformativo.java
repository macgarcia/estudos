package br.com.github.macgarcia.rabbitmqconsumidor.entity;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Logs")
@SequenceGenerator(name = "logs_seq", sequenceName = "logs_seq", initialValue = 1, allocationSize = 1)
public class LogInformativo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "logs_seq")
	private Long id;

	@Column(name = "mensagen")
	private String mensagem;
	
	@Column(name = "data_hora")
	private Instant dataHora;
	
	@Column(name = "nome_servico")
	private String nomeServico;
	
	public LogInformativo() {}

	public LogInformativo(String mensagem, Instant dataHora, String nomeServico) {
		this.mensagem = mensagem;
		this.dataHora = dataHora;
		this.nomeServico = nomeServico;
	}

	public String getMensagem() {
		return mensagem;
	}

	public Instant getDataHora() {
		return dataHora;
	}	

	public String getNomeServico() {
		return nomeServico;
	}

	@Override
	public String toString() {
		return "LogInformativo [mensagem=" + mensagem + ", dataHora=" + dataHora + ", nomeServico=" + nomeServico + "]";
	}

}
