package br.com.github.macgarcia.rabbitmqprodutor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

@Configuration
public class Produtor {
	
	@Bean
	public void criarMensagem() throws Exception {
		
		final String queue = "Produtor";
		
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		factory.setUsername("admin");
		factory.setPassword("marcos1985");
		//factory.setPort(8081);
		
		Connection connection = factory.newConnection();
		
		Channel channel = connection.createChannel();
		channel.queueDeclare(queue, false, false, false, null);
		String message = "Hello World 5!";
		channel.basicPublish("", queue, null, message.getBytes());
		
	}

}
