package com.zensar.olxapplication.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.zensar.olxapplication.entity.Olx;

public interface OlxService {
	List<Olx> getAllUser();

	String signInDetails(String userName, String password, String token);

	Olx createOlxUser(Olx olx, String token);

	String deleteUser(int userId);

}
