package com.qa.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.service.IGeneratorService;

@RestController
@RequestMapping("${endpoint.base}")
public class GeneratorEndpoint implements IGeneratorEndpoint {

	@Autowired
	private IGeneratorService service;

	@Override
	@GetMapping("${endpoint.create}")
	public String createName(@PathVariable("length") int length, @PathVariable("name") String name) {
		return service.createName(length, name);
	}

}
