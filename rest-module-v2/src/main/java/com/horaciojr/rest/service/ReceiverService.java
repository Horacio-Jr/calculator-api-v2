package com.horaciojr.rest.service;

import com.horaciojr.calculator.model.Result;

public interface ReceiverService {

	Result getSumResult();

	void setSumResult(Result result);

	Result getSubResult();

	void setSubResult(Result result);

	Result getDivbResult();

	void setDivResult(Result result);

	Result getMultbResult();

	void setMultResult(Result result);

}
