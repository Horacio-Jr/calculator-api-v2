package com.horaciojr.rest.service.impl;

import org.springframework.stereotype.Component;

import com.horaciojr.calculator.model.Result;
import com.horaciojr.rest.service.ReceiverService;

@Component
public class ReceiverServiceImpl implements ReceiverService {
	
	private Result sumResult;
	
	private Result subResult;
	
	private Result divResult;
	
	private Result multResult;

	@Override
	public Result getSumResult() {
		return sumResult;
	}

	@Override
	public void setSumResult(Result result) {
		this.sumResult = result;
	}

	@Override
	public Result getSubResult() {
		return subResult;
	}

	@Override
	public void setSubResult(Result result) {
		this.subResult = result;
	}

	@Override
	public Result getDivbResult() {
		return divResult;
	}

	@Override
	public void setDivResult(Result result) {
		this.divResult = result;
	}

	@Override
	public Result getMultbResult() {
		return multResult;
	}

	@Override
	public void setMultResult(Result result) {
		this.multResult = result;
	}

}
