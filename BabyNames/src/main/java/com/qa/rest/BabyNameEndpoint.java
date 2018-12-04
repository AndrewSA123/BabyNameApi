package com.qa.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.persistence.domain.BabyName;
import com.qa.service.IBabyNameService;

@RestController
@RequestMapping("${endpoint.base}")
public class BabyNameEndpoint implements IBabyNameEndpoint {

	@Autowired
	private IBabyNameService service;

	@Override
	@PostMapping("${endpoint.create}")
	public String createName(@RequestBody BabyName name) {
		return service.createName(name);
	}

	@Override
	@GetMapping("${endpoint.getall}")
	public Iterable<BabyName> getAllBabies() {
		return service.getAllBabies();
	}

	@Override
	@DeleteMapping("${endpoint.delete}")
	public String deleteBabyName(@PathVariable("id") Long id) {
		return service.deleteBabyName(id);
	}

	@Override
	@PutMapping("${endpoint.update}")
	public BabyName updatebabyName(@PathVariable("id") Long id, @RequestBody BabyName name) {
		return service.updatebabyName(id, name);
	}

	@Override
	@GetMapping("${endpoint.getbyid}")
	public Optional<BabyName> getBabyById(@PathVariable("id") Long id) {
		return service.getBabyById(id);
	}

}
