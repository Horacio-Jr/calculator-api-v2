package com.horaciojr.calculator.config;

import java.util.HashMap;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit
public class BeansConfig {

	@Bean
	public ConnectionFactory connectionFactory() {
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory("localhost");
		connectionFactory.setUsername("guest");
		connectionFactory.setPassword("guest");
		connectionFactory.setPort(5672);
		return connectionFactory;
	}

	@Bean
	public RabbitAdmin amqpAdmin() {
		return new RabbitAdmin(connectionFactory());
	}

	@Bean
	public RabbitTemplate rabbitTemplate() {
		return new RabbitTemplate(connectionFactory());
	}

	@Bean
	public Exchange exchangeSumOperation() {
		return new DirectExchange("SUM-OPERATION-EXCHANGE");
	}

	@Bean
	public Exchange exchangeSumResult() {
		return new DirectExchange("SUM-RESULT-EXCHANGE");
	}

	@Bean
	public Exchange exchangeSubOperation() {
		return new DirectExchange("SUB-OPERATION-EXCHANGE");
	}

	@Bean
	public Exchange exchangeSubResult() {
		return new DirectExchange("SUB-RESULT-EXCHANGE");
	}

	@Bean
	public Exchange exchangeMultOperation() {
		return new DirectExchange("MULT-OPERATION-EXCHANGE");
	}

	@Bean
	public Exchange exchangeMultResult() {
		return new DirectExchange("MULT-RESULT-EXCHANGE");
	}

	@Bean
	public Exchange exchangeDivOperation() {
		return new DirectExchange("DIV-OPERATION-EXCHANGE");
	}

	@Bean
	public Exchange exchangeDivResult() {
		return new DirectExchange("DIV-RESULT-EXCHANGE");
	}

	@Bean
	public Queue sum() {
		return new Queue("SUM");
	}

	@Bean
	public Queue sumResult() {
		return new Queue("SUM-RESULT");
	}

	@Bean
	public Queue sub() {
		return new Queue("SUB");
	}

	@Bean
	public Queue subResult() {
		return new Queue("SUB-RESULT");
	}

	@Bean
	public Queue mult() {
		return new Queue("MULT");
	}

	@Bean
	public Queue multResult() {
		return new Queue("MULT-RESULT");
	}

	@Bean
	public Queue div() {
		return new Queue("DIV");
	}

	@Bean
	public Queue divResult() {
		return new Queue("DIV-RESULT");
	}

	@Bean
	public Binding declareBindingSumA() {
		return new Binding("SUM", Binding.DestinationType.QUEUE, "SUM-OPERATION-EXCHANGE", "A", new HashMap<>());
	}

	@Bean
	public Binding declareBindingSumResult() {
		return new Binding("SUM-RESULT", Binding.DestinationType.QUEUE, "SUM-RESULT-EXCHANGE", "#", new HashMap<>());
	}

	@Bean
	public Binding declareBindingSubA() {
		return new Binding("SUB", Binding.DestinationType.QUEUE, "SUB-OPERATION-EXCHANGE", "A", new HashMap<>());
	}

	@Bean
	public Binding declareBindingSubResult() {
		return new Binding("SUB-RESULT", Binding.DestinationType.QUEUE, "SUB-RESULT-EXCHANGE", "#", new HashMap<>());
	}

	@Bean
	public Binding declareBindingMultA() {
		return new Binding("MULT", Binding.DestinationType.QUEUE, "MULT-OPERATION-EXCHANGE", "A", new HashMap<>());
	}

	@Bean
	public Binding declareBindingMultResult() {
		return new Binding("MULT-RESULT", Binding.DestinationType.QUEUE, "MULT-RESULT-EXCHANGE", "#", new HashMap<>());
	}

	@Bean
	public Binding declareBindingDivA() {
		return new Binding("DIV", Binding.DestinationType.QUEUE, "DIV-OPERATION-EXCHANGE", "A", new HashMap<>());
	}

	@Bean
	public Binding declareBindingDivResult() {
		return new Binding("DIV-RESULT", Binding.DestinationType.QUEUE, "DIV-RESULT-EXCHANGE", "#", new HashMap<>());
	}

}
