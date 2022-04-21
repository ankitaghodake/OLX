package com.zensar.olxadvertiseapp.controller;

import java.util.ArrayList;
import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.zensar.olxadvertiseapp.entity.OlxAdverties;

@RestController
public class OlxAdvertiesController {

	OlxAdverties olx = new OlxAdverties();
	List<OlxAdverties> userAdvertiesDetails = new ArrayList<OlxAdverties>();

	public OlxAdvertiesController() {
		userAdvertiesDetails.add(new OlxAdverties(1, "Laptop sale", 54000, "electronics good", "Intel core 3 sony viao",
				"ankita", 2104, 2104, "Open"));
	}

	@RequestMapping(value = "/advertise", method = RequestMethod.POST)
	public ResponseEntity<OlxAdverties> createOlxUser(@RequestBody OlxAdverties olx,
			@RequestHeader("auth-token") String token) {
		if (token.contentEquals("ag66543")) {
			userAdvertiesDetails.add(olx);

		} else {
			return new ResponseEntity<OlxAdverties>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<OlxAdverties>(olx, HttpStatus.CREATED);
	}

	@GetMapping(value = "/user/advertise")
	public List<OlxAdverties> getAll() {

		return userAdvertiesDetails;
	}

	@RequestMapping(value ="user/advertise/{id}", method = RequestMethod.GET)
	public OlxAdverties getAllAdd(@PathVariable("id") int id) {
		OlxAdverties olx=new OlxAdverties();
		if(olx.getId()==id) {
			return olx;
		}
		return olx;
		
	}

	@PutMapping("/advertise/{id}")
	public OlxAdverties updateStock(@PathVariable("id") int id, @RequestBody OlxAdverties olxAdverties) {
		OlxAdverties availableAdd = getAllAdd(id);
		availableAdd.setUserName(olxAdverties.getUserName());
		availableAdd.setTitle(olxAdverties.getTitle());
		availableAdd.setPrice(olxAdverties.getPrice());
		return olxAdverties;
	}
	
	@DeleteMapping("/user/advertise/{id}")
	public String deleteUser(@PathVariable int id) {
		for(OlxAdverties olx:userAdvertiesDetails) {
			if(olx.getId()==id) {
				userAdvertiesDetails.remove(olx);
				return "Deleted successfully!!";
			}
		}
		return "Deletion failed";
	}

}
