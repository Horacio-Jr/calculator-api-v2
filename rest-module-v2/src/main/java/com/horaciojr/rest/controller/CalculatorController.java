package com.horaciojr.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.horaciojr.calculator.model.Numbers;
import com.horaciojr.calculator.model.Result;
import com.horaciojr.rest.service.ReceiverService;
import com.horaciojr.rest.service.SenderService;

@RestController
@RequestMapping("calculator")
public class CalculatorController {
	
	@Autowired
	private SenderService senderService;
	
	@Autowired
	private ReceiverService receiverService;

	@GetMapping(value = "/sum")
	public ResponseEntity<Result> sum(@RequestParam(value = "a", defaultValue = "0") double a,
			@RequestParam(value = "b", defaultValue = "0") double b) {
		senderService.sum(new Numbers(a, b));
		return ResponseEntity.ok().body(receiverService.getSumResult());
	}

	@GetMapping(value = "/sub")
	public ResponseEntity<Result> sub(@RequestParam(value = "a", defaultValue = "0") double a,
			@RequestParam(value = "b", defaultValue = "0") double b) {
		senderService.sub(new Numbers(a, b));
		return ResponseEntity.ok().body(receiverService.getSubResult());
	}

	@GetMapping(value = "/div")
	public ResponseEntity<Result> div(@RequestParam(value = "a", defaultValue = "0") double a,
			@RequestParam(value = "b", defaultValue = "0") double b) {
		senderService.div(new Numbers(a, b));
		return ResponseEntity.ok().body(receiverService.getDivbResult());
	}

	@GetMapping(value = "/multiply")
	public ResponseEntity<Result> multiply(@RequestParam(value = "a", defaultValue = "0") double a,
			@RequestParam(value = "b", defaultValue = "0") double b) {
		senderService.mult(new Numbers(a, b));
		return ResponseEntity.ok().body(receiverService.getMultbResult());
	}

}
