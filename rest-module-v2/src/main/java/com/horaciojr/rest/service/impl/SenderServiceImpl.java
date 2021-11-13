package com.horaciojr.rest.service.impl;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.horaciojr.calculator.model.Numbers;
import com.horaciojr.rest.service.SenderService;

@Component
public class SenderServiceImpl implements SenderService {
	
	@Autowired
	private RabbitTemplate messager;
	
	@Override
	public void sum(Numbers numbers) {
		messager.convertAndSend("SUM-OPERATION-EXCHANGE", "A", numbers);
	}

	@Override
	public void sub(Numbers numbers) {
		messager.convertAndSend("SUB-OPERATION-EXCHANGE", "A", numbers);
	}

	@Override
	public void div(Numbers numbers) {
		messager.convertAndSend("DIV-OPERATION-EXCHANGE", "A", numbers);
	}

	@Override
	public void mult(Numbers numbers) {
		messager.convertAndSend("MULT-OPERATION-EXCHANGE", "A", numbers);
	}

}
