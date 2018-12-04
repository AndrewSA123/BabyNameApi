package com.qa.service;

import org.springframework.stereotype.Service;

import com.qa.constants.Constant;

@Service
public class GeneratorService implements IGeneratorService {

	private int rand;

	@Override
	public String createName(int length, String name) {
		for (int i = 0; i < length; i++) {
			if (name.length() >= length) {
				return name;
			}
			rand = (int) (Math.random() * 25);
			name += Constant.alpha[rand];
		}
		return name;
	}

}
