package com.zensar.olxadvertiseapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.olxadvertiseapp.advertiseService.AdvertiseService;
import com.zensar.olxadvertiseapp.entity.OlxAdverties;
import com.zensar.olxadvertiseapp.entity.OlxRequest;
import com.zensar.olxadvertiseapp.entity.OlxResponse;

@RestController
public class OlxAdvertiesController {
@Autowired
	private AdvertiseService advertiseService;

	@RequestMapping(value = "/advertise", method = RequestMethod.POST)
	public ResponseEntity<OlxAdverties> createOlxUser(@RequestBody OlxRequest olx,
			@RequestHeader("auth-token") String token) {
		OlxResponse olxAdd = advertiseService.createOlxUser(olx, token);
		if (olxAdd == null) {
			return new ResponseEntity<OlxAdverties>(HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<OlxAdverties>(HttpStatus.CREATED);
		}
	}

	@GetMapping(value = "/user/advertise")
	public List<OlxResponse> getAll(@RequestParam(value = "pageNumber", defaultValue = "0", required = false) int pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "5", required = false) int pageSize) {

		return advertiseService.getAll(pageNumber, pageSize);
	}

	@RequestMapping(value = "user/advertise/{id}", method = RequestMethod.GET)
	public OlxResponse getSpecificAdd(@PathVariable("id") int id) {
		return advertiseService.getSpecificAdd(id);

	}

	@PutMapping("/advertise/{id}")
	public OlxResponse updateStock(@PathVariable("id") int id, @RequestBody OlxRequest olxAdverties) {
		return advertiseService.updateStock(id, olxAdverties);
	}

	@DeleteMapping("/user/advertise/{id}")
	public String deleteUser(@PathVariable int id) {
		return advertiseService.deleteUser(id);

	}
}
