package com.qa.service;

import com.qa.persistence.domain.BabyNameToSend;

public interface IMongoService {

	public String deleteMongo(Long id);

	public String createMongo(BabyNameToSend name);

	public String updateMongo(Long id, BabyNameToSend name);

}
