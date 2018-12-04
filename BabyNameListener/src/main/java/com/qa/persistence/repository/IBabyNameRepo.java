package com.qa.persistence.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.qa.persistence.domain.BabyNameToSend;

@Repository
public interface IBabyNameRepo extends MongoRepository<BabyNameToSend, Long> {

}
