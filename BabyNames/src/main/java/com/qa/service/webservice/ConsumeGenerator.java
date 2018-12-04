package com.qa.service.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.qa.constants.Constant;
import com.qa.persistence.domain.BabyName;
import com.qa.util.BabyNameUtil;

@RestController
public class ConsumeGenerator implements IConsumeGenerator {

	@Autowired
	private RestTemplate rest;

	@Autowired
	private JmsTemplate jms;

	@Autowired
	private BabyNameUtil util;

	@Override
	@GetMapping
	public String generateName(int length, String name) {
		return rest.getForObject(Constant.Consume + length + "/" + name, String.class);
	}

	@Override
	@PostMapping
	public String persistBabyName(BabyName name) {

		jms.convertAndSend(Constant.queueName, util.toPOJO(name));

		return Constant.queued;
	}

	@Override
	public void deleteBabyName(Long id) {
		jms.convertAndSend(Constant.deleteQueue, id);
	}

}
