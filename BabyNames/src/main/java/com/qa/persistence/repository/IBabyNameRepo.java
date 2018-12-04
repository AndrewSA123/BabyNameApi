package com.qa.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.qa.persistence.domain.BabyName;

@Repository
public interface IBabyNameRepo extends CrudRepository<BabyName, Long> {

}
