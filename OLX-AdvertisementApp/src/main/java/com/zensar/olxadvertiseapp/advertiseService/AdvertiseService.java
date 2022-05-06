package com.zensar.olxadvertiseapp.advertiseService;

import java.util.List;

import com.zensar.olxadvertiseapp.dto.OlxAddDto;

public interface AdvertiseService {
	OlxAddDto createOlxUser(OlxAddDto olx, String token);
	List<OlxAddDto> getAll();
	OlxAddDto getSpecificAdd(int id);
	OlxAddDto updateStock(int id, OlxAddDto olxrequest);
	String deleteUser(int id);
	
	
}
