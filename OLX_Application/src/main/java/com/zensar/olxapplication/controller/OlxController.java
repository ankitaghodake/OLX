package com.zensar.olxapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.olxapplication.dto.OlxDto;
import com.zensar.olxapplication.entity.Olx;
import com.zensar.olxapplication.service.OlxService;

@RestController
public class OlxController {
	@Autowired
	private OlxService olxService;
	


	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public ResponseEntity<Olx> createOlxUser(@RequestBody OlxDto olx, @RequestHeader("auth-token") String token) {
		OlxDto olxResult = olxService.createOlxUser(olx, token);
		if (olxResult == null) {
			return new ResponseEntity<Olx>(HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<Olx>(HttpStatus.CREATED);
		}
	}

	@GetMapping("/user")
	public List<OlxDto> getAllUser(@RequestParam(value = "pageNumber", defaultValue = "0", required = false) int pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "5", required = false) int pageSize) {

		return olxService.getAllUser(pageNumber, pageSize);

	}

	// @PostMapping
	@RequestMapping(value = "/user/authenticate", method = RequestMethod.POST)
	public String signInDetails(@RequestBody(required = false) String userName,
			@RequestBody(required = false) String password, @RequestHeader("auth-token") String token) {
		return olxService.signInDetails(userName, password, token);

	}

	@DeleteMapping("/user/logout/{userId}")
	public String deleteUser(@PathVariable int userId) {
		return olxService.deleteUser(userId);

	}
}
