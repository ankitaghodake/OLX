package com.zensar.olxadvertiseapp.advertiseService;

import java.util.List;

import org.springframework.web.bind.annotation.RequestHeader;

import com.zensar.olxadvertiseapp.entity.OlxAdverties;

public interface AdvertiseService {
	OlxAdverties createOlxUser(OlxAdverties olx, String token);
	List<OlxAdverties> getAll();
	OlxAdverties getSpecificAdd(int id);
	OlxAdverties updateStock(int id, OlxAdverties olxAdverties);
	String deleteUser(int id);
	
	
}
