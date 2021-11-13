package com.horaciojr.calculator.model;

import java.io.Serializable;

public class Numbers implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private double a;
	
	private double b;
	
	public Numbers() {}

	public Numbers(double a, double b) {
		super();
		this.a = a;
		this.b = b;
	}

	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}
	
}
