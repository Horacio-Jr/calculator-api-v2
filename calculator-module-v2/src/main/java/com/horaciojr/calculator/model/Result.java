package com.horaciojr.calculator.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Result implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private BigDecimal result;
	
	public Result() {}

	public Result(BigDecimal result) {
		super();
		this.result = result;
	}

	public BigDecimal getResult() {
		return result;
	}

	public void setResult(BigDecimal result) {
		this.result = result;
	}
	
}
