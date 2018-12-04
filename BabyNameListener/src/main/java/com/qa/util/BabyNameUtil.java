package com.qa.util;

import org.springframework.stereotype.Component;

import com.qa.persistence.domain.BabyNameToSend;

@Component
public class BabyNameUtil {

	private BabyNameToSend toSend;

	private Long id = 0l;

	public BabyNameToSend updateBabyName(BabyNameToSend persistedName, BabyNameToSend newName) {
		persistedName.setId(newName.getId());
		persistedName.setName(newName.getName());
		return persistedName;
	}

	public BabyNameToSend toPOJO(BabyNameToSend name) {
		toSend = new BabyNameToSend(name.getId(), name.getName(), name.getLength());

		return toSend;
	}

}
