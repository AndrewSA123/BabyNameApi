package com.qa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.constants.Constants;
import com.qa.persistence.domain.BabyNameToSend;
import com.qa.persistence.repository.IBabyNameRepo;
import com.qa.util.BabyNameUtil;

@Service
public class MongoService implements IMongoService {

	@Autowired
	private IBabyNameRepo repo;

	@Autowired
	private BabyNameUtil util;

	@Override
	public String deleteMongo(Long id) {
		repo.deleteById(id);
		return Constants.delete;
	}

	@Override
	public String createMongo(BabyNameToSend name) {
		repo.save(name);
		return Constants.create;
	}

	@Override
	public String updateMongo(Long id, BabyNameToSend name) {
		repo.save(util.updateBabyName(repo.findById(id).get(), name));
		return Constants.updated;
	}

}
