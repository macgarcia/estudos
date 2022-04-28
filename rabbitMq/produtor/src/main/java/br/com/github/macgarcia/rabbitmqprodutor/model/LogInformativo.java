package br.com.github.macgarcia.rabbitmqprodutor.model;

import java.io.Serializable;
import java.time.Instant;

public class LogInformativo implements Serializable {

	private static final long serialVersionUID = 1L;

	private final String mensagem;
	private final Instant dataHora;
	private final String nomeServico;

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
