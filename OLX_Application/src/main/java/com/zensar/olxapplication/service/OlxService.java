package com.zensar.olxapplication.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.zensar.olxapplication.dto.OlxDto;
import com.zensar.olxapplication.entity.Olx;


public interface OlxService {
	List<OlxDto> getAllUser(int pageNumber,int pageSize);

	String signInDetails(String userName, String password, String token);

	OlxDto createOlxUser(OlxDto olx, String token);

	String deleteUser(int userId);

}
