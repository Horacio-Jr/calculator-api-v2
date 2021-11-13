package com.horaciojr.rest.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.horaciojr.calculator.model.Result;
import com.horaciojr.rest.service.ReceiverService;

@Component
public class ResultListenerService {
	
	private static Logger LOGGER = LoggerFactory.getLogger(ResultListenerService.class);
	
	@Autowired
	private ReceiverService receiverService;
	
	@RabbitListener(queues = {"SUM-RESULT"})
	public void sumResult(Result rs) {
		LOGGER.info("{}", rs.getResult());
		receiverService.setSumResult(rs);
	}
	
	@RabbitListener(queues = {"SUB-RESULT"})
	public void subResult(Result rs) {
		LOGGER.info("{}", rs.getResult());
		receiverService.setSubResult(rs);
	}
	
	@RabbitListener(queues = {"DIV-RESULT"})
	public void divResult(Result rs) {
		LOGGER.info("{}", rs.getResult());
		receiverService.setDivResult(rs);
	}
	
	@RabbitListener(queues = {"MULT-RESULT"})
	public void multResult(Result rs) {
		LOGGER.info("{}", rs.getResult());
		receiverService.setMultResult(rs);
	}

}
