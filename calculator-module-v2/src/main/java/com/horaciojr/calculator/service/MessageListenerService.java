package com.horaciojr.calculator.service;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import com.horaciojr.calculator.model.Numbers;
import com.horaciojr.calculator.model.Result;

@Component
public class MessageListenerService {

	private static Logger LOGGER = LoggerFactory.getLogger(MessageListenerService.class);

	@RabbitListener(queues = { "SUM" })
	@SendTo("SUM-RESULT")
	public Result sum(Numbers data, @Header(AmqpHeaders.CONSUMER_QUEUE) String queue) {
		LOGGER.info("**** Operação de Soma ****");
		return new Result(new BigDecimal(data.getA() + data.getB()));
	}

	@RabbitListener(queues = { "SUB" })
	@SendTo("SUB-RESULT")
	public Result sub(Numbers data, @Header(AmqpHeaders.CONSUMER_QUEUE) String queue) {
		LOGGER.info("**** Operação de Subtração ****");
		return new Result(new BigDecimal(data.getA() - data.getB()));
	}

	@RabbitListener(queues = { "DIV" })
	@SendTo("DIV-RESULT")
	public Result div(Numbers data, @Header(AmqpHeaders.CONSUMER_QUEUE) String queue) {

		try {
			LOGGER.info("**** Operação de Divisão ****");
			double result = data.getA() / data.getB();
			return new Result(new BigDecimal(result));

		} catch (ArithmeticException error) {
			LOGGER.info("ERROR {} => ", error.getMessage());
		}
		return new Result(new BigDecimal(0));
	}

	@RabbitListener(queues = { "MULT" })
	@SendTo("MULT-RESULT")
	public Result mult(Numbers data, @Header(AmqpHeaders.CONSUMER_QUEUE) String queue) {
		LOGGER.info("**** Operação de Multiplicação ****");
		return new Result(new BigDecimal(data.getA() * data.getB()));
	}

}
