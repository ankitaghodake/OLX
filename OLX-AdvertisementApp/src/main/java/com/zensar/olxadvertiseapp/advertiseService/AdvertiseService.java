package com.zensar.olxadvertiseapp.advertiseService;

import java.util.List;

import org.springframework.web.bind.annotation.RequestHeader;

import com.zensar.olxadvertiseapp.entity.OlxAdverties;
import com.zensar.olxadvertiseapp.entity.OlxRequest;
import com.zensar.olxadvertiseapp.entity.OlxResponse;

public interface AdvertiseService {
	OlxResponse createOlxUser(OlxRequest olx, String token);
	List<OlxResponse> getAll(int pageNumber, int pageSize);
	OlxResponse getSpecificAdd(int id);
	OlxResponse updateStock(int id, OlxRequest olxrequest);
	String deleteUser(int id);
	
	
}
