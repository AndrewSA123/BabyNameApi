package com.qa.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.qa.constants.Constants;
import com.qa.persistence.domain.BabyNameToSend;
import com.qa.service.IMongoService;

@Component
@CrossOrigin
public class Consumer {

	@Autowired
	private IMongoService service;

	@JmsListener(destination = Constants.queueName, containerFactory = "myFactory")
	public String createMongo(BabyNameToSend name) {
		return service.createMongo(name);
	}

	@JmsListener(destination = Constants.deleteQueue, containerFactory = "myFactory")
	public String deleteMongo(Long id) {
		return service.deleteMongo(id);
	}

}
