package com.qa.service.webservice;

import com.qa.persistence.domain.BabyName;

public interface IConsumeGenerator {

	public String generateName(int length, String name);

	public String persistBabyName(BabyName name);

	public void deleteBabyName(Long id);

}
