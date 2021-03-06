package br.com.github.macgarcia.rabbitmqprodutor;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import br.com.github.macgarcia.rabbitmqprodutor.model.LogInformativo;

@Configuration
public class Produtor {
	
	@Value("${rabbitmq.user}")
	private String user;
	
	@Value("${rabbitmq.pass}")
	private String pass;
	
	@Value("${rabbitmq.host}")
	private String host;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Bean
	public void criarMensagem() throws Exception {
		
		final String queue = "Produtor";
		
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost(host);
		factory.setUsername(user);
		factory.setPassword(pass);
		
		Connection connection = factory.newConnection();
		
		Channel channel = connection.createChannel();
		channel.queueDeclare(queue, false, false, false, null);
		
		int count = 0;
		while(count < 500) {
			
			LogInformativo log = new LogInformativo("Objeto nº" + count, Instant.now(), "Servico de inserção.");
			String json = mapper.writeValueAsString(log);
			
			channel.basicPublish("", queue, null, json.getBytes());
			
			System.out.println(log);
			count++;
		}	
	}

}
