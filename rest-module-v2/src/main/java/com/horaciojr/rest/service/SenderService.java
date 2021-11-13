package com.horaciojr.rest.service;

import com.horaciojr.calculator.model.Numbers;

public interface SenderService {
	
	void sum(Numbers numbers);

	void sub(Numbers numbers);
	
	void div(Numbers numbers);
	
	void mult(Numbers numbers);
}
