package com.zensar.olxapplication.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.zensar.olxapplication.entity.Olx;
import com.zensar.olxapplication.entity.OlxRequest;
import com.zensar.olxapplication.entity.OlxResponse;

public interface OlxService {
	List<OlxResponse> getAllUser(int pageNumber,int pageSize);

	String signInDetails(String userName, String password, String token);

	OlxResponse createOlxUser(OlxRequest olx, String token);

	String deleteUser(int userId);

}
