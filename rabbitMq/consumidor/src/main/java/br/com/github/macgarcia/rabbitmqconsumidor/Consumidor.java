package br.com.github.macgarcia.rabbitmqconsumidor;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

import br.com.github.macgarcia.rabbitmqconsumidor.service.LogService;

@Configuration
public class Consumidor {

	@Value("${rabbitmq.user}")
	private String user;

	@Value("${rabbitmq.pass}")
	private String pass;

	@Value("${rabbitmq.host}")
	private String host;

	@Autowired
	private LogService service;	

	@Bean
	public void consumirMensagem() throws IOException, TimeoutException {

		final String queue = "Produtor";

		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost(host);
		factory.setUsername(user);
		factory.setPassword(pass);

		Connection connection = factory.newConnection();

		Channel channel = connection.createChannel();
		channel.queueDeclare(queue, false, false, false, null);

		DeliverCallback deliverCallback = (consumerTag, delivery) -> {

			String message = new String(delivery.getBody(), "UTF-8");
			
			System.out.println("Iniciar processamento...");
			this.processarMensagem(message);
			System.out.println("processada.");
			
		};

		channel.basicConsume(queue, true, deliverCallback, consumerTag -> {
		});
	}

	private void processarMensagem(final String msg) {
		this.service.processarMensagem(msg);
	}
}
