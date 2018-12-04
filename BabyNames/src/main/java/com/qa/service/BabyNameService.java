package com.qa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.constants.Constant;
import com.qa.persistence.domain.BabyName;
import com.qa.persistence.repository.IBabyNameRepo;
import com.qa.service.webservice.IConsumeGenerator;
import com.qa.util.BabyNameUtil;

@Service
public class BabyNameService implements IBabyNameService {

	@Autowired
	private IBabyNameRepo repo;

	@Autowired
	private BabyNameUtil util;

	@Autowired
	private IConsumeGenerator generator;


	private String nameToGenerate;

	@Override
	public String createName(BabyName name) {
		nameToGenerate = generator.generateName(name.getLength(), name.getName());
		for (String illegalName : Constant.illegalNames) {
			if (name.getName().toLowerCase().equals(illegalName.toLowerCase()) || name.getLength() >= 12) {
				return Constant.failed;
			}
		}
		name.setName(nameToGenerate);
		repo.save(name);
		generator.persistBabyName(name);
		return Constant.created;
	}

	@Override
	public Iterable<BabyName> getAllBabies() {
		return repo.findAll();
	}

	@Override
	public String deleteBabyName(Long id) {
		repo.deleteById(id);
		generator.deleteBabyName(id);
		return Constant.deleted;
	}

	@Override
	public BabyName updatebabyName(Long id, BabyName name) {
		return repo.save(util.updateBabyName(repo.findById(id).get(), name));
	}

	@Override
	public Optional<BabyName> getBabyById(Long id) {
		return repo.findById(id);
	}

}
