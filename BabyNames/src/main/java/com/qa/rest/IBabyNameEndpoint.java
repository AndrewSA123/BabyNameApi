package com.qa.rest;

import java.util.Optional;

import com.qa.persistence.domain.BabyName;

public interface IBabyNameEndpoint {

	public String createName(BabyName name);

	public Iterable<BabyName> getAllBabies();

	public String deleteBabyName(Long id);

	public BabyName updatebabyName(Long id, BabyName name);

	public Optional<BabyName> getBabyById(Long id);

}
